import java.util.Date

/**
  * Created by root on 2019/7/8.
  *
  * 函数
  */
class demo_02 {

}


object demo_02{

  //注意，有返回值的函数定义在大括号前必须有等号，不能省略。
  def fun(x:Int,y:Int): Int = {
    if (x > y){
      x
    } else {
      y
    }
  }

  def fun1(x:Int,y:Int) {
    if (x > y){
        x
    } else {
        y
    }
  }

  def fun2{println("2222222")}

  def addInt(x:Int, y:Int) = x + y

  def myFun(f : (Int,Int) => Int, x:Int, y:Int) = f(x,y)

  //递归函数
  def fun3(num :Int) :Int= {
    if(num ==1)
      num
    else
      num * fun3(num-1)
  }

  //包含参数默认值的函数
  def fun3(a :Int = 10,b:Int) = {
    println(a+b)
  }

  //可变参数个数的函数
  def fun4(elements :Int*)={
    var sum = 0;
    for(elem <- elements){
      sum += elem
    }
    sum
  }

  //匿名函数:1、可以将匿名函数返回给val定义的值  2、匿名函数不能显示声明函数的返回类型
  //有参数匿名函数
  val value1 = (a : Int) => {
    println(a)
  }

  //无参数匿名函数
  val value2 = ()=>{
    println("我爱北京")
  }

  //有返回值的匿名函数
  val value3 = (a:Int,b:Int) =>{
    a+b
  }
  println(value3(4,4))

  //嵌套函数:方法里面套方法，从上到下执行
  def fun5(num:Int)={
    def fun6(a:Int,b:Int):Int={
      if(a == 1){
        b
      }else{
        fun6(a-1,a*b)
      }
    }
    fun6(num,1)
  }

  //偏应用函数
  def log(date :Date, s :String)= {
    println("date is "+ date +",log is "+ s)
  }

  //高阶函数:函数的参数是函数\或者函数的返回是函数\或者函数的参数和返回都是函数
  //函数的参数是函数
  def hightFun(f : (Int,Int) =>Int, a:Int ) : Int = {
    f(a,100)
  }
  def f(v1 :Int,v2: Int):Int  = {
    v1+v2
  }

  //函数的返回是函数
  //1，2,3,4相加
  def hightFun2(a : Int,b:Int) : (Int,Int,Int)=>Int = {
    def f2 (v1: Int,v2:Int,v3:Int) :Int = {
      v1+v2+v3+a+b
    }
    f2
  }

  //函数的参数是函数，函数的返回是函数
  def hightFun3(f : (Int ,Int) => Int) : (Int,Int) => Int = {
    f
  }

  //柯里化函数:理解为高阶函数的简化
  def fun7(a :Int,b:Int)(c:Int,d:Int) = {
    a+b+c+d
  }







  def main(args: Array[String]): Unit = {
    println(fun(3,4))
    println(fun1(3,4))
    fun2
    println(addInt(1,2))
    println(myFun(addInt, 4, 2))
    println(fun3(5))
    fun3(b=2)
    println(fun4(1,2,3,4))
    value1(1)
    value2()
    println(value3(4,4))
    println(fun5(5))
    val date = new Date()
    log(date ,"log1")
    //想要调用log，以上变化的是第二个参数，可以用偏应用函数处理
    val logWithDate = log(date,_:String)
    logWithDate("log11")
    println(hightFun(f, 1))
    println(hightFun2(1,2)(3,4,5))
    println(hightFun3(f)(100,200))
    println(hightFun3((a,b) =>{a+b})(200,200))
    println(fun7(1,2)(3,4))

  }

}
