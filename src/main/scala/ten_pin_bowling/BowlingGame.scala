package ten_pin_bowling

case class BowlingGame() {

  def perfectGame() = repeatFrame(10, 0, 12)

  private var frames = List[Frame]()

  def addFrame(first: Int, second: Int) =
    frames = Frame(first, second) :: frames

  def addStrike = addFrame(10, 0)

  def repeatFrame(first: Int, second: Int, times: Int) =
    for (_ <- 1 to times)
      addFrame(first, second)

  def score: Int = {
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
