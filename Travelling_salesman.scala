import scala.collection.mutable.ArrayBuffer

object Travelling_salesman{
  def main(args:Array[String]): Unit ={
    val g =new Graph(4)
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
    //g.tsp( 0, n=4, 1, 0 , 999999)
    g.printsol()


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
    var ans:Int = 9999999

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

    def checking_edge(currpos: Int, vert2:Int): Int= {
      val u = AdjList(currpos)
      val l = u.size
      var a =0
      for (i <- 0 until l ) {
        val v:Array[Int] = u(i)
        if (v(0) == vert2) {
          a = v(1)

        }
        else{
          a = 0
        }

      }
      return a

    }

    def tsp(currPos:Int, n:Int, count:Int, cost:Int,  ans:Int): Boolean ={
      //val u = AdjList(currPos)
      var ans2 = ans
      val weight1 = checking_edge(currPos, 0)

      if(count==n) {

        if (!(weight1 == 0)) {
          var ans2 = ans
          ans2 = min(ans2, cost + weight1)
          println(ans2)
          return true
        }
        else{
          return false
        }
      }

      for(i<-0 until verts){
        val weightx = checking_edge(currPos,i)
        if(!visited(i)&& !(weightx==0)){
          visited(i) = true
          if(tsp(i,n,count+1, cost+weightx, ans)){
            return true
          }
          visited(i) = false
        }
      }
      return false

    }
    def printsol(): Unit ={
      var res = tsp( 0, n=4, 1, 0 , 999999)
      if(res){
        println(ans2)
      }
      else{
        println("no solution")
      }
    }


  }
}
