import scala.collection.mutable.ArrayBuffer
object Travelling_salesaman_final{def main(args:Array[String]): Unit ={ // complete graph already // different weights from A to B and B to A
  val g =new Graph(4)                                               // based on hamiltonian cycle with minimun weighted path using recursion
  g.AddWeightEdge(0,0,0)
  g.AddWeightEdge(0,1,16)
  g.AddWeightEdge(0,2,11)
  g.AddWeightEdge(0,3,6)
  g.AddWeightEdge(1,0,8)
  g.AddWeightEdge(1,1,0)
  g.AddWeightEdge(1,2,13)
  g.AddWeightEdge(1,3,16)
  g.AddWeightEdge(2,0,4)
  g.AddWeightEdge(2,1,7)
  g.AddWeightEdge(2,2,0)
  g.AddWeightEdge(2,3,9)
  g.AddWeightEdge(3,0,5)
  g.AddWeightEdge(3,1,12)
  g.AddWeightEdge(3,2,2)
  g.AddWeightEdge(3,3,0)
  var list1 =new ArrayBuffer[Int]()
  list1 = ArrayBuffer() // Arraybuffe to store weights to calculate the minimun weight
  g.tsp(list1, 0, n=4, 1, 0 , 999999)
  println(list1.min)
}
  class Graph(n:Int){
    val verts = n
    var AdjList = new Array[ArrayBuffer[Array[Int]]](verts)
    for(i<-0 to verts-1){
      AdjList(i) = new ArrayBuffer[Array[Int]]
    }
    val visited = new Array[Boolean](verts)
    for(i<- 0 until verts){
      visited(i)= false
    }

    visited(0) = true

    def AddWeightEdge(u: Int, v: Int, w: Int): Unit = {
      AdjList(u).append(Array(v,w))
    }

    def min(a:Int, b:Int): Int ={
      if(a<b){
        return a
      }
      else{
        return b
      }
    }

    def checking_edge(currpos: Int, vert2:Int): Int= {  //checking if two vertices have an egde
      val u = AdjList(currpos)
      val l = u.size
      var a =0
      for (i <- 0 until l ) {
        val v:Array[Int] = u(i)

        val v1=v(0)
        val v2=v(1)
        if(vert2 == v1) {
          a = v2
          return a
        }
        else{
          a= 0
        }

      }
      return a
     }
    val l = (verts-2)*(verts-1)


    def tsp(list1:ArrayBuffer[Int],currPos:Int, n:Int, count:Int, cost:Int,  ans:Int): Unit={
      var ans2 = ans
      if(count==n) {                                     // in Dfs traversal last vertex is encounter , this is when it is checked there is a path between the last and the
                                                        // first edge so as to end the hamiltonian graph at the start edge only.
        val weight1 = checking_edge(currPos, 0)
        if (!(weight1 == 0)) {
          ans2 = min(ans2, cost + weight1)             // the last edge is compared for the least value
          list1+= ans2
        }
        return
      }

      else{
        for(i<-0 until verts){                    // if not the last vertex then traverse the rest of the vertices in dfs order with an individual traversal path and keep
          val weightx = checking_edge(currPos,i)
         if(!visited(i)&& !(weightx==0)){
            visited(i) = true
            val g = cost + weightx                // calculating the cost with every new vertex traversed
            tsp(list1,i,n,count+1, g, ans)
            visited(i) = false
          }
        }
      }
    }
 }
}
