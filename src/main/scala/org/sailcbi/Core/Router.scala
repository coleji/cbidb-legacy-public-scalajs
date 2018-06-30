package org.sailcbi.Core

import org.sailcbi.CbiUtil.Initializable
import org.sailcbi.Core.Main.Globals
import org.sailcbi.Pages.LoginPage.LoginPage
import org.sailcbi.VNode.SnabbdomFacade.VNode

import scala.concurrent.{Future, Promise}
import scala.scalajs.js

object Router {
  val render = new Initializable[VNode => Unit]
  // TODO: make better
  def route(path: String): Future[Page[_]] = {
    val p = Promise[Page[_]]
    val page = path match {
      case _ => LoginPage(render.get)
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
