package org.sailcbi.Components.Item
import org.sailcbi.Components.Item.Text.asTR
import org.sailcbi.VNode.{SnabbdomFacade, VNodeContents}

object Password extends Item {
  override def asTR(itemID: String, itemLabel: String, extraCells: Option[VNodeContents[_]] = None): SnabbdomFacade.VNode =
    asTR(itemID, itemLabel, isPassword = true, extraCells)
}
