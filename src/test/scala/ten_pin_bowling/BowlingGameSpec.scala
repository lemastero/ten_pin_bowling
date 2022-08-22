package ten_pin_bowling

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

class BowlingGameSpec extends AnyFunSpec with Matchers {

  describe("Bowling Game score") {

    it("gives 0 when no pins") {
      val game = BowlingGame()
        .repeatFrame(0, 0, 10)
      game.score mustBe 0
    }

    it("gives 20 when knock 1 pin in each throw in each frame") {
      val game = BowlingGame()
         .repeatFrame(1, 1, 10)
         .score mustBe 20
    }

    it("gives 30 when spare and all other throws knock 1 pin") {
      val game = BowlingGame()
        .repeatFrame(1, 1, 5)
        .addFrame(2,8)
        .repeatFrame(1, 1, 4)

      game.score mustBe 29
    }

    it("gives 30 when strike and all other throws knock 1 pin") {
      val game = BowlingGame()
        .repeatFrame(1, 1, 5)
        .addFrame(10,0)
        .repeatFrame(1, 1, 4)

      game.score mustBe 30
    }
  }
}
