import scala.collection.mutable.{ArrayBuffer, ListBuffer}
object djikstras_algo_final {



  def main(args: Array[String]): Unit = {

    var g1 = new graph(7)
    g1.AddWeightEdge(0,1,1)
    g1.AddWeightEdge(1,2,2)
    g1.AddWeightEdge(1,3,4)
    g1.AddWeightEdge(2,3,1)
    g1.AddWeightEdge(2,6,5)
    g1.AddWeightEdge(3,0,2)
    g1.AddWeightEdge(3,4,2)
    g1.AddWeightEdge(3,5,2)
    g1.AddWeightEdge(4,6,4)
    g1.AddWeightEdge(5,6,1)
    g1.AddWeightEdge(4,1,1)

    g1.dijkstra()
    g1.print_spt()
    //g1.print_list()

    var g2 = new graph(7)
    g2.AddWeightEdge(0,1,4)
    g2.AddWeightEdge(0,2,3)
    g2.AddWeightEdge(0,4,7)
    g2.AddWeightEdge(1,2,6)
    g2.AddWeightEdge(1,3,5)
    g2.AddWeightEdge(1,0,4)
    g2.AddWeightEdge(2,4,8)
    g2.AddWeightEdge(2,1,6)
    g2.AddWeightEdge(2,0,3)
    g2.AddWeightEdge(2,3,11)
    g2.AddWeightEdge(3,2,11)
    g2.AddWeightEdge(3,1,5)
    g2.AddWeightEdge(3,4,2)
    g2.AddWeightEdge(3,6,10)
    g2.AddWeightEdge(3,5,2)
    g2.AddWeightEdge(4,3,2)
    g2.AddWeightEdge(4,0,7)
    g2.AddWeightEdge(4,2,8)
    g2.AddWeightEdge(4,6,5)
    g2.AddWeightEdge(5,3,2)
    g2.AddWeightEdge(5,6,3)
    g2.AddWeightEdge(6,3,10)
    g2.AddWeightEdge(6,4,5)
    g2.AddWeightEdge(6,5,3)
    g2.dijkstra()     // if you wanna run djkstra v times from every vertex as source vertex to workb as floyd warshell then put a loop on priority queue to add very vertex as start vertex to start the algo from that edge...thats it
                      // or directly define dijkstra with the source vertex as argument and alter priority code acc to that so that first source vertex get appended to priority queue first and the algo goes on
                      // then run dijkstra with all the vertcices as an argument in a loop n times!
    g2.print_spt()



  }



  class graph(V: Int) {

    var AdjList = new Array[ArrayBuffer[Array[Int]]](V)
    for(i<-0 to V-1){
      AdjList(i) = new ArrayBuffer[Array[Int]]
    }
    var priority_queue = new ArrayBuffer[Array[Int]]
    //var SPT = new ListBuffer[Int]// we can use the arraybuffer aldo but since we are more concerned about travesing back the tree for finding the shortest path we used listBuffer
    //since the extract function is defined for arraubuffer
    var SPT = new ArrayBuffer[Int](V)

    var Dist = new Array[Int](V)
    for(i<- 0 until Dist.length){
      Dist(i)= 2467578
    }
    Dist(0)=0

    def AddWeightEdge(u: Int, v: Int, w: Int): Unit = {
      AdjList(u).append(Array(v,w))
      //G(u).appended(Array(v, w))
    }

    def print_list():Unit={
      for(i<-0 to AdjList.length-1){
        println(AdjList(i))
      }

    }


    def dijkstra() = {
      priority_queue.append(Array(0, 0, 0))

      while (priority_queue.nonEmpty) {
        //val u: Int = priority_queue(0)(0) //Init.. of the algo by starting from vertex 0 with dist 0 from itself
        val pp = priority_queue
        val list = pp.toList
        println(list.map(java.util.Arrays.toString))

        val u = extract(priority_queue) //extract the first element from priority queue
        if(!SPT.contains(u)){      //save only those which are not already there...coz once a node traversed
          //then even another node leads toa smaller distance to it even then it a
          // cant be changed and again added to SPT
          SPT += u  // put the element in spt
          // val v: ArrayBuffer[Array[Int]] = AdjList(u) //to check out all the adjacent elements of that vertex from the adjacency lisgt

          for (x <- AdjList(u)) {
            println(x(0))
            println(x(1))
            if (!SPT.contains(x(0)) && (Dist(x(0)) > Dist(u) + x(1))) {
              println(39)
              Dist(x(0)) = Dist(u) + x(1)
              insert(priority_queue,x,Dist(x(0)))
            }
          }}
      }
    }


    def print_spt(): Unit ={
      SPT.foreach((i: Int) => print(i))
      println()
      Dist.foreach((i: Int) => print(i))
    }

    def swap(a: ArrayBuffer[Array[Int]], i: Int, j: Int): Unit = {
      val t = a(i);
      a(i) = a(j);
      a(j) = t
    }


    def heapify(a: ArrayBuffer[Array[Int]], num: Int, ind: Int): Unit = {
      var largest: Int = ind
      val l: Int = 2 * ind + 1
      val r: Int = 2 * ind + 2

      if (l < num && a(l)(2) < a(largest)(2)) { //the actual priority is fashioned from this statement
        largest = l
      }
      if (r < num && a(r)(2) < a(largest)(2)) {
        largest = r
      }
      if (largest != ind) {
        //swap(a,a(i), a(largest))
        swap(a, ind, largest)
        heapify(a, a.length, largest)
      }

    }

    def heapsort(a: ArrayBuffer[Array[Int]],num: Int): Unit ={
      for(i<- (num/2)-1 to 0 by -1) {
        heapify(a, num, i)
      }

    }

    def insert(a: ArrayBuffer[Array[Int]], Anode: Array[Int],dist:Int): Unit = {
      /*if (a.isEmpty) {
        a(0) = Anode
      }
      else{
        val l: Int = a.length
        a(l) = Anode

      }*/

      var Anode2:Array[Int] = Anode.appended(dist)
      a += Anode2
      //heapify(a, a.length , 0)
      heapsort(a,a.length)

    }

    def deleteNode(a: ArrayBuffer[Array[Int]], node: Int): Unit = {
      if (node == (a.last)(0)) {
        a-=(a.last)
      }
      else{
        swap(a, a.indexOf(a.last), a.indexOf(node))
        a-=a.last
      }
      //heapify(a, a.length - 1, 0)
      heapsort(a,a.length)
    }

    def peek(a:ArrayBuffer[Array[Int]]):Int = {
      a(0)(0)


    }

    def extract(a:ArrayBuffer[Array[Int]]): Int = {
      val c= a(0)(0)
      a-= a(0)
      //heapify(a, a.length - 1, 0)
      heapsort(a,a.length)
      return c


    }

  }
}


