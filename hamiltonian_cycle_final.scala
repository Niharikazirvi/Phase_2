import scala.collection.mutable.ArrayBuffer

object hamiltonian_cycle_final {
  def main(args: Array[String]): Unit = {
    val g1 = new Graph(5)
    g1.addEdge(0, 1)
    g1.addEdge(0, 3)
    g1.addEdge(1, 0)
    g1.addEdge(1, 2)
    g1.addEdge(1, 3)
    g1.addEdge(1, 4)
    g1.addEdge(2, 1)
    g1.addEdge(2, 4)
    g1.addEdge(3, 0)
    g1.addEdge(3, 1)
    g1.addEdge(3, 4)
    g1.addEdge(4, 1)
    g1.addEdge(4, 2)
    g1.addEdge(4, 3)
    g1.hamCycle()


    val g = new Graph(5)
    g.addEdge(0, 1)
    g.addEdge(0, 3)
    g.addEdge(1, 0)
    g.addEdge(1, 2)
    g.addEdge(1, 3)
    g.addEdge(1, 4)
    g.addEdge(2, 1)
    g.addEdge(2, 4)
    g.addEdge(3, 0)
    g.addEdge(3, 1)
    g.addEdge(4, 1)
    g.addEdge(4, 2)
    g.hamCycle()


  }

  class Graph(n: Int) {
    val verts = n
    var Adjlist = new Array[ArrayBuffer[Int]](verts)
    for (i <- 0 until verts) {
      Adjlist(i) = new ArrayBuffer[Int]
    }

    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u) += v
    }

    def isSafe(v: Int, path: Array[Int], pos: Int): Boolean = {
      val u = Adjlist(path(pos - 1))  // if the last vertex traversed has a edge with v to be reach to v
      if (!(u.contains(v))) {       // if no edge
        return false
      }


      for (i <- 0 until pos) {    // if that vertex is already traversed
        if (path(i) == v) {
          return false
        }
      }

      return true     // has a vertex
    }


    def hamcycleUtil(path: Array[Int], pos: Int): Boolean = {

      if (pos == verts) {    //if vertex v is the last vertex and the next vertex is the starting vertex  e.g if verts= 5 ...therefore last v = 4...when it will generate util(pos+1)...then come here pos==verts....then pos-1 == 4...will check an edge between itself and start vertex
                                //if the pos has reahed the last vertex and now gonna join the starting vertex again
        val u = Adjlist(path(pos-1))

        if (u.contains(path(0))) {      //checking if this last vertex has an edge between the itself and  start vertex
          return true
        }
        else {
          return false
        }
      }

      // if the v is any other vertex between start and the last vertex
      for (i: Int <- 1 until verts) {    // this is the loop which traverse the v will with every other vertex to find the right path

        if (isSafe(i, path, pos)) {     //checking if its safe to traverse this vertex
          path(pos) = i                 // update the path at pos position


          if (hamcycleUtil(path, pos + 1)) {   // recursion....there will some sequence of vertices traversed in pos+1 order such that everyone will return true and that wil be the hamiltonian cycle
                                                // while traverse if there comes a point  a when util returned false...it will backtrack  from there
                                                // and fill path as -1 at position pos and util start returning false from that pos...
                                                // and starts turning path -1 at pos position from there on...
                                                // and in the end retuurn false to main hamcycle function thus no path..
                                                // the path which will recursively return true and finally true to main function hamcyce will print its path
            return true
          }
          else{
            path(pos) = -1
          }
        }
      }
        return false

    }


    def hamCycle(): Boolean = {
      val path = new Array[Int](verts)
      for (i <- 0 until verts) {
        path(i) = -1
      }

      path(0) = 0

      val res = hamcycleUtil(path, 1)
      if (!res) {
        println("solution doesn't exist")
        return false

      }
      else {
        printSolution(path)
        return true
      }
    }

    def printSolution(path: Array[Int]): Unit = {
      println("solution exists and the hamiltonian cycle is")
      for (i <- 0 until verts) {
        println(path(i))
      }
      println(path(0))
    }
  }

}





