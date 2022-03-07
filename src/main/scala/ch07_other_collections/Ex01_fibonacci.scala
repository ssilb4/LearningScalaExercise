package ch07_other_collections

import scala.collection.mutable.Buffer

object Ex01_fibonacci extends App{
    def fibonacciWithBuffer(length: Int): List[Int] = {
        if (length == 1) {
            return List(1)
        } else if (length == 2) {
            return List(2)
        }
        var b = Buffer(1,1)
        for (i <- 3 to length) {
            b += b(b.length-1) + b(b.length-2)
        }   
        b.toList
    }
    println(fibonacciWithBuffer(1))
    println(fibonacciWithBuffer(2))
    println(fibonacciWithBuffer(5))
    println(fibonacciWithBuffer(10))
    def fibonacciAppend(list: List[Int], addLength: Int): List[Int] = {
        if (list.length < 2) {
            return Nil
        }
        var b = list.toBuffer
        for (i <- 1 to addLength) {
            b += b(b.length-1) + b(b.length-2)
        }   
        b.toList
    }
    println(fibonacciAppend(List(1,2,3),5))
    println(fibonacciAppend(List(2,2,5),10))

    def fibonacciWithStream(i: Int, j: Int): Stream[Int] = Stream.cons(i, fibonacciWithStream(j, i+j))
    fibonacciWithStream(1,1).take(100).toList.foreach(print)

    println("")
    def nextFibonacci(current: Int): Int = {
        var b = Buffer(1,1)
        while(true) {
            b += b(b.length-1) + b(b.length-2)
            if (b(b.length-1) == current) {
                return b(b.length-1) + b(b.length-2)
            } else if (b(b.length-1) > current) {
                return -1
            }
        }   
        -1
    }
    println(nextFibonacci(10))
    println(nextFibonacci(13))
}