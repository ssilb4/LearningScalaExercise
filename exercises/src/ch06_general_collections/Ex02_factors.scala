package ch06_general_collections

object Ex02_factors extends App{
  def factors(num:Int): List[Int] = {
    (2 until num ).filter(num % _ == 0).toList
  }
  println(factors(10))

  def listFactors(nums:List[Int]) = {
    nums.flatMap(factors)
  }
  println(listFactors(List(9,11,15)))
}
