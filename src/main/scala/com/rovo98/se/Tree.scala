package com.rovo98.se

/**
 * Pattern matching demo [simple usage]
 *
 * @author rovo98
 */
abstract class Tree {

  case class Sum(l: Tree, r: Tree) extends Tree

  case class Var(n: String) extends Tree

  case class Const(v: Int) extends Tree

}