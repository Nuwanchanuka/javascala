object Cost{
	def main(arr:Array[String]):Unit={
		val book:Double = 24.95;
		var stock_value:Double = 24.95*60*(40/100);
		var ship1:Double = 3*50;
		var ship2:Double = 0.75*10;
		var shipping_price :Double = ship1 + ship2;
		var total:Double=stock_value+shipping_price;
		
		println("Total wholesale cost for 60 copies = Rs. "+ total);
	}
}}