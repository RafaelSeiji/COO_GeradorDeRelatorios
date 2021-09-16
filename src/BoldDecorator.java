class BoldDecorator extends PrintDecorator{
	public BoldDecorator(Produto p){
		produto = p;
   }
   public String formataParaImpressao(){
		String formattedPrint;	   
	   formattedPrint = "<span style=\"font-weight:bold\">";
	   return formattedPrint;   
   }
}