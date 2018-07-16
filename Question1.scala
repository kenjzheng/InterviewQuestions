package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 7/14/2018.
  * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
  * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
  */
object Question1 extends App {
  //O(n+n-1+n-2+...)
  def isTrue(array:Array[Int], total:Int):Boolean={
    val answer = if(array.length==2){
      array(0) + array(1) == total
    }
    else {
      for (i <- 1 to array.length - 1) {
        if (array(0) + array(i) == total) return true
      }
      isTrue(array.tail, total)
    }
    answer
  }

  val test1 = Array(10, 15, 3, 7)
  val total1 = 17
  println(isTrue(test1,total1))

  val total2 = 19
  println(isTrue(test1,total2))

  //may add filter to remove numbers larger than total first.
}
