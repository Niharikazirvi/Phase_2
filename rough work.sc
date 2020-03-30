println()
import scala.collection.mutable.ArrayBuffer

var a = List[Int]()
a = Nil
a.
//var a = new ArrayBuffer[Int](5)
a.length
a.contains(0)


var a = new Array[Int](5)
a.contains(0)
a = Array(1,2,3,0,7)
a.contains(0)
a = Array()
a.isEmpty
a.length
a :+ 1
//a(4) = 5
var b = new Array[Int](3)
//b = Array(Nohting, Nothing, Nothing)

//a(0)

val b = List[Int](5)
b
var a = List(1,2,3,4)
a.tail
//while(a!=Nil){
 // println("hello")

//}

val b = List[Int]()
b.length
b
var a = Array(1,2,null)
var b = Array(1,2,3)
//a.indexOf(a.last) // if there are null values then the last value of array is the first null value
b.indexOf(b.last)// if there is no null in the last then it'll return the index of the last filled value of the array

var c = Array(null,null)
c.isEmpty

var b = Array(1,2,3)
b.reverse

var d = new Array[String](5)
d.isEmpty
var a = Array(1,3,5,7,9,null,null)
a.last

var  b = a.indexOf(a.last) //tho last null 6 index te hai but oh last first null tak hi ginuga taan hi taan faida null da
  a(b-1) = null  // here it worked becoz here array datatype intially become Any
//a.last
a.indexOf(a.last)
a
a.size
a.last

var b = new Array[Int](3)
b // intial means not empty but it gets intitialised to zero
b.last
a.isEmpty  // so the array is not empty
/*for(i<-0 until b.length){
  b(i) = null
}

 */
a.isEmpty

var c = Array(null, null, null) //Null is string class
c.getClass.getName
var d = new Array[Any](3)
d = Array(4,8,9)
d
//d.indexOf(d.last) = null
var n = d.indexOf(d.last)
d(n) = null
d
d = Array(null,null,null) // an expression of type Null is ineligible for implicit conversion