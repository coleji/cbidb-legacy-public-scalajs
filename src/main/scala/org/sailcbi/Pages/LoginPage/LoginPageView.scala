package org.sailcbi.Pages.LoginPage

import org.sailcbi.Core.Main.Globals
import org.sailcbi.Core.{Main, View}
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._
import org.sailcbi.ViewTemplates.JoomlaMain

import scala.scalajs.js

class LoginPageView (renderer: VNode => Unit) extends JoomlaMain[LoginPageModel](renderer) {
  override val defaultModel: LoginPageModel = LoginPageModel(None, None)
  def getMain(model: LoginPageModel): VNode = {
    form(
      props = Map("method" -> "post", "action" -> (Main.API_LOCATION + "/authenticate")),

    )
  }
}
