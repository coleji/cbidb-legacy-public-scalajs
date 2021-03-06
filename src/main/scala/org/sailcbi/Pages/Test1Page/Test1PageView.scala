package org.sailcbi.Pages.Test1Page

import org.sailcbi.Core.Router
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode.{VNodeContents, div, span}
import org.sailcbi.ViewTemplates.JoomlaMain

import scala.scalajs.js

class Test1PageView(renderer: VNode => Unit) extends JoomlaMain[Test1PageModel](renderer) {
  override val defaultModel: Test1PageModel = new Test1PageModel

  val goToTest2: js.Function0[Unit] = () => {
    Router.transition("/test2")
  }

  override def getMain(model: Test1PageModel): VNode = div(VNodeContents(
    "Test 1!",
    span(events=Map("click" -> goToTest2), contents="go to test2")
  ))
}
