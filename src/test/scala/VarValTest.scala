import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by adi on 03/01/2016.
  */
class VarValTest extends FlatSpec with Matchers {

  "A val" should "be immutable" in {
    val age:Int = 32
    age should be (32)
  }

  "A var" should "be re-assingable" in {
    var age:Int = 32
    age === (32)
    age = 35
    age should be (35)
  }

  "A val array" should "not be referenced again" in {
    val stringArray:Array[String] = new Array(10)
   // stringArray = new Array(10)  - will result in a reassignment to val error
    stringArray(3)="Hi"
    stringArray(3) should be ("Hi")
  }

}
