package ten_pin_bowling

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

class FrameSpec extends AnyFunSpec with Matchers {

  describe("Frame") {

    it("is strike when all ten pins are knocked down with the first ball ") {
      Frame(10, 0).isStrike mustBe true
    }

    it("is not strike when only 2 pin were knocked down with the first ball ") {
      Frame(2, 8).isStrike mustBe false
    }

    it("is spare when all ten pins are knocked down with both strikes") {
      Frame(2, 8).isSpare mustBe true
    }

    it("is spare when no pins were knocked down") {
      Frame(0, 0).isSpare mustBe false
    }

    it("sum results on both strikes") {
      Frame(2, 3).score mustBe 5
    }
  }
}
