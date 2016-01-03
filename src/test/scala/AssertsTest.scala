import org.scalatest._

/**
  * Created by adi on 03/01/2016.
  */
class AssertsTest  extends FlatSpec with Matchers {

  "A val contain numeric" should "be equal" in {
    val result = 3.0;
    result should equal(3) // can customize equality
    result should equal(3) // can customize equality
    result should ===(3) // can customize equality and enforce type constraints
    result should be(3) // cannot customize equality, so fastest to compile
    result shouldEqual 3 // can customize equality, no parentheses required
    result shouldBe 3 // cannot customize equality, so fastest to compile, no parentheses required
  }




}
