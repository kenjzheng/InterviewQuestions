package InterviewQuestions
import scala.util.control.Breaks._
/**
  * Created by Ken.J.Zheng on 7/25/2018.
  * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
  * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
  */
object Question5 extends App {
  def getLongest(str:String, gauge:Int):String = {
    val longestStr = if(str.length<=gauge)
      str
    else {
      var sample = str.take(gauge) //safe to take characters in range of gauge
      var curMaxStr = sample;

      breakable {
        for (i <- gauge to str.length - 1) {
          sample = sample + str(i)
          if (sample.distinct.length <= gauge) { //at most k distinct characters
            curMaxStr = sample
          }
          else
            break()
        }
      }
      val nextMaxStr = getLongest(str.tail,gauge)
      if(nextMaxStr.length>curMaxStr.length)
        curMaxStr = nextMaxStr;

      curMaxStr
    }

    longestStr
  }

  val test1 = "abcba"
  val m1 = 2
  println(getLongest(test1,m1))

  val test2 = "aaaaaaa"
  val m2 = 2
  println(getLongest(test2,m2))

  val test3 = "aaabbbb"
  val m3 = 2
  println(getLongest(test3,m3))

  val test4 = "abcbbe123creeffshisffffffffffffffmopp!" //can change charaters near fffff.f to test more.
  val m4 = 3
  println(getLongest(test4,m4))
}
