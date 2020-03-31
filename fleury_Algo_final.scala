import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object fleury_Algo_final {   //for undirected graph

  def main(args:Array[String]) {
    val g1 = new Graph(4)

    g1.addEdge(0, 1);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(1, 0)
    g1.addEdge(2, 3);
    g1.addEdge(2, 1)
    g1.addEdge(2, 0)
    g1.addEdge(3, 2)
    g1.CheckEulerian_EulerianTour()

    g1.printEulerTour();

    val g3 = new Graph(5);
    g3.addEdge(1, 0);
    g3.addEdge(1, 3)
    g3.addEdge(0, 1)
    g3.addEdge(0, 2);
    g3.addEdge(2, 1);
    g3.addEdge(2, 0)
    g3.addEdge(0, 3);
    g3.addEdge(3, 4);
    g3.addEdge(3, 0)
    g3.addEdge(3, 1)
    g3.addEdge(1, 3);
    g3.addEdge(4, 3)
    g3.CheckEulerian_EulerianTour()

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
    def printEulerTour(): Unit = { //since this graph is already considerd eulerian i.e no. of odd degree vertices is even
      // so we just have to find a odd vertex to start from
      var u: Int = 0
      breakable(
        for (i <- 0 until verts) {
          val deg = Adjlist(i).size
          if (deg % 2 != 0) {
            u = i
            break

          }
        }
        )
      printEulerUtil(u)
      println()
    }
    def CheckEulerian_EulerianTour(): Unit ={  //check if the graph is euler nor not if euler--> then proceed otherwise break out

      var u:Int = 0
      var OddDegree:Int  = 0
      breakable {
        for (i <- 0 until verts) {

          val l = Adjlist(i).size
          if (OddDegree==3) {
            //u = i
            println("its not a eulerian graph")
            break
          }
          else{
            if(l%2!=0) {
              OddDegree= OddDegree+1
              u=i
            }
          }
        }

        if(OddDegree<3) {
          println("its a eulerian graph")
          printEulerUtil(u)
          println()
        }
      }


    }


    def printEulerUtil(u:Int): Unit ={ // print the eulerian path or cycle
      val ui = Adjlist(u)
      val l = ui.length
      for(j<-0 until l){
        val v = ui(j)
        if(!(v == -1) && isValidNextEdge(u,v)){
          println(s"$u - $v")
          rmvEdge(u,v)
          printEulerUtil(v)
        }
      }
    }

    def isValidNextEdge(u:Int, v:Int): Boolean ={   // check if the edge is bridge or not
      var count = 0
      val ui = Adjlist(u)
      val l = ui.length
      for(i<- 0 until l){
        if(!(ui(i) == -1)){
          count = count+1
        }
      }
      if(count == 1){ //bridge
        //println("the only edge is the bridge")
        return true
      }
      else {

        val visited = new Array[Boolean](verts)
        for (i <- 0 until verts) {
          visited(i) = false
        }
        val count1 = DFSCount(u, visited)

        rmvEdge(u, v)
        for (i <- 0 until verts) {
          visited(i) = false
        }
        val count2 = DFSCount(u, visited)

        addEdge(u, v)


        if (count1 > count2) {
          return false
        }
        else {
          return true
        }
      }
    }

    def rmvEdge(u:Int, v:Int): Unit ={   //remove an edge and place -1 in its place
      var ui = Adjlist(u)
      val l1 = ui.length
      for(i<-0 until l1){
        if(ui(i)==v){
          ui(i)= -1
        }
      }
      var vi = Adjlist(v)
      val l2 = vi.length
      for(i<-0 until l2){
        if(vi(i)==u){
          vi(i)= -1
        }
      }

    }

    def DFSCount(v:Int, visited:Array[Boolean]): Int ={   //count the number of edges rechable through a vertex by removing an edge if the count before the removnig is more
      // then that edge is a bridge otherwise not
      visited(v) = true
      var count:Int = 1
      val u = Adjlist(v)
      val l = u.length
      for(i<- 0 until l){
        if(!(u(i)== -1) && ! visited(u(i))){
          count = count + DFSCount(u(i), visited)
        }
      }
      count
    }

  }



}