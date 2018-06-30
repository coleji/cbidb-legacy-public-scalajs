package org.sailcbi.Pages.LoginPage

import org.sailcbi.Core.Page
import org.sailcbi.VNode.SnabbdomFacade.VNode

case class LoginPage(render: (VNode => Unit)) extends Page[LoginPageModel](render) {
  val defaultModel: LoginPageModel = LoginPageModel(None, None)
  val view = new LoginPageView(render)
}