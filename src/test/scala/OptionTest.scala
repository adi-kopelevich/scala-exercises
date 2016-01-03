import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by adi on 03/01/2016.
  */
class OptionTest extends FlatSpec with Matchers {

  "Option val" should "either contain SOME specific value or None" in {
    val someValue: Option[String] = Some("I am specific")
    someValue.get should be("I am specific")

    val nullValue: Option[String] = None
    nullValue should be(None)
  }

  "function that returns Option" should "return Some or None" in {
    def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
      if (flag) Some("Found value") else None
    }

    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    value1 should be(Some("Found value"))
    value2 should be(None)

    value1.get should be("Found value")
    intercept[java.util.NoSuchElementException] {
      value2.get
    }

    value1 getOrElse "No value" should be("Found value")
    value2 getOrElse "No value" should be ("No value")
    value2 getOrElse {"default function"} should be("default function")

    value1.isEmpty should be (false)
    value2.isEmpty should be (true)
  }


  "Options" should "be pattern matched to allow default value in None" in {
    val someValue: Option[Double] = Some(20.0)
    val noValue: Option[Double] = None

    val value1 = someValue match
    {
      case Some(v) => v
      case None => 0.0
    }

    val value2 = noValue match
    {
      case Some(v) => v
      case None => 0.0
    }

    value1 should be(20.0)
    value2 should be(0.0)
  }

  "Options" should "be eligible for performing collection style operations" in {
    val someValue:Option[Int] = Some(11)
    val noValue:Option[Int] = None

    val mappedOption1 = someValue.map(_ - 1)
    val mappedOption2 = noValue.map(_ - 1)

    mappedOption1 should be (Some(10.0))
    mappedOption2 should be (None)

    val folddedOption1 = someValue.fold(0)(_ - 1)
    val folddedOption2 = noValue.fold(0)(_ - 1)

    folddedOption1 === 10
    folddedOption2 === 0
  }


}
