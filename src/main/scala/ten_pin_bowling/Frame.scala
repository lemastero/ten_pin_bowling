package ten_pin_bowling


case class Frame(first: Int, second:Int) {

  def score:Int = first + second

  def isSpare:Boolean = (first + second) == 10

  def isStrike:Boolean = first == 10

}
