import scala.collection.mutable.ArrayBuffer

object Heap_functions{

  def swap(a: ArrayBuffer[Int], i: Int, j: Int): Unit = {
    val t = a(i);
    a(i) = a(j);
    a(j) = t
  }


  def heapify(a: ArrayBuffer[Int], n: Int, i: Int): Unit = {
    var largest: Int = i
    val l: Int = 2 * i + 1
    val r: Int = 2 * i + 2

    if (l < n && a(l) > a(largest)) {
      largest = l
    }
    if (r < n && a(r) > a(largest)) {
      largest = r
    }
    if (largest != i) {
      //swap(a,a(i), a(largest))
      swap(a, i, largest)
      heapify(a, n, largest)
    }

  }

  def insert(a: ArrayBuffer[Int], n: Int): Unit = {
    if (a.isEmpty) {
      a(0) = n
    }
    else{
      val l: Int = a.length
      a(l) = n

    }
    heapify(a, n + 1, 0)

  }

  def deleteNode(a: ArrayBuffer[Int], n: Int): Unit = {
    if (n == a.last) {
      a.remove(a.last)
    }
    else{
      swap(a, a.indexOf(a.last), a(n))
      a.remove(a.last)
    }
    heapify(a, n - 1, 0)
  }

  def peek(a:ArrayBuffer[Int]):Int = {
    a(0)


  }

  def extract(a:ArrayBuffer[Int]): Int = {
    val c: Int = a(0)
    a.remove(a(0))
      heapify(a, (a.length) - 1, 0)
     return c


  }
}