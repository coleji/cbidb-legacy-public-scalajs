package org.sailcbi.Components

import org.sailcbi.VNode.SnabbdomFacade.VNode
import org.sailcbi.VNode.{div, h2}

import scala.scalajs.js

object JoomlaArticleRegion {
  def apply(id: String, title: String, body: VNode): VNode =
    div(id=id, classes=List("rt-article"), contents=js.Array(
      div(classes=List("article-header"), contents=
        h2(contents=title)
      ),
      div(classes=List("article-body"), contents=body),
      div(classes=List("articcle-buttons"), style=Map("margin-top"->"15px"))
    ))
}
