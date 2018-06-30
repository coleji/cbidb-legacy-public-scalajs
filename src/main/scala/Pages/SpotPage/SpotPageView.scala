package Pages.SpotPage

import Pages.SpotPage.SpotPageModel.{NoOwner, P1, P2, Square}
import VNode.SnabbdomFacade.VNode
import _root_.VNode._
import core.{Message, View}

import scala.scalajs.js

class SpotPageView(render: VNode => Unit) extends View[SpotPageModel](render) {
  private val view = this

  object Highlight extends Message[SpotPageModel, Square] {
    def update: SpotPageModel => Square => SpotPageModel =
      model => square => model.highlight(square)
  }

  object Move extends Message[SpotPageModel, Square] {
    def update: SpotPageModel => Square => SpotPageModel =
      model => square => {
        println("attempting a move")
        model.move(square)
      }
  }

  def apply(model: SpotPageModel): VNode = {
    table(props=Map("cellpadding" -> "5"), contents=tbody(
      model.board.map(row => tr(
        row.map(c => {
          val color = c.owner match {
            case NoOwner => "white"
            case P1 => if (model.highlighted.isDefined && model.highlighted.get == c) "#128ced" else "#0c5a99"
            case P2 => if (model.highlighted.isDefined && model.highlighted.get == c) "#d41a3e" else "#8c1129"
          }
          val events: Map[String, js.Any] = c.owner match {
            case NoOwner => {
              if (model.highlighted.isDefined && model.turn == model.highlighted.get.owner) Map("click" -> (() => Move(this)(model)(c)))
              else Map.empty
            }
            case P1 => {
              if (model.turn == P1) Map("click" -> (() => Highlight(this)(model)(c)))
              else Map.empty
            }
            case P2 => {
              if (model.turn == P2) Map("click" -> (() => Highlight(this)(model)(c)))
              else Map.empty
            }
          }
          td(
            events=events,
            style=Map("height" -> "60px", "width" -> "60px", "border" -> "1px solid black", "background-color" -> color)
          )
        })
      ))
    ))
  }
}
