package org.sailcbi.Core

import org.sailcbi.VNode.SnabbdomFacade.VNode

abstract class View[T <: Model](val render: VNode => Unit) {
  def apply(m: T): VNode
}
