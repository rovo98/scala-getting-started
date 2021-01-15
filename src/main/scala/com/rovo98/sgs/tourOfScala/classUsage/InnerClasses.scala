package com.rovo98.sgs.tourOfScala.classUsage

object InnerClasses {
  def main(args: Array[String]): Unit = {

    val graph1: Graph = new Graph
    val node1: graph1.Node = graph1.newNode
    val node2: graph1.Node = new graph1.Node
    val node3: graph1.Node = graph1.newNode
    node1.connectTo(node2)
    node3.connectTo(node1)

    val graph2: Graph = new Graph
    val node4: graph2.Node = graph2.newNode
//    node1.connectTo(node4) // illegal!
    node1.connectTo(node4) // Graph#Node
  }
}

/*
与 Java 类似地，Scala 同样允许使用 inner class 内部类，但有以下注意事项：
1. Scala 中内部类定义的，类路径是独立的（Path-dependent types），如，假设什么在 Graph 类中定义了内部类 Node，Scala 的编译器便能
   有效地防止我们混淆 Nodes 节点它所属的 graph

2. 要想实现与 Java 的内部类同样的使用效果，则应该在定义内部类时，使用 # 符号，如 Graph#Node, 表示接受所有 Graph实例所创建的 Node 类型的实例
 */

class Graph {
  class Node {
    var connectedNodes: List[Graph#Node] = Nil
    def connectTo(node: Graph#Node): Unit = {
      if (!connectedNodes.exists(node.equals)) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}
