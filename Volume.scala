object Volume{
	def main(arr:Array[String]):Unit = {
		val Pi = 3.14F;
		var r=5;
		
		var vol:Double = 4/3*Pi*r*r*r;
		
		println("Volume of a sphere with radius 5 = "+ vol);
	}
}