package ch08_class
import java.text.SimpleDateFormat;  

class Console(val make: String, val model: String, val debutDate: java.util.Date,  val wifiType: Option[String], val pysicalFormat: List[String], val resolve: List[String]) {
    override def toString(): String = {
        make + model
    }
}

class Consoles {
    val c1 = new Console("a","a", new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2007"),Some("g"),List("a","b"), List("100*80"))
    val c2 = new Console("b","b", new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2007"),Some("g"),List("a","b"), List("100*80"))
    val c3 = new Console("c","c", new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2007"),Some("g"),List("a","b"), List("100*80"))
    val c4 = new Console("d","d", new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2007"),Some("g"),List("a","b"), List("100*80"))
}

class Game(val name: String, val maker: String, val consoles: List[Console]) {
    def isSupported(console: Console): Boolean = {
        consoles.contains(console)
    }
}

object Ex01_main  extends App {
    val cs = new Consoles
    val g1 = new Game("a","a",List(cs.c1, cs.c2))
    val g2 = new Game("b","a",List(cs.c2, cs.c3))
    val g3 = new Game("c","d",List(cs.c1, cs.c4))
    val g4 = new Game("d","d",List(cs.c3, cs.c4))

    println(g1.consoles.fold("")((x,y) => x.toString +" "+ y.toString))
    val all = g1.consoles ++ g2.consoles ++ g3.consoles ++ g4.consoles
    all.foreach(
        x=>println(x.toString)
    )

}