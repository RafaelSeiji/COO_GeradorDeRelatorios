class ItalicDecorator extends PrintDecorator{
	public ItalicDecorator(Produto p){
		produto = p;
   }
   public String formataParaImpressao(){
		String formattedPrint;	   
	   formattedPrint = "<span style=\"font-style:italic\">";
	   return formattedPrint;   
   }
}