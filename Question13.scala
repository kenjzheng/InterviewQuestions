package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 8/14/2018.
  */
/*
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
object Question13 extends App {
  val sentence = scala.collection.mutable.ArrayBuffer[String]()
  def reconstruct(str:String, words:Array[String]):Boolean={
    //find perfect match
    if(str.length==0){
      return true
    }

    for(word <- words){
      if(str.length>=word.length) {
        val x = str.take(word.length).toString
        if (x == word) {
          val nextCheck = reconstruct(str.drop(word.length), words)
          if(nextCheck) {
            //only when all following words are match, we add this word
            //for example, if there are two key words 'dog' and 'dogy' exits, when we pick 'dog', may affect the whole
            //sentence inspection
            sentence.append(x)
            return true
          }
        }
      }
    }
    false
  }

  val test1 = Array("quick","brown","the","fox")
  reconstruct("thequickbrownfox",test1)
  sentence.reverse.foreach(s => println(s))
  sentence.clear()

  val test2 = Array("bed","bath","bedbath","and","beyond")
  reconstruct("bedbathandbeyond",test2)
  sentence.reverse.foreach(s => println(s))
  sentence.clear()

  val test3 = Array("quick","brown","the","fox")
  reconstruct("thewquickbrownfox",test3)
  println("nothing should be found!")
  sentence.reverse.foreach(s => println(s))

}
