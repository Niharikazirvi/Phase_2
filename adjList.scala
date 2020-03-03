
package Example

import scala.collection.mutable.ListBuffer
object adjList {
  def main(args: Array[String]): Unit = {
    var g1 = new graph1(4)
    g1.add_edge(0, 1)
    g1.add_edge(0, 2)
    g1.add_edge(1, 2)
    g1.add_edge(2, 3)
    g1.display_graph()
  }

  class graph1(n:Int){
    var AdjList=new Array[ListBuffer[Int]](n)

    for(i<- 0 until n){
      AdjList(i) = new ListBuffer[Int]
      AdjList(i).prepend(i:Int)
    }

    def add_edge(i:Int,j:Int){
      AdjList(i)+=j
      AdjList(j)+=i
    }
    def void_edge(i:Int,j:Int): Unit ={
      AdjList(i)-=j
      AdjList(j)-=i
    }
    def display_graph(): Unit ={
      for(i<-0 until n){


        println(AdjList(i))

      }
    }
  }
}
