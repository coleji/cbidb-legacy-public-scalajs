package Pages.SpotPage

import VNode.SnabbdomFacade.VNode
import core.Page

case class SpotPage(render: (VNode => Unit)) extends Page[SpotPageModel](render) {
  val defaultModel: SpotPageModel = SpotPageModel.startingBoard(7)
  val view = new SpotPageView(render)
}