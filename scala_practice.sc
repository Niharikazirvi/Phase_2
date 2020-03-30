//var 0insf = "hello" //will give error

var a = 50000
a.toFloat
a.toByte
a.toString

var s = 'h'
s.toInt
s.toString



var a= 100
println(a)
a= 200
a.getClass.getName
var b  = a.asInstanceOf[Char]
b = 'c' // there is a difference between string and char data type in scala
print(b)
b.getClass.getName

var a= 'c'
a.asInstanceOf[Int]// it only gives the instance of the  var in Int of char using Ascii code
                    // it don't changes the data type of a
a.getClass.getName  // it still is a char data type
a = 100             // in ascii c=99, now 100 == d
var d = 6790908
print(a, d)         // it wont print 100, being a char data type...it will print d
a.asInstanceOf[Float] //that 100 is changes to the an instance of floating point
a.getClass.getName
a= 236                // in ascii this 236 == i special char
print(a,d)






var a= 'c'
var b = a.asInstanceOf[Int] //to change the data type put the instance result in a new var
a.getClass.getName    // data type of a remains the same
b.getClass.getName    // data type of b is given as Int
a = 100
var  b = 6790908
print(a, b)           // again a = 100 is changed to d in char
var c = b.asInstanceOf[Float]
a.getClass.getName
c.getClass.getName
b.getClass.getName

c= 2.369f    // simple 2.369 is considered double and not float
              // for that u have to explicitly state it as 2.369f
              // or 2.369d
print(a,b,c)

/*-------1--- val and var
for(i<-0 to 5){
  val a = i // declare it as var
  println(a)
  a = a* 1  // you are changing the value of a in a local scope only so it6 needs to be declared a var
  print(a)
}
----1----------*/

// data type once declared in var cant be changed until explicitely
//type casting is done
// also in type casting after type casting the var the result is
// stored into a new variable
// so its better to use to.(type)
var a = 1
var a = "hello" // here there wont be any error coz in worksheet a is redifined as a new variable
//var f = a.toString
var m = a.toInt
a = 1 // now last a is typed as string and now it will give error
      // coz here it is not redifined with var but reassigned value

