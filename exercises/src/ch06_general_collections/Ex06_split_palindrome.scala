package ch06_general_collections

object Ex06_split_palindrome extends App{
  def isPalindrome(s: String): Boolean = {
    if (s == s.reverse) {
      true
    } else{
      false
    }
  }
  def splitPalindrome(items: List[String]): (List[String], List[String]) = {
    //items.partition(x => isPalindrome(x))
    (items.filter(x => isPalindrome(x)), items.filter(x => !isPalindrome(x)))
  }
  print(splitPalindrome(List("ab","bb","cdc", "asd","e")))
}
