package ten_pin_bowling

import scala.annotation.tailrec

case class BowlingGame(frames: List[Frame] = Nil) {

  def perfectGame(): BowlingGame =
    repeatFrame(Frame.Strike, 12)

  def addFrame(frame: Frame): BowlingGame =
    BowlingGame(frame :: frames)

  def addStrike(): BowlingGame =
    addFrame(Frame.Strike)

  def repeatFrame(frame: Frame, times: Int): BowlingGame =
    (1 to times).foldLeft(this){ case(elem, _) =>
      elem.addFrame( frame )
    }

  def score: Int = {
    @tailrec
    def score(soFar: Int, rest: List[Frame]): Int = {
      rest match {
        case frame1 :: frame2 :: rest =>
          if(frame1.isStrike)
            score(soFar + frame1.score + 2 * frame2.score, rest)
          else if(frame1.isSpare)
            score(soFar + frame1.score + frame2.score + frame2.first, rest)
          else
            score(soFar + frame1.score + frame2.score, rest)
        case frame :: rest => score(soFar + frame.score, rest)
        case Nil => soFar
      }
    }
    score(0, frames)
  }
}
