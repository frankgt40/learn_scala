import scala.io.Source

if (args.length > 0) {
  for (line <- Source.fromFile(args(0)).getLines())
    println(line.length + " " + line)
} else {
  Console.err.println("Please enter filename")
}

def widthOfLength(s: String) = s.length.toString.length

/////// better looking
println("\n++++++++++++++++++++Better looking+++++++++++++++++++++++++")
if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines.toList
  // Imperative style
  // var maxWidth = 0
  // for (line <- lines)
  //   maxWidth = maxWidth.max(widthOfLength(line))

  // Functional style
  val longestLine = lines.reduceLeft(
    (a,b) => if (a.length > b.length) a else b
  )
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
} else {
  Console.err.println("Please enter a filename")
}
