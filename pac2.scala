object practical02{
    def filterAboveFive(list: List[String]):List[String]={
        list.filter(_.length > 5)
    }

    def main(args: Array[String]):Unit={
        var MyList = List("will print" , "Apple" , "Orange" , "No" , "grapes")
        var aboveFive = filterAboveFive(MyList)
        println(aboveFive)
    }
}