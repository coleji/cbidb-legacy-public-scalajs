package org.sailcbi.Pages.LoginPage

import org.sailcbi.Components.JoomlaArticleRegion
import org.sailcbi.Core.Main.Globals
import org.sailcbi.Core.{Main, View}
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._
import org.sailcbi.ViewTemplates.JoomlaMain

import scala.scalajs.js

class LoginPageView (renderer: VNode => Unit) extends JoomlaMain[LoginPageModel](renderer) {
  override val defaultModel: LoginPageModel = LoginPageModel(None, None)
  def getMain(model: LoginPageModel): VNode = {
    val text =
      """
        |If you are new to Community Boating and would like to purchase a Junior Program membership for your child, <b>click on the first option</b> to the right.  Once your child's registration is complete you can return here to sign him/her up for classes and view his/her progression throughout the summer.<br>
        |<br>
        |If you were looking for <b>Adult Program</b> registration, please <a href="f?p=&AI_AP_APP_ID.:101">click here!</a>
      """.stripMargin
    JoomlaArticleRegion("hello", "Welcome to CBI Online!<br>-  Junior Program  -", span(contents=text))
  }
}
