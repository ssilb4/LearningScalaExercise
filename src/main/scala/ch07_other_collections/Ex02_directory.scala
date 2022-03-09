package ch07_other_collections

object Ex02_directory extends App{
    val files = new java.io.File(".").listFiles.toList
    val fileList = files map (_.getName)  filter (! _.startsWith("."))
    println(fileList.mkString(";"))
}