/**
  * Created by root on 2019/7/7.
  * class 和 object 和 trait 的区别？
  * 1、calss scala编译器会字段帮我们生产一个私有字段和2个公有方法get和set
  * 2、scala 中没有 static 关键字，所以 对于一个class来说，所有的方法和成员变量在实例被 new 出来之前都是无法访问的，因此在class中的main方法没什么用了
  * 3、scala 的object 中所有成员变量和方法默认都是 static 的，所以可以直接访问main方法
  *
  * 类名与对象名相同，称为伴生对象，类和伴生对象可以相互访问他们的私有属性，但是他们必须在同一个源文件内
  *
  *
  */
class demo_01 (xname : String,xage : Int){

  var name = "xianlong.bai"
  val age = 19
  var gender = "x"

  def sayName(): String = {
    "my name is "+ name
  }

  //重写构造方法
  def this(name:String,age:Int,g:String){
    this(name,age)
    gender = g
  }




}

object demo_01{

  val objstr = "admin"

  def main(args: Array[String]): Unit = {
    println("-----------------------属性、对象、类------------------------")
    var high = 180
    println(high)
    println(objstr)
    val person = new demo_01("xiaoli",23,"mmmm")
    println(person.sayName())
    println(person.name)
    println(person.gender)

    println("---------------------逻辑语法--------------------------")
    var a = 10
    if (a<10){
      println("小")
    }else if (a==10){
      println("一样")
    }else {
      println("大")
    }

    //to和until 的用法（不带步长，带步长区别）
    println(1 to 10 )//打印 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    println(1.to(10))//与上面等价，打印 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

    println(1 to (10 ,2))//步长为2，从1开始打印 ，1,3,5,7,9
    println(1.to(10, 2))

    println(1 until 10 ) //不包含最后一个数，打印 1,2,3,4,5,6,7,8,9
    println(1.until(10))//与上面等价

    println(1 until (10 ,3 ))//步长为2，从1开始打印，打印1,4,7

    //for 循环
    for (x <- 10 to 20 ){
      print(x+",")
    }
    println()
    //例子： 打印小九九
    for(i <- 1 until 10 ;j <- 1 until 10){
      if(i>=j){
        print(i +" * " + j + " = "+ i*j+"	")
      }
      if(i==j ){
        println()
      }
    }

    //for循环中可以加条件判断，分号隔开
    for(i<- 1 to 10 ;if (i%2) == 0 ;if (i >= 5) ){
      println(i)
    }

    val list = for(i <- 1 to 10  ; if(i > 5 )) yield i
    println(list)

    val fruits = List("banana fruit","apple fruit","peach","grapes","pear")
    val filterFruit = for {
      fruit <- fruits
      if fruit.contains("fruit") && !fruit.startsWith("banana")
    } println(fruit)
    println(filterFruit) //filterFruit: Unit = ()




  }

}