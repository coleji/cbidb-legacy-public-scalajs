package core

import CbiUtil.Initializable
import Pages.AsyncPage.AsyncPage
import Pages.CounterPage.CounterPage
import Pages.LoginPage.LoginPage
import Pages.ReportPage.ReportPage
import Pages.SpotPage.SpotPage
import Pages.StringReversePage.StringReversePage
import Pages.UsersPage.UsersPage
import VNode.SnabbdomFacade.VNode
import core.Main.Globals
import fr.hmil.roshttp.HttpRequest
import fr.hmil.roshttp.response.SimpleHttpResponse

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.util.{Failure, Success}

object Router {
  val render = new Initializable[VNode => Unit]
  // TODO: make better
  def route(path: String): Future[Page[_]] = {
    import monix.execution.Scheduler.Implicits.global
    val p = Promise[Page[_]]
    val page = path match {
      case "/counter" => CounterPage(render.get)
      case "/string-reverse" => StringReversePage(render.get)
      case "/async" => AsyncPage(render.get)
      case "/users" => UsersPage(render.get)
      case "/login" => LoginPage(render.get)
      case "/spot" => SpotPage(render.get)
      case _ => ReportPage(render.get)
    }
    p.success(page)
    p.future
  }

  def transition(path: String): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val emptyObj: js.Object = js.Dynamic.literal()
    Globals.history.pushState(emptyObj, "", path)
    route(path).map(p => p.renderPage())
  }
}
