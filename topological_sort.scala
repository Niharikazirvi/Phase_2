import scala.collection.mutable.ArrayBuffer
object topological_sort {

  def main (args:Array[String]): Unit ={
    val g = new Graph(6)
    /*g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    */
    g.addEdge(2,3)
    g.addEdge(3,1)
    g.addEdge(4,0)
    g.addEdge(4,1)
    g.addEdge(5,2)
    g.addEdge(5,0)
    print("top sort is: ")
    g.topologicalSort()

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

    //var stackk = new Array[Int](verts) // since in stac
    var stackk = new Array[Any](verts) //here for the data type we can use any but any cant be used in place of Array or Arraybuffers when we define Array[Arraybuffer] types...coz Any is basic and its subtypes class has much more complex defined functionalities so there u cant use Array[Any] and expect it to take any on behalf of arraybuffer, lists etc...any cant predict their behvaior
    var visited = new Array[Boolean](verts)

    for(i<- 0 until verts){
      stackk(i) = null
    }

    // here value update is not a member of boolean .... so put it as variable...since adjlist is not changed once given...so that will be given as val

    def topSortUtil(v:Int, visited:Array[Boolean] , a:Array[Any]): Unit ={


      visited(v) = true
      val u = Adjlist(v)
      val l = u.length
      for(i<- 0  until l){
        val d = u(i)
        //print(d)
        if(!visited(d)){ //that is  a neighbour is already visited(that is explored) by another vertex
          // no need to explore that vertex again
          topSortUtil(d, visited, stackk)
        }
      }
      push(stackk,v)
      //print(v)

    }

    def topologicalSort(): Unit ={

      for(i<-0 until verts){
        visited(i) = false
      }

      for(i<- 0 until verts){
        if(!visited(i))
          topSortUtil(i, visited, stackk )


      }
      //while(!(stackk(0)==null)){
      //val m = top(stackk)
      //println(m)
      //pop(stackk)


      //}
      var top = stackk.reverse
      for(i<- 0 until verts){
        print(top(i))
      }

    }

    def top(a:Array[Any]): Any ={
      val b = a.indexOf(a.last)
      if(b==verts-1) {
        return a(b)
      }
      else{
        return a(b-1)
      }
    }
    def push(a:Array[Any], node:Any): Unit ={
      val b = a.indexOf(a.last)
      a(b) = node
    }

    /*
    def pop(a:Array[Any]): Unit ={         // we dont need pop
      val b = a.indexOf(a.last)
      if(b==verts-1 ) {
        a(b) = null
      }
     else{
        }
    }*/
  }
}


