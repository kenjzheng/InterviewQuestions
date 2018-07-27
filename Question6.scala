package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 7/25/2018.
  * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
  * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
  * Follow-up: Can you do this in O(N) time and constant space?
  */
object Question6 extends  App {
  def getMaximum(array:Array[Int]):Int={

    val total = if(array.length<6) {
      array.length match {
        case 0 => 0
        case 1 => array(0)
        case 2 => {
          if(array(0)>=array(1)) array(0)
          else array(1)
        }
        case 3 => {
          if(array(0)+array(2)>=array(1)) array(0)+array(1)
          else array(2)
        }
        case 4 => {
          val v1 = if(array(0)+array(2) >= array(0)+array(3)){
            array(0)+array(2)
          }
          else array(0)+array(3)

          val v2 = array(1)+array(3)

          if(v1>=v2) v1
          else v2
        }
        case 5 => {
          val v1 = if(array(0)+array(2)+array(4) >= array(0)+ array(3)){
            array(0)+array(2)+array(4)
          }
          else array(0)+ array(3)

          val v2 = if(array(1)+array(3) >= array(1)+array(4)){
            array(1)+array(3)
          }
          else array(1)+array(4)

          if(v1>=v2) v1
          else v2
        }
      }
    }
    else {
      //start at index 0
      val v1 =if(array(3)>=array(2)){
        array(0)+array(3)+getMaximum(array.drop(5))
      }
      else {
        array(0)+array(2)+getMaximum(array.drop(4))
      }

      //start at index 1
      //val test2 = getMaximum(array.drop(1))

      val v2 = if(array(4)>=array(3))
        array(1)+array(4)+getMaximum(array.drop(6))
      else {
        array(1)+array(3)+getMaximum(array.drop(5))
      }

      if(v1>=v2)
        v1
      else
        v2
    }


    total
  }

  val test1 = Array(2,4,6,2,5)
  println(getMaximum(test1))

  val test2 = Array(5,1,1,5)
  println(getMaximum(test2))

  val test3 = Array(5,1,1,1,1,1,1,1,1,100,1)
  println(getMaximum(test3))

  val test4 = Array(5,1,1,1,1,1,1,1,100,1,1)
  println(getMaximum(test4))

  val test5 = Array(1,5,1,5)
  println(getMaximum(test5))
}
