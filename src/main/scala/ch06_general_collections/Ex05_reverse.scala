package ch06_general_collections

import scala.annotation.tailrec

object Ex05_reverse extends App{
  @tailrec
  def reverse[A](items: List[A], reverses: List[A]): List[A] = {
    (items, reverses) match {
      case (Nil, _) => reverses
      case (_, _) => reverse(items.tail, items.head :: reverses)
    }
  }
  print(reverse(List("a","b","c", "d","e"), Nil))
}
