import scala.collection.mutable.ArrayBuffer

object prims_final {                     //for unidirected graph
  def main(args: Array[String]): Unit = {
    var g1 = new Graph(5)
    g1.AddWeightEdge(0,1,2)
    g1.AddWeightEdge(0,3,6)
    g1.AddWeightEdge(1,2,3)
    g1.AddWeightEdge(1,4,5)
    g1.AddWeightEdge(1,3,8)
    g1.AddWeightEdge(2,4,7)
    g1.AddWeightEdge(3,4,9)
    g1.AddWeightEdge(1,0,2)
    g1.AddWeightEdge(2,1,3)
    g1.AddWeightEdge(3,1,8)
    g1.AddWeightEdge(3,0,6)
    g1.AddWeightEdge(4,2,7)
    g1.AddWeightEdge(4,1,5)
    g1.AddWeightEdge(4,3,9)
    g1.Prims()
    g1.result()


  }

  class Graph(n: Int) {
    val verts = n
    var G = new Array[ArrayBuffer[Array[Int]]](n)
    for(i<-0 until n){
      G(i) = new ArrayBuffer[Array[Int]]
    }

    var T = new ArrayBuffer[Array[Int]]


    var visited = new Array[Int](n)
    var nonvisited = new Array[Int](n) //this array tells about min weight and also which are not yet visited.
    var mstset = new ArrayBuffer[Int](n)  // we can take another data structure but since we know that a mst ought to have all the vertices treversed.

    def AddWeightEdge(u: Int, v: Int, w: Int): Unit = {
      G(u)+= Array(v, w)
    }

    for (i <- 1 until verts) {
      nonvisited(i) = 232654254
    }
    nonvisited(0) = 0

    def Prims():Unit= {

      var alledge: Int = 0

      def minvalf():Int={
        val f =  (visited).indexOf(0)
        var min = nonvisited(f)
        for(i<- 0 until verts) {
          if(visited(i)==0){// etho enter hi sirf non visited karange taan compare vi sirf ohna de vich hi hovega
            if(nonvisited(i)<=min){
              min = nonvisited(i)
            }
          }
        }
        return (nonvisited).indexOf(min)
      }

      while (alledge < verts) { //untill all edges are visited//for until all visited is 1 //until min of visited is 0

        var u = minvalf() //min value ohna cho hi dekhni jehre already visited nai haige
        if (!(mstset).contains(u)) {
          visited(u) = 1 // transfer that min weighted vetex into visited array making the value of that index true
          mstset += u // from visited adding that vertex into mstset

          val l: Int = (G(u)).length // length here is of the bufferbuffer with that all the vetices ajdacent of that particular vertex
          for (i <- 0 until l) {
            val k = (G(u)) (i)
            val m = k(0)
            if (nonvisited(m) > k(1)) { // putting the weight of the edge as the new value of the edge2
              nonvisited(m) = k(1) // only if its lesser than the previous weight of that edge2
            }
            if(k(1)== nonvisited(u) ) {
              T += Array(k(0), u, nonvisited(u))      //here we are reverse checking the first vertex while second edge is already the u here so while checking all the other
                                                      //edges adjacent to it we check the one with which it has the minimum weight and store the result in reverse order in min spanning tree T
            }
          }

        }
        alledge = alledge +1
      }

      /*
         val pp = T
         val list = pp.toList
         println(list.map(java.util.Arrays.toString))*/
    }

    def result(): Unit ={
      val b= T.length
      for(i <- 0 until b){
        val a:Int = T(i)(0)
        val b:Int = T(i)(1)
        val c:Int= T(i)(2)

        println(s"$a and $b edge has weight $c");//string interpolation

      }
      for(i<- 0 until mstset.length){
        print(mstset(i))
      }
    }

  }

}
