package org.sailcbi.Components.Item

import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._

object Text extends Item{
  override def asTR(itemID: String, itemLabel: String, extraCells: Option[VNodeContents[_]] = None): SnabbdomFacade.VNode =
    asTR(itemID, itemLabel, isPassword = false, extraCells)
}
