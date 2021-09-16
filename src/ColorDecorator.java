class ColorDecorator extends PrintDecorator{
	public ColorDecorator(Produto p){
		produto = p;
   }
   public String formataParaImpressao(String cor){
		String formattedPrint;	
		switch (cor){
			case "black":
				formattedPrint = "<span style = \"color:black\">";
			break;	
			case "red":
				formattedPrint = "<span style = \"color:red\">";
			break;
			case "green":
				formattedPrint = "<span style = \"color:green\">";
			break;
			default:
				formattedPrint = "<span style = \"color:black\">";
			break;
		}
	   return formattedPrint;
   }
}