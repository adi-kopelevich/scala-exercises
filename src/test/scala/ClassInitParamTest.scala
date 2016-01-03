import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by adi on 03/01/2016.
  */
class ClassInitParamTest extends FlatSpec with Matchers {

  "A class with val param" should "define getter" in {
    class ClassWithValParam(val name: String)
    val obj = new ClassWithValParam("Moshe")
    obj.name should be("Moshe")
  }

  "A class with var param" should "define getter and setter" in {
    class ClassWithVarParam(var name: String)
    val obj = new ClassWithVarParam("Moshe")
    obj.name should be("Moshe")
    obj.name = "Haim"
    obj.name should be("Haim")
  }

  "A class with private param" should "be hidden" in {
    class ClassWithPrivateParam(str: String) {

      val name: String = str;

      override def toString(): String = name;
    }
    val obj = new ClassWithPrivateParam("Moshe")
    obj.toString should be("Moshe")
  }

}
