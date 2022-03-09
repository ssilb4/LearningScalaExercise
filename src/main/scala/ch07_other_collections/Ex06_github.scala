package ch07_other_collections


object Ex06_github extends App{
    def getRss(info: (String, String, String)) = {
        val (user, repo, branch) = info
        val u = s"https://github.com/$user/$repo/commits/$branch"
        val s = io.Source.fromURL(u)
        val text = s.getLines.map(_.trim).mkString("")
        val texts = text.split("<entry>")

        val pattern = raw".*<title>(.*)</title>.*<updated>(.*)</updated>.*<author><name>(.*)</name>.*".r
        texts.foreach(t => {
            t match {
                        case pattern(title, date, author) => {
                            println(s"title: $title")
                            println(s"date: $date")
                            println(s"author: $author")
                        }
                        case _ => {}
                    }
        })
    }
    def getRss(url: String) = {
        val s = io.Source.fromURL(url)
        val text = s.getLines.map(_.trim).mkString("")
        val texts = text.split("<entry>")
        println(texts)

        val pattern = raw".*<title>(.*)</title>.*<updated>(.*)</updated>.*<author><name>(.*)</name>.*".r
        texts.foreach(t => {
            t match {
                        case pattern(title, date, author) => {
                            println(s"title: $title")
                            println(s"date: $date")
                            println(s"author: $author")
                        }
                        case _ => {println(t)}
                    }
        })
    }
    
    import scala.concurrent.Future
    import scala.concurrent.ExecutionContext

    implicit val context: ExecutionContext = scala.concurrent.ExecutionContext.global

    val rss = getRss(("scala","scala","2.11.x.atom"))
    Future.sequence(List(Future(getRss(("akka","akka","master")))))
    /*
    Future.sequence(List(Future(getRss("https://github.com/akka/akka/tree/master"))))
    Future.sequence(List(Future(getRss("https://github.com/akka/akka/tree/master"))
                                        ,Future(getRss("https://github.com/scala/scala/tree/2.11.x"))
                                        ,Future(getRss("https://github.com/sbt/sbt/tree/0.13"))
                                        ,Future(getRss("https://github.com/scalaz/scalaz/tree/series/7.2.x"))))
    */
}