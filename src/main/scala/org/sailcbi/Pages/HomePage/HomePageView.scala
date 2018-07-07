package org.sailcbi.Pages.HomePage

import org.sailcbi.CbiUtil.Currency
import org.sailcbi.Components.{Button, Item, JoomlaArticleRegion}
import org.sailcbi.Pages.LoginPage.LoginPageModel
import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._
import org.sailcbi.ViewTemplates.{JoomlaMain, JoomlaTwoColumns}

class HomePageView(renderer: VNode => Unit) extends JoomlaMain[HomePageModel](renderer) {
  override val defaultModel: HomePageModel = new HomePageModel

  override def getMain(model: HomePageModel): VNode = div("Main!")
}
