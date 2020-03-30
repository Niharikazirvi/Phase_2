import scala.collection.mutable.ArrayBuffer
object tarjans_algo {
  def main(args:Array[String]): Unit ={ //for directed

    val g4 = new Graph(11);
    g4.addEdge(0,1);g4.addEdge(0,3);
    g4.addEdge(1,2);g4.addEdge(1,4);
    g4.addEdge(2,0);g4.addEdge(2,6);
    g4.addEdge(3,2);
    g4.addEdge(4,5);g4.addEdge(4,6);
    g4.addEdge(5,6);g4.addEdge(5,7);g4.addEdge(5,8);g4.addEdge(5,9);
    g4.addEdge(6,4);
    g4.addEdge(7,9);
    g4.addEdge(8,9);
    g4.addEdge(9,8);
    g4.SCC();
    println()
    /*
    val g5= new Graph(5);
    g5.addEdge(0,1);
    g5.addEdge(1,2);
    g5.addEdge(2,3);
    g5.addEdge(2,4);
    g5.addEdge(3,0);
    g5.addEdge(4,2);
    g5.SCC();

    val g = new Graph(5)
    g.addEdge(1,0)
    g.addEdge(0,2)
    g.addEdge(2,1)
    g.addEdge(0,3)
    g.addEdge(3,4)
    g.SCC()
    println()
    */


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

  class Graph(n:Int){
    val verts = n
    var Adjlist = new Array[ArrayBuffer[Int]](verts)
    for (i <- 0 until verts) {
      Adjlist(i) = new ArrayBuffer[Int]
    }
    var time = 0

    def addEdge(u: Int, v: Int): Unit = {
      Adjlist(u) += v
    }

    def min(a:Int, b:Int):Int={
      if(a<b){
        return a
      }
      else{
        return b
      }
    }


    def SCCUtil(i:Int, disc:Array[Int], low:Array[Int], stack:Stack[Int],stackmember:Array[Boolean]): Unit ={
      time = time +1
      disc(i) = time
      low(i) = time
      stack.push(i)
      //println("galbaat")
      //println(i)
      stackmember(i) = true

      val u = Adjlist(i)
      val l = u.length
      for(j<-0 until l){
        val v = u(j)
        if(disc(v)== 0){
          SCCUtil(v, disc, low, stack, stackmember)

          low(i) = min(low(i), low(v))
        }
        else{
          if(stackmember(v)==true){
            low(i)= min(low(i), disc(v))
          }
        }

      }
      var w: Int = 0
      if(low(i)==disc(i)){
        while(!(stack.peek()== i)){
          val w =stack.peek()
          print(s"$w  ")
          stackmember(w)= false
          stack.pop()
        }
        //w = stack.pop() //this lead to completely poping out the
        w=stack.peek()
        println(s"$w ")
        stackmember(w) = false
        stack.pop()
      }

    }

    def SCC(): Unit ={
      //var disc = new Array[Int](verts)
      var disc = new Array[Int](verts)
      var low = new Array[Int](verts)
      var stackmember = new Array[Boolean](verts)
      var stack = new Stack[Int]


      for(i<- 0 until verts){
        stackmember(i) = false
      }
      for(i<- 0 until verts){
        if(disc(i)==0)
          SCCUtil(i,disc,low,stack, stackmember)
      }
    }
  }



}
