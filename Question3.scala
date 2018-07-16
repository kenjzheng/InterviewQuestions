package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 7/15/2018.
  * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
  * and deserialize(s), which deserializes the string back into the tree.
  * For example, given the following Node class
  * class Node:
  * def __init__(self, val, left=None, right=None):
  * self.val = val
  * self.left = left
  * self.right = right
  * The following test should pass:
  **
  *node = Node('root', Node('left', Node('left.left')), Node('right'))
  *assert deserialize(serialize(node)).left.left.val == 'left.left'
  */
object Question3 extends App {
  case class Node(value:String, var left:Node, var right:Node) {}

  val left = new Node("left",new Node("left.left",new Node("left.left.left",new Node("left.left.left.left",null,null),null),new Node("left.left.right",null,null)),null)
  val right = new Node("right",null,new Node("right.right",null,null))
  val root = new Node("root", left, right)

  def serialize(node:Node,nodeType:String):String = {
    var leftString = ""
    var rightString = ""


    if(node.left!=null){
      leftString = serialize(node.left,"left")
    }

    if(node.right!=null){
      rightString = serialize(node.right,"right")
    }

    nodeType+","+node.value + "|" + leftString + "|" + rightString
  }

  var indexPointer = 0
  def growTree(nodes:Array[String]):Node = {
    val nodeDefinition = nodes(indexPointer).split(',')
    val node = new Node(nodeDefinition(1),null,null)
    if(nodes.length>(indexPointer+1)) {
      indexPointer +=1
      if(nodes(indexPointer)!="")
        node.left = growTree(nodes)
    }

    if(nodes.length>(indexPointer+1)) {
      indexPointer +=1
      if(nodes(indexPointer)!="")
        node.right = growTree(nodes)
    }

    node
  }

  def deserialize(str:String):Node = {
    val nodes = str.split('|')
    val root = new Node(nodes(0).split(',')(1),null,null)
    if(nodes.length>(indexPointer+1)) {
      indexPointer +=1
      if(nodes(indexPointer) != "")
        root.left = growTree(nodes)
    }

    if(nodes.length>(indexPointer+1)) {
      indexPointer +=1
      if(nodes(indexPointer) != "")
        root.right = growTree(nodes)
    }

    root
  }

  //output of serialized string
  println(serialize(root,"root"))

  //deserizlized object
  val test = deserialize(serialize(root,"root"))

  //serialize this new object into string again, easier for comparison
  println(serialize(test,"root"))

  //check node value matching
  println(test.left.left.value == "left.left")
}
