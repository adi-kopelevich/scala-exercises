/**
  * Created by adi on 03/01/2016.
  */
object PointManager {
  def main(args: Array[String]) {
    val pt = new Point(1, 2)
    println(pt)
    pt.move(10, 10)
    println(pt)
  }
}
