package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 7/14/2018.
  * Given an array of integers, return a new array such that each element at index i of the new array is the product of all
  * the numbers in the original array except the one at i.
    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6]
  */
object Question2 extends App {
  //O(n*n)
  def getNewArray(sourceArray:Array[Int]):Array[Int]={
    val length = sourceArray.length
    var proudct = 1
    val newArray = new Array[Int](length)
    for(i <- 0 to length-1){
      for(j <- 0 to length-1){
        if(j != i){
          proudct = proudct * sourceArray(j)
        }
      }
      newArray(i)=proudct
      proudct = 1
    }
    newArray
  }

  //O(2n)
  def getNewArray2(sourceArray:Array[Int]):Array[Int]={
    var total = 1
    sourceArray.foreach(i => total = total*i)

    val newArray = new Array[Int](sourceArray.length)
    for(i <- 0 to sourceArray.length-1){
      newArray(i)= total/sourceArray(i)
    }

    newArray
  }

  val test1 = Array(1, 2, 3, 4, 5)
  println(getNewArray(test1).mkString(","))
  println(getNewArray2(test1).mkString(","))

  val test2 = Array(3,2,1)
  println(getNewArray(test2).mkString(","))
  println(getNewArray2(test2).mkString(","))
}
