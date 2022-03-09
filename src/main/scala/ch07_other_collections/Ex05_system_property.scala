package ch07_other_collections

object Ex05_system_property extends App{
    def getProperty(s: String): String = {
        //val option = Option(s)
        //if (option.isDefined) {
        //    Option(System.getProperty(option))
        //}
        Option(s) match {
            case None => {
                "error"
            }
            case Some("") => {
                "error"
            }
            case Some(s) => {
                Option(System.getProperty(s)).getOrElse("error")
            }
        }
    }
    println(getProperty("java.home"))
    println(getProperty(""))
    println(getProperty("1"))
}