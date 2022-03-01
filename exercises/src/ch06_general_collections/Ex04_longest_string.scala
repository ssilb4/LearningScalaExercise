package ch06_general_collections

object Ex04_longest_string extends App{
  def longestString(items: List[String]): String = {
    items.reduce((x,y) => if(x.length > y.length) x else y)
  }
  print(longestString(List("asd","qweert","asd","123")))
}
