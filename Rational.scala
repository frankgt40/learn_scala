class Rational(n:Int, d:Int) {

  require(d!=0)
  println("Created " + n + "/" + d)

  private val g = gcd(n.abs, d.abs) // Order matters: g must be before numer and denom
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n,1) // auxiliary constructor

  override def toString = numer + "/" + denom

  def +(that: Rational):Rational = {
    new Rational (
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
  
  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b:Int):Int =
    if (b == 0) a else gcd(b, a%b)
}
