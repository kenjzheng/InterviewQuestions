package InterviewQuestions

/**
  * Created by Ken.J.Zheng on 8/8/2018.
  */
/*
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
case class Node(nodeValue:Int, nodeIndex:Int, var child:Node)

class NodeLink{
  var rootNode : Node = null

  //when
  def insert(nodeValue:Int, nodeIndex:Int, node: Node, windowSize:Int): Node ={
    if(node == null)
      return Node(nodeValue, nodeIndex,null)

    if(nodeValue >= node.nodeValue)
      return Node(nodeValue, nodeIndex,null)

    if(nodeValue < node.nodeValue){
      node.child = insert(nodeValue, nodeIndex, node.child, windowSize)
    }

    if(nodeIndex - node.nodeIndex >= windowSize)
      return node.child

    node
  }
}

object Question11 extends App {
  def maxInWindow(arr: Array[Int], k: Int) = {
    val bt = new NodeLink()
    var count = 0
    for(i <- 0 to arr.length-1){
      count += 1
      bt.rootNode = bt.insert(arr(i),i,bt.rootNode,k)
      if(count>=k){
        println(bt.rootNode.nodeValue)
      }
      val test = 0
    }
  }

  val test1 = Array(10, 5, 2, 7, 8, 7)
  println("maxInWindow(test1,3)")
  maxInWindow(test1,3)
  println("maxInWindow(test1,1)")
  maxInWindow(test1,1)
  println("maxInWindow(test1,5)")
  maxInWindow(test1,5)

  val test2 = Array(10,9,8,7,6,5,4,3,2,1)
  println("maxInWindow(test2,3)")
  maxInWindow(test2,3)
}
