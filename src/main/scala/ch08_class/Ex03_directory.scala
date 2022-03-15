package ch08_class

class Directory(val location:String) {
    lazy private val _files = new java.io.File(location).listFiles.toList
    lazy val files = _files map (_.getName)  filter (! _.startsWith("."))
    def isExist(file: String): Boolean = {
        if (files.contains(file)) {
            true
        } else {
            false
        }
    }
}

object Ex03_main  extends App {
    val dir = new Directory(".")
    println(dir.isExist("README.md"))
    println(dir.files)
}