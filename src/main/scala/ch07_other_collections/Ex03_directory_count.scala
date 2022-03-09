package ch07_other_collections

object Ex03_directory_count extends App{
    val files = new java.io.File(".").listFiles.toList
    val fileList = files map (_.getName)  filter (! _.startsWith(".")) map (_.toLowerCase)
    for  (a <- 'a' to 'z') {
        println(a.toString + ":" + fileList.filter(_.startsWith(a.toString)).length)
    }
}