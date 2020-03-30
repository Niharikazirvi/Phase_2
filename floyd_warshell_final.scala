import scala.util.control.Breaks._
object floyd_warshell_final {


  def main(args: Array[String]): Unit = {


    val g1 = new graph1(4)
    g1.add_edge(0,1,5)
    g1.add_edge(0,3,10)
    g1.add_edge(1,2,3)
    g1.add_edge(2,3,1)
    g1.display_adjmatrix(g1.adjmat)
    g1.floyd()

  }

  class graph1(val n:Int){

    var verts:Int=n

    var adjmat = Array.ofDim[Int](verts,verts)
    for(i <- 0 until verts){
      for(j <- 0 until verts){
        if(i==j){
          adjmat(i)(j)=0
        }
        else{
          adjmat(i)(j)= 999999
        }
      }
    }


    def add_edge(u: Int, v: Int, w: Int)= {

      adjmat(u)(v)=w

    }

    def display_adjmatrix(adjmatrix:Array[Array[Int]]):Unit={
      for(i<- 0 until verts){
        for(j <-0 until verts){
          val s= adjmatrix(i)(j)
          print( s"$s ")
        }
        println()
      }
      println()
    }


    def floyd()={
      var adjx = Array.ofDim[Int](verts,verts)

      for(i<-0 until verts){
        for(j<-0 until verts){
          adjx(i)(j)= adjmat(i)(j)
        }
      }

      for(k<-0 until verts){
        for(i<- 0 until verts){
          for(j<- 0 until verts){
            if(adjx(i)(k)+ adjx(k)(j) < adjx(i)(j)){
              adjx(i)(j) = adjx(i)(k) + adjx(k)(j)
            }

          }
          breakable{
            if(adjx(i)(i)<0)
            {
              println("Negative weight cycle found!")
              break
            }
          }
        }
      }

      display_adjmatrix(adjx)

    }
  }

}


