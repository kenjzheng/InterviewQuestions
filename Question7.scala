package InterviewQuestions
import scala.util.Random
import scala.math.pow

/**
  * Created by Ken.J.Zheng on 7/29/2018.
  * The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
  * Hint: The basic equation of a circle is x^2 + y^2 = r^2.
  *
  * research of this question:
  * ref to this site for explanation of this method
  * http://www.eveandersson.com/pi/monte-carlo-circle
  */
object Question7 extends App{
  def getPi(numTrials:Int):Double = {
    var pointsInCircleCount = 0
    val negativePositive = Array(-1,1)

    for(i <- 0 to numTrials) {
      //not necessary to generate negative numbers because we will use pow eventually. just to make it real as I use (0,0) as origin.
      val x = Random.nextDouble()*negativePositive(Random.nextInt(2)) //nextInt(2) will genereate 0,1
      val y = Random.nextDouble()*negativePositive(Random.nextInt(2))

      if((pow(x,2.0)+pow(y,2.0))<=1.0){
        pointsInCircleCount += 1
      }
    }

    val pi = 4 * (pointsInCircleCount.toDouble)/(numTrials.toDouble)
    pi
  }

  val tests = Array(10,100,1000,10000,1000000,10000000,100000000)
  tests.map(t => println(t+"->"+ getPi(t)))

  //to test scala's Double comparison
  val d1: Double = 5.2130123
  val d2 = 5.2130123
  println(d1==d2)

  val f1: Float = 5.2130123F
  val f2: Float = 5.2130123F
  println(f1==f2)

}
