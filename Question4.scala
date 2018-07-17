package InterviewQuestions
import scala.collection.mutable.Map
/**
  * Created by Ken.J.Zheng on 7/16/2018.
  * Given an array of integers, find the first missing positive integer in linear time and constant space.
  * In other words, find the lowest positive integer that does not exist in the array. The array can contain
  * duplicates and negative numbers as well.

  For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

  You can modify the input array in-place.
  */
object Question4 extends App{
  //O(2n-1)
  def getInteger(array:Array[Int]):Int = {
    val map = Map[Int,Int]()
    var x = 1
    for(i <- 0 to array.length-1){
      if(array(i)>0){
        if(array(i)==x)
            x = x+1
        else if(array(i)>x)
          map += (array(i) -> 0)
      }
    }

    for(i<- 0 to map.size-1){
      if(map.contains(x)) x=x+1
    }

    x
  }

  val test1=Array(3,4,-1,1)
  println(getInteger(test1))

  val test2=Array(1, 2, 0)
  println(getInteger(test2)==3)

  val test3=Array(3,2,1)
  println(getInteger(test3)==4)

  val test4=Array(5,4,5,1,3,0,-2,5,10)
  println(getInteger(test4)==2)
}
