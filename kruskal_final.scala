import scala.collection.mutable.ArrayBuffer

object kruskal_final {

  def main(args: Array[String]): Unit = {
    val g1 = new Graph(9)
    g1.AddWeightEdge(1, 2, 1)
    g1.AddWeightEdge(1, 3, 7)
    g1.AddWeightEdge(2, 4, 5)
    g1.AddWeightEdge(2, 5, 6)
    g1.AddWeightEdge(3, 4, 2)
    g1.AddWeightEdge(5, 7, 9)
    g1.AddWeightEdge(5, 6, 3)
    g1.AddWeightEdge(6, 8, 8)
    g1.AddWeightEdge(7, 8, 4)
    g1.kruskal()
    g1.print()
  }


  class Graph(var V: Int) {

    var G = new ArrayBuffer[Array[Int]](V)
    var T = new ArrayBuffer[Array[Int]](V)

    var parent: Array[Int] = new Array[Int](V)
    for (i <- 0 until V) {
      parent(i) = i

    }


    def AddWeightEdge(u: Int, v: Int, w: Int): Unit = {
      //G(u).append(Array(v,w))
      G.append(Array(u, v, w))
      //G(u).append((u,v,w))
    }

    def findSet(i: Int): Int = {
      if (i == parent(i)) {
        return i
      }
      else {
        findSet(parent(i))
      }
    }

    def UnionSet(u: Int, v: Int): Unit = {
      parent(v) = parent(u)
    }

    def kruskal(): Unit = {
      G.sortBy(_ (2))
      for (i <- 0 until V) {
        var a: Int = findSet(G(i)(0))
        var b: Int = findSet(G(i)(1))
        if (a != b) {
          T.append(G(i))
          UnionSet(a, b)
        }


      }

    }

    def print(): Unit = {
      val b = T.length
      for (i <- 0 until b) {
        val a = T(i)(0)
        val b = T(i)(1)
        val c = T(i)(2)

        println(s"$a and $b edge has weight $c"); //string interpolation

      }
    }

  }

}
