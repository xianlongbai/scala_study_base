/**
  * Created by root on 2019/7/9.
  *
  * trait
  */

trait Read {
  val readType = "Read"
  val gender = "m"
  def read(name:String){
    println(name+" is reading")
  }
}

trait Listen {
  val listenType = "Listen"
  val gender = "m"
  def listen(name:String){
    println(name + " is listenning")
  }
}


class demo_04 extends Read with Listen{
  override val gender = "f"

  override def listen(name: String): Unit ={
    println(name + "is llllllllllll")
  }

  /**
    * 注意点：
    * 1.模式匹配不仅可以匹配值，还可以匹配类型
    * 2.模式匹配中，如果匹配到对应的类型或值，就不再继续往下匹配
    * 3.模式匹配中，都匹配不上时，会匹配到 case _ ，相当于default
    */
  def matchTest(x:Any) ={
    x match {
      case x:Int=> println("type is Int")
      case 1 => println("result is 1")
      case 2 => println("result is 2")
      case 3=> println("result is 3")
      case 4 => println("result is 4")
      case x:String => println("type is String")
      //      case x :Double => println("type is Double")
      case _ => println("no match")
    }
  }

}

object demo_04{

  def main(args: Array[String]): Unit = {
    val person= new demo_04()
    println(person.gender)
    person.listen("aaaa")
    person.read("bbbb")

    val tuple = Tuple6(1,2,3f,4,"abc",55d)
    val tupleIterator = tuple.productIterator
    while(tupleIterator.hasNext){
      person.matchTest(tupleIterator.next())
    }

  }

}
