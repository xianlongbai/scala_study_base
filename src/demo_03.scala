/**
  * Created by root on 2019/7/8.
  * String、集合的一些常用方法
  */
class demo_03 {

}

object demo_03{

  def main(args: Array[String]): Unit = {
    val nameList = List(
      "hello bjsxt",
      "hello xasxt",
      "hello shsxt"
    )

    val mapResult:List[Array[String]] = nameList.map(_.split(" "))
    mapResult.foreach(x => println(x(0)))
    for (elem <- mapResult) {
      println(elem(1))
    }


    val map = Map(
      "1" -> "bjsxt",
      2 -> "shsxt",
      (3,"xasxt")
    )

    val tuple2 = (1,2)
    val tuple3 = (1,2,"kkk")

    //翻转，只针对二元组
    println(tuple2.swap)

    //toString
    println(tuple3.toString())

  }
}