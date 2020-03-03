package Example

object graph {


    def main(args: Array[String]): Unit = {
      //print("enter the no. of vertices:")
      //var x = scala.io.StdIn.readInt()

      var g1 = new graph1(6)
      g1.add_edge(3,2)
      g1.add_edge(1,2)
      g1.add_edge(4,1)
      g1.display_adjmat()

    }

  class graph1(val n:Int){

    var verts:Int=n

      var adjmat = Array.ofDim[Int](verts,verts)
      for(i <- 0 until verts){
        for(j <- 0 until verts){
          adjmat(i)(j)=0

      }


    }
      def add_edge(i:Int,j:Int): Unit ={
        adjmat(i)(j)=1
        adjmat(j)(i)=1
      }

      def remove_edge(i:Int,j:Int): Unit ={
        adjmat(i)(j)=0
        adjmat(j)(i)=0
      }
    def display_adjmat(): Unit ={
      for(i<- 0 until verts){
        for(j <-0 until verts){
          print( adjmat(i)(j) + " ")
        }
        println()
      }
    }



  }

  }


