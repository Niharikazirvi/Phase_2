import scala.collection.mutable.ArrayBuffer

object Cycle_detection_DFS {
  def main(args: Array[String]): Unit = {
    val g1 = new Graph(5)
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    g1.isCyclic_undir()

    val g=new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.isCyclic_Dir()

  }


  class Graph(n: Int) {
    val verts = n
    var Adjlist = new Array[ArrayBuffer[Int]](n)
    for (i <- 0 until n) {
      Adjlist(i) = new ArrayBuffer[Int]
    }
    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u)+= v
    }

   var visited = new Array[Boolean](verts)
    var parent:Int = -1    // parent variable for undirected graph

    def isCyclic_Dir():Boolean ={
      val recStack = new Array[Boolean](verts)// stack for directed graph
      for (i <- 0 until verts) {
        visited(i) = false
        recStack(i) = false
      }
      for(i<- 0 until verts){
        if(DFS_for_directed(i,visited,recStack)) {
          println("cycle detected")
          return true
        }
      }
      println("no cycle detected")
      false

    }
    def DFS_for_directed(v:Int, visited:Array[Boolean], recStack:Array[Boolean]): Boolean ={
      if(visited(v)==false){
        visited(v)=true
        recStack(v) = true
        for(i<- (Adjlist(v))(0)  to Adjlist(v).last  ){
          if(!visited(i) && DFS_for_directed(i,visited,recStack)){
            return true
          }
          else if(recStack(i)){
            println("through recstack")
            return true
          }
        }
      }
      recStack(v) = false
      return false
  }




    def DFS_for_undirected(u:Int, visited:Array[Boolean], parent:Int): Boolean ={
      visited(u)= true

      for(i<-(Adjlist(u))(0)  to Adjlist(u).last ){
        if(!visited(i)) {
          if (DFS_for_undirected(i, visited, u)) {
            return true
          }
        }
          else if (i != parent) {
          println("through parent condition")
            return true
          }



       }
      false //if no cycle will be detected i.e it didnt return true and break out of loop
                    // in the endr coming out of loop it will return false finally
    }

    def isCyclic_undir(): Boolean={
      for(i<- 0 until verts){
        visited(i) = false
       }
      for(u<-0 until verts){
        if(!visited(u)){
          if(DFS_for_undirected(u,visited,-1)){
            println("cycle detected")
            return true
          }
        }
      }
      println("no cycle detected")
      false
     }

  }

}