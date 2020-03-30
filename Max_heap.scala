object Max_heap {

  def main(args:Array[String]): Unit ={
    val a:Array[Int] = Array(1,12,9,5,6,10)
    val n:Int = a.length

    heapsort(a,n)
    println("sorted array is")
    printArray(a,n)


  }


  def swap(a: Array [Int], i: Int, j: Int):Unit=
  {
    val t = a(i);
    a(i) = a(j);
    a(j) = t
  }


  def heapify(a:Array[Int], n:Int, i:Int):Unit={
    var largest:Int = i
    var l:Int= 2*i + 1
    var r:Int= 2*i + 2

    if(l< n && a(l)<a(largest)){
      largest = l
    }
    if(r<n && a(r)<a(largest)){
      largest = r
    }
    if(largest != i){
      //swap(a,a(i), a(largest))
      swap(a,i,largest)
      heapify(a,n, largest)
    }

  }
  def heapsort(a:Array[Int], n:Int)={
    for(i<-(0 to n/2-1).reverse){
      heapify(a,n,i)
    }

    for(i<- (0 to n-1).reverse){
      //swap(a,a(0),a(i))
      swap(a,0,i)
      heapify(a,i,0)
    }

  }


  def printArray(a:Array[Int], n:Int):Unit={
    for(i<- 0 until n){
      val m:Int =a(i)
      print(s"$m  ")
      println()
    }
  }



}
