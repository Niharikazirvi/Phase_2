package Example

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
object BFS {

    def main(args: Array[String]): Unit = {
      var g = new graph1(6);
      g.add_edge(0, 1);
      g.add_edge(0, 2);
      g.add_edge(1, 3);
      g.add_edge(2, 5);
      g.add_edge(1, 4);
      g.display_graph()

      println("BFS seq:")
      g.BFS(vert = 0);
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
          //println("this"+AdjList(i)(1))
        }
      }

      def BFS(vert: Int): Unit = {

        var l: List[Int] = AdjList(vert).toList
        var q: Queue[Int] = Queue(l: _*)
        var qu: Queue[Int] = Queue.empty

        visited(vert) = true
        qu.enqueue(vert)

        while (!qu.isEmpty) {
          var CurrVert: Int = qu.front
          print(CurrVert + " ")
          qu.dequeue
          var c: Int = AdjList(CurrVert).length
          for (i <- 0 until c) {
            var j = AdjList(CurrVert)(i)
            if (!visited(j)) {
              visited(j) = true
              qu.enqueue(j)
            }
          }

        }

      }


    }


}

