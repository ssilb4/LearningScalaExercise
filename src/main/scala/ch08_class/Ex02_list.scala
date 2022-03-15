package ch08_class

class MyList[T](val elements:T*){
    val element: T = elements(0)
    def next = {
        new MyList(elements.tail:_*)
    }
    def isNextNull():Boolean = {
        if(elements.length == 1){
            true
        } else {
            false
        }
    }
    def foreach(f: T=>Unit): Unit = {
        f(element)
        if (!next.isNextNull()){
            next.foreach(f)
        } else {
            f(next.element)
        }
    }
}

object Ex02_main  extends App {
    val list = new MyList(1,2,3)
    println(list.element)
    println(list.next.element)
    list.foreach(println)
}