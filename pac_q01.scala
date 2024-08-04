object Inventory{

  val inventory1: Map[Int,(String,Int,Double)] = Map(
    101 -> ("ProductA",50,29.99),
    102 -> ("ProductB",30,19.99),
    103 -> ("ProductC",20,39.99)
  )

  val inventory2:Map[Int,(String,Int,Double)]=Map(
    102 -> ("ProductB",10,21.99),
    104 -> ("ProductD",25,49.99)
  )
  def printInventory(inventory:Map[Int,(String,Int,Double)]):Unit={
    for((_,(name,_,_))<-inventory){
      println(s"Name: $name");
    }
  }
  def calculateTotalValue(inventory:Map[Int,(String,Int,Double)]):Unit={
    var totalValue:Double=0;
    for((_,(_,qty,price))<-inventory){
      totalValue += qty*price;
    }
    println("Total value: Rs." + totalValue);
  }
  def checkEmpty(inventory:Map[Int,(String,Int,Double)]):Unit={
    if(inventory.isEmpty){
      println("Inventory is empty\n");
    }else{
      println("Inventory is not empty\n");
    }
  }

   def mergedInventory(inventory1: Map[Int, (String, Int, Double)],inventory2: Map[Int, (String, Int, Double)]): Unit = {
    var mergedInventory = inventory1

    for ((id2, (name2, qty2, price2)) <- inventory2) {
      if (mergedInventory.contains(id2)) {
        val (name1, qty1, price1) = mergedInventory(id2)
        mergedInventory = mergedInventory.updated(id2, (name1, qty1 + qty2, Math.max(price1, price2)))
      } else {
        mergedInventory += (id2 -> (name2, qty2, price2))
      }
    }
    for((id,(name,qty,price))<-mergedInventory){
      println(s"Id: $id  Name: $name  Qty: $qty  Price:$price");
    }
  }
 
  def checkProductExists(inventory: Map[Int, (String, Int, Double)], id: Int): Unit = {
    inventory.get(id) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $id, Name: $name, Quantity: $quantity, Price: $price \n")
      case None =>
        println(s"Product ID: $id does not exist in the inventory.\n")
    }
  }

  def main(args:Array[String]):Unit ={
    println("\n\n-------INVENTORY 01 PRODUCT NAMES-------");
    printInventory(inventory1);

    println("\n\n--------CALCULATE THE TOTAL VALUE OF ALL PRODUCTS IN INVENTORY 01-------");
    calculateTotalValue(inventory1);

    println("\n\n-------CHECK INVENTORY 01 IS EMPTY-------");
    checkEmpty(inventory1);

    println("\n\n-------MERGE INVENTORY 01 AND INVENTORY 02-------");
    mergedInventory(inventory1,inventory2 );

    println("\n\n-------CHECK PRODUCT ID 102 EXIST IN INVENTORY 01-------");
    checkProductExists(inventory1,102);
  }
}