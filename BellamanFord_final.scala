

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.control.Breaks._
object BellamanFord_final {
  def main(args:Array[String]): Unit ={
    val g1 = new graph(5)

    g1.AddWeightEdge(0,1,-1)
    g1.AddWeightEdge(0,2,4)
    g1.AddWeightEdge(1,2,3)
    g1.AddWeightEdge(1,4,5)
    g1.AddWeightEdge(1,3,2)
    g1.AddWeightEdge(3,2,5)
    g1.AddWeightEdge(3,1,1)
    g1.AddWeightEdge(4,3,-3)

    g1.Bellman()
    g1.result()
  }
  class graph(V: Int) {
    val verts:Int = V
    var AdjList = new Array[ArrayBuffer[Array[Int]]](V)
    for(i<-0 to V-1){
      AdjList(i) = new ArrayBuffer[Array[Int]]
    }

    var SPT = new ArrayBuffer[Int](V)
    val Dist = new Array[Int](verts)  //Distance Array
    val Pred = new Array[Int](verts)  //predecessor Array



    def AddWeightEdge(u: Int, v: Int, w: Int): Unit = {
      AdjList(u).append(Array(v,w))
    }

    def print_list():Unit={
      for(i<-0 to AdjList.length-1){
        println(AdjList(i))
      }

    }
    def countOfEdges(): Int= {
      var count = 0
      for (i <- 0 to verts - 1) {
        count = count + AdjList(i).length
      }
      return count
    }


    def Bellman() = {
      val c: Int =  countOfEdges()


      for(i<- 0 until verts){
        Dist(i)= 999999
        Pred(i) = 0
      }
      Dist(0)=0

      for(i<-1 to V-1){  //V-1 no. of times this relaxation is done..
        for(j<- 0 until V){    //All edges(total number of edges =c) are relaxed V-1 no. of times
          val u = AdjList(j)
          val l = u.length
          for(k<-0 until l){
            val v = u(k)(0)
            val w = u(k)(1)
            if(Dist(j)!= 999999 && Dist(v) > Dist(j) + w){
              Dist(v) = Dist(j) + w
              Pred(v) = j                  // it tells the predecessor of every vertex in the array and by backtracking we can calculate the shortest path to every vertex
            }
          }
        }
      }
      breakable{
        for(j<- 0 until V){    //All edges(total number of edges =c) are relaxed V-1 no. of times
          val u = AdjList(j)
          val l = u.length

          for(k<-0 until l){
            val v = u(k)(0)
            val w = u(k)(1)
            if(Dist(j)!= 9999 && Dist(v) > Dist(j) + w){
              println("Negative weight cycle detected!")
              break
            }
          }
        }
      }
    }
    def result(): Unit ={
      println("Min distance Array")
      for(i<-0 until Dist.length){
        var a = Dist(i)
        print(s"""$a, """)
        println()
      }
      println("predecessor array")
      for(i<-0 until Pred.length){
        var p = Pred(i)
        print(s"$p, ")
      }
    }

  }


}
