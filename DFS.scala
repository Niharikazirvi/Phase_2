package Example

import scala.collection.mutable.ListBuffer
object DFS {
  def main(args: Array[String]): Unit = {
    var g = new graph1(6);
    g.add_edge(0, 1);
    g.add_edge(0, 2);
    g.add_edge(1, 3);
    g.add_edge(2, 5);
    g.add_edge(1, 4);
    g.display_graph()
    print("DFS seq: " )
    g.DFS(0);


  }

  class graph1(n: Int) {
    var AdjList = new Array[ListBuffer[Int]](n)
    var visited = new Array[Boolean](n)

    for (i <- 0 until n) {
      AdjList(i) = new ListBuffer[Int]
      AdjList(i).prepend(i: Int)
    }

    def add_edge(i: Int, j: Int) {
      AdjList(i) += j
      AdjList(j) += i
    }

    def void_edge(i: Int, j: Int): Unit = {
      AdjList(i) -= j
      AdjList(j) -= i
    }

    def display_graph(): Unit = {
      for (i <- 0 until n) {
        println(AdjList(i))
      }
    }

    def DFS(vert: Int): Unit = {
      print(vert + " ")
      visited(vert) = true
      var Adji: ListBuffer[Int] = AdjList(vert)
      var c = AdjList(vert).length

      for (i <- 0 until c) {
        if (!visited(Adji(i))) {
          DFS(Adji(i))


        }


      }

    }
  }

}



