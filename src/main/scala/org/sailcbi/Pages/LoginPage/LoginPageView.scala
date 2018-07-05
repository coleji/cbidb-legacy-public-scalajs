package org.sailcbi.Pages.LoginPage

import org.sailcbi.Components.JoomlaArticleRegion
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode.VNodeContents._
import org.sailcbi.VNode._
import org.sailcbi.ViewTemplates.JoomlaTwoColumns

import scala.scalajs.js

class LoginPageView (renderer: VNode => Unit) extends JoomlaTwoColumns[LoginPageModel](renderer) {
  override val defaultModel: LoginPageModel = LoginPageModel(None, None)
  def getLeft(model: LoginPageModel): VNode = {
    val text = VNodeContents(
      "If you are new to Community Boating and would like to purchase a Junior Program membership for your child, ",
      b(contents="click on the first option"),
      "  to the right.  Once your child's registration is complete you can return here to sign him/her up for classes and view his/her progression throughout the summer.",
      br(),
      br(),
      "If you were looking for ",
      b("Adult Program"),
      "  registration, please ",
      aPlaceholder("click here!")
    )
    JoomlaArticleRegion("hello", VNodeContents("Welcome to CBI Online!", br(), "-  Junior Program  -"), span(contents=text))
  }
  def getRight(model: LoginPageModel): VNode = div("hi!")
}
