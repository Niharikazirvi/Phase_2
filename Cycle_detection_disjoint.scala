import scala.collection.mutable.ArrayBuffer
object Cycle_detection_disjoint {
 def main(args:Array[String]): Unit ={

   val g1 = new Graph(5)
   g1.addEdge(0,1)
   g1.addEdge(0,2)
   g1.addEdge(1,3)
   g1.addEdge(1,0)
   g1.addEdge(1,4)
   g1.addEdge(2,0)
   g1.addEdge(3,4)
   g1.addEdge(3,1)
   g1.addEdge(4,1)
   g1.addEdge(4,3)
   g1.isCycle()



 }
  class Graph(n:Int){
    val verts: Int = n
    var Adjlist = new Array[ArrayBuffer[Int]](n)
    for (i <- 0 until n) {
      Adjlist(i) = new ArrayBuffer[Int]
    }

    //var parent = new Array[Int](verts)

    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u)+= v
    }

    def find(parent:Array[Int],i:Int):Int={
      if(parent(i) == -1)
        return i
      find(parent, parent(i))
    }

    def Union(parent:Array[Int],x:Int,y:Int): Unit = {
      val xset = find(parent, x)
      val yset = find(parent, y)
      if (xset != yset) {
        parent(xset) = yset
      }
    }

      def isCycle():Int={
        val parent = new Array[Int](verts)
        for(i<- 0 until verts){
          parent(i) = -1
        }

        for(u<- 0 until verts){
          val V =Adjlist(u)
          for(i<- 0 until V.last){
           val v = V(i)
            val x = find(parent, u )
            val y = find(parent, v)

            if(x==y){
              println("cycle detected")
              return 1
            }

            Union(parent, x, y)
          }

        }
        println("no cycle detectd")
        return 0
        }

    }



}
