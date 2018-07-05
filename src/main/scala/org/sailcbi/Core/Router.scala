package org.sailcbi.Core

import org.sailcbi.CbiUtil.Initializable
import org.sailcbi.Core.Main.Globals
import org.sailcbi.Pages.LoginPage.LoginPageView
import org.sailcbi.VNode.SnabbdomFacade.VNode

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Router {
  val renderer = new Initializable[VNode => Unit]
  // TODO: make better
  def route(path: String): Future[View[_]] = {
    val p = Promise[View[_]]
    val page = path match {
      case _ => new LoginPageView(renderer.get)
    }
    p.success(page)
    p.future
  }

  def transition(path: String): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val emptyObj: js.Object = js.Dynamic.literal()
    Globals.history.pushState(emptyObj, "", path)
    route(path).map(p => p.initialRender())
  }
}
