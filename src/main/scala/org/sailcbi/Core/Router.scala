package org.sailcbi.Core

import fr.hmil.roshttp.HttpRequest
import fr.hmil.roshttp.response.SimpleHttpResponse
import org.sailcbi.CbiUtil.Initializable
import org.sailcbi.Core.Main.Globals
import org.sailcbi.Pages.ForgotPWPage.ForgotPWPageView
import org.sailcbi.Pages.HomePage.HomePageView
import org.sailcbi.Pages.LoginPage.LoginPageView
import org.sailcbi.Pages.Test1Page.Test1PageView
import org.sailcbi.Pages.Test2Page.Test2PageView
import org.sailcbi.VNode.SnabbdomFacade.VNode

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.util.{Failure, Success}

object Router {
  val renderer = new Initializable[VNode => Unit]
  val enforceLogin = false
  def route(path: String): Future[View[_]] = {
    import monix.execution.Scheduler.Implicits.global
    val p = Promise[View[_]]
    val request = HttpRequest(Main.API_LOCATION + "/is-logged-in-as-staff")
    request.send().onComplete({
      case res:Success[SimpleHttpResponse] => {
        val isLoggedIn: Boolean = res.get.body != "false"
        val pageAndLoginRequired: (View[_], Boolean) = {
          println(path)
          path match {
            // login required:
            case "/home" => (new HomePageView(renderer.get), enforceLogin)
            // login not required:
            case "/forgot" => (new ForgotPWPageView(renderer.get), false)
            case "/test1" => (new Test1PageView(renderer.get), false)
            case "/test2" => (new Test2PageView(renderer.get), false)
            case "/login" => (new LoginPageView(renderer.get), false)
            case _ => (new LoginPageView(renderer.get), false)
          }
        }
        if (pageAndLoginRequired._2 && isLoggedIn) p.success(pageAndLoginRequired._1)
        else if (!pageAndLoginRequired._2) p.success(pageAndLoginRequired._1)
        else p.success(new LoginPageView(renderer.get))

      }
      case _: Failure[SimpleHttpResponse] => p.success(new LoginPageView(renderer.get))
    })
    p.future
  }

  def transition(path: String): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val emptyObj: js.Object = js.Dynamic.literal()
    Globals.history.pushState(emptyObj, "", path)
    route(path).map(p => p.initialRender())
  }
}
