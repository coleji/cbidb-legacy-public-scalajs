package org.sailcbi.Pages.LoginPage

import org.sailcbi.Core.Main.Globals
import org.sailcbi.Core.{Main, View}
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._

import scala.scalajs.js

class LoginPageView (render: VNode => Unit) extends View[LoginPageModel](render) {
  def apply(model: LoginPageModel): VNode = {
    form(
      props = Map("method" -> "post", "action" -> (Main.API_LOCATION + "/authenticate")),

    )
  }
}
