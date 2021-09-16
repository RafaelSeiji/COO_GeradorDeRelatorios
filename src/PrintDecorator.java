abstract class PrintDecorator implements Produto{
	protected Produto produto;

   public void setQtdEstoque(int qtdEstoque){
	   produto.setQtdEstoque(qtdEstoque);
   }
   public void setPreco(double preco){
	   produto.setPreco(preco);
   }

   public int getId(){
	   return produto.getId();
   }
   public String getDescricao(){
	   return produto.getDescricao();
   }
   public String getCategoria(){
	   return produto.getCategoria();
   }
   public int getQtdEstoque(){
	   return produto.getQtdEstoque();
   }
   public double getPreco(){
	   return produto.getPreco();
   }
   public String formataParaImpressao(){
	   return produto.formataParaImpressao();
   }
}