package org.sailcbi.ViewTemplates

import org.sailcbi.Core.{Main, Model, View}
import org.sailcbi.Pages.LoginPage.LoginPageModel
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode.form

abstract class JoomlaMain[T <: Model](renderer: VNode => Unit) extends View[T](renderer){
  def getMain(model: T): VNode
  def getVNode(model: T): VNode = getMain(model)
}
