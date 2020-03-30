
  class rect
  {
    def mult(s1: Int, s2: Int)
    {
      var result = s1 * s2
      println("Area is: " + result);
    }
  }

  object scala_pracctice
  {
    // Main method
    def main(args:Array[String])
    {
      val su = new rect()
      su.mult(5, 10)
    }
  }

