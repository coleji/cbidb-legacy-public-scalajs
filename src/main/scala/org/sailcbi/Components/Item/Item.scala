package org.sailcbi.Components.Item

import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode._

import scala.scalajs.js.JSConverters._

trait Item {
  def asTR(itemID: String, itemLabel: String, extraCells: Option[VNodeContents[_]]): VNode
  protected def asTR(itemID: String, itemLabel: String, isPassword: Boolean, extraCells: Option[VNodeContents[_]]): VNode = {
    val baseCells: List[VNodeContents[_]] = List(
      td(style=Map("text-align"->"right"), contents=VNodeContents(
        label(id=itemID+"_LABEL", props=Map("for"->itemID), contents=
          span(classes=List("optional"), contents=itemLabel)
        )
      )),
      td(style=Map("text-align"->"left"), contents=VNodeContents(
        input(
          id=itemID,
          classes=List("text_field", "apex-item-text"),
          props=Map("type"->"text", "name"->itemID, "size"->"25", "maxlength"->"100")
        )
      ))
    )
    val allCells: VNodeContents[_] = extraCells match {
      case None => baseCells.toJSArray
      case Some(c) => (baseCells :+ c).toJSArray
    }
    tr(contents=allCells)
  }
}
