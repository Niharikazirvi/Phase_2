import scala.collection.mutable.ArrayBuffer
object kosarajus_algo {

  def main(Args:Array[String]): Unit ={
    val g1 = new Graph(5)
    g1.addEdge(1,0)
    g1.addEdge(0,2)
    g1.addEdge(2,1)
    g1.addEdge(0,3)
    g1.addEdge(3,4)
    g1.printSCCs()


  }

  class Stack[A]{
    private var elements:List[A]= Nil
    def push(x:A): Unit ={elements= x::elements}
    def peek():A = elements.head
    def pop():A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
    def isEmpty():Boolean={
      if(elements.isEmpty==true) return true
      else{false}

    }
  }

  class Graph(n:Int) {
    val verts = n

    var Adjlist = new Array[ArrayBuffer[Int]](verts)
    for (i <- 0 until verts) {
      Adjlist(i) = new ArrayBuffer[Int]
    }

    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u) += v
    }

    /*def this(){
      this()
      //secondary constructor shouldnot match the argument list


      }
    */


    def DFSUtil(v:Int, visited:Array[Boolean]):Unit={
      visited(v) = true
      print(v)
      print("-")
      val u =Adjlist(v)
      val l = u.length
      for(i<-0 until l ){
        if(!visited(u(i))){
          DFSUtil(u(i), visited)
        }
      }
    }

    def getTranspose():kosarajus_algo.Graph={


      val G = new Graph(verts)
      for(v<- 0 until verts){
        val u = Adjlist(v)
        val l = u.length
        for(i<-0 until l ){
          G.addEdge(u(i),v)
        }

      }
      return G
    }
    def fillOrder(v:Int, visited:Array[Boolean] , stack:Stack[Int]):Unit={
      visited(v) = true
      val u = Adjlist(v)

      val l = u.length
      for(i<- 0 until l){
        if(!visited(u(i))){
          fillOrder(u(i), visited, stack)
        }
      }
      stack.push(v)
    }
    def printSCCs()={

      val stack = new Stack[Int]
      val visited = new Array[Boolean](verts)
      for(i<-0 until verts){     // initally set all the visited as false and stack empty
        visited(i) = false
      }
      for(i<-0 until verts){    //step 1 //give a DFS traversal to all the vertices to fill them in stack acc according to the finish time(one at the last will have the most finish time)
        if(visited(i)==false){
          fillOrder(i:Int, visited:Array[Boolean], stack:Stack[Int])
        }
      }

      var gr:Graph = getTranspose() //step 2 // compute transpose of G -> G(T)

      for(i<- 0 until verts){  //to apply DFS again reset visited as false again
        visited(i)=false }
      while(!(stack.isEmpty)){      // step 3// call DFS(G(T)) on all vertices in decreasing order of their finish time
        //(i.e direct from stack coz they are stacked acc to the decreasing time order only)
        val v =stack.peek()
        stack.pop()
        if(visited(v)==false){
          gr.DFSUtil(v,visited)
          println()
        }
      }


    }
  }

}


