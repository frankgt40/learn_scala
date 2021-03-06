import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }     // if we write b = 1, then it is wrong, since  parameter b is val
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache =  mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }


}

val s = new ChecksumAccumulator()
s.add(12)
s.add(51)
println(s.checksum())


println(ChecksumAccumulator.calculate("Every value is an object."))
