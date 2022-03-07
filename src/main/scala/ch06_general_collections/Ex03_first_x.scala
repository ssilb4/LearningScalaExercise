package ch06_general_collections

object Ex03_first_x extends App{
  def firstX[A](items: List[A], count: Int): List[A] = {
    (1 to count).map(items(_)).toList
  }
  print(firstX(List("123","as","34ff"),2))
}
