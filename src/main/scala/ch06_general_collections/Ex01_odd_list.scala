package ch06_general_collections

object Ex01_odd_list extends App{
  val l = 1 to 20
  print(l.map(_ * 2 - 1))
}