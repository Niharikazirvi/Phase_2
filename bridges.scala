import scala.collection.mutable.ArrayBuffer
object bridges {

  def main(args:Array[String]): Unit ={
      val g = new Graph(4)
   g.addEdge(0,1)
    g.addEdge(1,2)
    g.addEdge(1,0)
    g.addEdge(2,1)
    g.addEdge(2,3)
    g.addEdge(3,2)

    g.bridge()
    println()

    val g1 = new Graph(5)
    g1.addEdge(1,0)
    g1.addEdge(1,2)
    g1.addEdge(2,0)
    g1.addEdge(2,1)
    g1.addEdge(0,1)
    g1.addEdge(0,3)
    g1.addEdge(0,2)
    g1.addEdge(3,4)
    g1.addEdge(3,0)
    g1.addEdge(4,3)
     g1.bridge()
    println()

    val g2 = new Graph(7)
    g2.addEdge(0,1)
    g2.addEdge(0,2)
    g2.addEdge(1,0)
    g2.addEdge(1,2)
    g2.addEdge(1,6)
    g2.addEdge(1,3)
    g2.addEdge(1,4)
    g2.addEdge(3,1)
    g2.addEdge(3,5)
    g2.addEdge(4,1)
    g2.addEdge(4,5)
    g2.addEdge(5,3)
    g2.addEdge(5,4)
    g2.addEdge(6,1)
    g2.addEdge(2,0)
    g2.addEdge(2,1)
    g2.bridge()


  }

  class Graph(n:Int){
    val verts = n
    var Adjlist = new Array[ArrayBuffer[Int]](verts)
    for (i <- 0 until verts) {
      Adjlist(i) = new ArrayBuffer[Int]
    }

    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u) += v
    }

    def min(a:Int, b:Int):Int={
      if(a<b){
        return a
      }
      else{
        return b
      }
    }
      var time = 0
    def bridgeUtil(u:Int, visited:Array[Boolean], disc:Array[Int], low:Array[Int], parent:Array[Any]): Unit ={
      //var time:Int = 0
      visited(u)= true
      time = time + 1
      disc(u) = time
      low(u) = time
      val ve = Adjlist(u)
      val l = ve.length
      for(i<-0 until l){
        val v = ve(i)
        if(!visited(v)) {       // recursily travesring non visited adj vertex(all v) of u(strating from source vertex) using DFS traversal
          parent(v) = u
          bridgeUtil(v, visited, disc, low, parent) // coming out of the child vertex v after child vertex has set its disc and low accordingly after traversing its child(if any)
                                            //using DFS traversal and now backtracing to its parent node u for getting its edge(u-v) with parent(u) to be checked as a bridge.
          low(u) = min(low(u), low(v))      // after backtracing this will start implementing, comparing the lows of the adjacent verteices of u with its child v
                                            // which is traversed in DFS order and if it has low lower than the parent itself then the low of u is updated
          if (low(v) > disc(u)) {           // Bridge condition
            print(s"$u - $v edge makes a bridge")
            println()
          }
        }
        else{
          if(v!=parent(u)){  //if the adj vertex is not parent vertex then it recursively compare its low value with the disc of the adj vertex(except parent vertex)
                                            // and out of all them the vertex having min low value becomes u's new low value
            low(u) = min(low(u), disc(v))
          }
        }
      }
    }

    def bridge(): Unit ={
      val visited= new Array[Boolean](verts)
      val disc = new Array[Int](verts)
      val low = new Array[Int](verts)
      val parent = new Array[Any](verts)
      for(i<- 0 until verts){
        parent(i) = null
        visited(i) = false
      }
      //parent(0)= -1
      for(i<- 0 until verts){
        if(!visited(i)){
          bridgeUtil(i,visited, disc, low, parent)
        }
      }
    }
  }
}

