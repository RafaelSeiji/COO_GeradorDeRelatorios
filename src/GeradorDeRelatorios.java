import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeradorDeRelatorios {

	private final Produto[] produtos;
	private final Object argFiltro;
	private final Object[] argFiltro2;
	private final StrategyAlg strategyAlg;
	private final StrategyCrit strategyCrit;
	private final StrategyFiltro strategyFiltro;

	public GeradorDeRelatorios(final Produto[] produtos, final StrategyAlg algoritmo, final StrategyCrit criterio,
		final StrategyFiltro filtro, final Object argFiltro, final Object[] argFiltro2) {

		this.produtos = new Produto[produtos.length];

		for (int i = 0; i < produtos.length; i++) {

			this.produtos[i] = produtos[i];
		}

		this.strategyAlg = algoritmo;
		this.strategyCrit = criterio;
		this.strategyFiltro = filtro;
		this.argFiltro = argFiltro;
		this.argFiltro2 = argFiltro2;
	}

	public void geraRelatorio(final String arquivoSaida) throws IOException {
		strategyAlg.Alg(0, produtos.length - 1, strategyCrit, produtos);
		final Scanner sc = new Scanner(System.in);
		final PrintWriter out = new PrintWriter(arquivoSaida);
		boolean validador = false;
		int relatorioPersonalizado = -1;
		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;
		for (int i = 0; i < produtos.length; i++) {

			final Produto p = produtos[i];
			final BoldDecorator bold = new BoldDecorator(p);
			final ItalicDecorator italic = new ItalicDecorator(p);
			final ColorDecorator cor = new ColorDecorator(p);
			boolean selecionado = false;

			if (argFiltro2[1] != null) {
				if (strategyFiltro.Filtro(p, argFiltro2)) {
					selecionado = true;
				}
			} else {
				if (strategyFiltro.Filtro(p, argFiltro)) {
					selecionado = true;
				}
			}
			// throw new RuntimeException("Filtro invalido!");

			if (selecionado) {

				out.print("<li>");
				if (relatorioPersonalizado == -1) {
					do{	
						//int[] opcoesDispo = {1, 2};
						try {
							System.out.println("Escolha o relatório desejado:");
							System.out.println("(1) Relatorio personalizado [formato e coloração de cada produto]");
							System.out.println("(2) Relatorio simples [formato padrão, coloração preta para todos produtos]");
							relatorioPersonalizado = sc.nextInt();
							if (relatorioPersonalizado != 1 && relatorioPersonalizado != 2){
								throw new ExcValorInvalido();//relatorioPersonalizado, opcoesDispo);
							}				
							validador = true;
						} catch (InputMismatchException e) {
							validador = false;
							sc.nextLine();
							System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
						}
						catch (ExcValorInvalido e) {
							validador = false;
							sc.nextLine();
							System.out.println(e.toString());
						}
					}while(!validador);
				}
				if (relatorioPersonalizado == 1) {
					int color = -1;
					String corTexto = " ";
					int escolha = -1;
					
					do{	
						//int[] opcoesDispo = {0, 1, 2, 3};
						try {
							System.out.println("Escolha a personalizacao do produto a seguir:");
							System.out.println("-- " + p.getDescricao() + " --");
							System.out.println("(1) Negrito");
							System.out.println("(2) Italico");
							System.out.println("(3) Ambos");
							System.out.println("(4) Nenhum [PADRAO]");
							escolha = sc.nextInt() - 1;
							if (escolha != 0 && escolha != 1 && escolha != 2 && escolha != 3){
								throw new ExcValorInvalido();//escolha, opcoesDispo);
							}				
							validador = true;
						} catch (InputMismatchException e) {
							validador = false;
							sc.nextLine();
							System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
						}
						catch (ExcValorInvalido e) {
							validador = false;
							sc.nextLine();
							System.out.println(e.toString());
						}
					}while(!validador);

					do{	
						//int[] opcoesDispo = {0, 1, 2};
						try {
							System.out.println("Escolha a cor de impressão do produto a seguir:");
							System.out.println("-- " + p.getDescricao() + " --");
							System.out.println("(1) Preto [PADRAO]");
							System.out.println("(2) Vermelho");
							System.out.println("(3) Verde");
							color = sc.nextInt() - 1;
							if (color != 0 && color != 1 && color != 2){
								throw new ExcValorInvalido();//color, opcoesDispo);
							}				
							validador = true;
						} catch (InputMismatchException e) {
							validador = false;
							sc.nextLine();
							System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
						}
						catch (ExcValorInvalido e) {
							validador = false;
							sc.nextLine();
							System.out.println(e.toString());
						}
					}while(!validador);
					
					switch (color) {
						case 0:
							corTexto = "black";
							break;
						case 1:
							corTexto = "red";
							break;
						case 2:
							corTexto = "green";
							break;
						/*default:
							System.out.println("\n~ERRO: OPCAO INVALIDA.");
							System.out.println("FOI ESCOLHIDA A OPCAO PADRAO: 'Preto'~\n");
							corTexto = "black";
							break;*/
					}

					switch (escolha) {
						case 0:
							out.print(bold.formataParaImpressao());
							out.print(cor.formataParaImpressao(corTexto));
							break;
						case 1:
							out.print(italic.formataParaImpressao());
							out.print(cor.formataParaImpressao(corTexto));
							break;
						case 2:
							out.print(bold.formataParaImpressao());
							out.print(italic.formataParaImpressao());
							out.print(cor.formataParaImpressao(corTexto));
							break;
						/*default:
							System.out.println("\n~ERRO: OPCAO INVALIDA.");
							System.out.println("FOI ESCOLHIDA A OPCAO PADRAO: 'Nenhum'~\n");
							out.print(p.formataParaImpressao());
							out.print(cor.formataParaImpressao(corTexto));
							break;*/
					}

					out.print(p.formataParaImpressao());

					out.println("</li>");
					count++;
				} else {
					out.print(p.formataParaImpressao());
					out.println("</li>");
					count++;
				}
			}
		}

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.length + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public static Produto[] carregaProdutos() {

		return new Produto[] {

				new ProdutoPadrao(1, "O Hobbit", "Livros", 2, 34.90),
				new ProdutoPadrao(2, "Notebook Core i7", "Informatica", 5, 1999.90),
				new ProdutoPadrao(3, "Resident Evil 4", "Games", 7, 79.90),
				new ProdutoPadrao(4, "iPhone", "Telefonia", 8, 4999.90),
				new ProdutoPadrao(5, "Calculo I", "Livros", 20, 55.00),
				new ProdutoPadrao(6, "Power Glove", "Games", 3, 499.90),
				new ProdutoPadrao(7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
				new ProdutoPadrao(8, "OpenGL Programming Guide", "Livros", 4, 89.90),
				new ProdutoPadrao(9, "Vectrex", "Games", 1, 799.90),
				new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
				new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
				new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
				new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
				new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
				new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
				new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
				new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
				new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
				new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
				new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
				new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
				new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
				new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
				new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
				new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
				new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
				new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
				new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23,
						49.00),
				new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
				new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
				new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
				new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00) };
	}

	public static void main(final String[] args) {
		boolean validador = false;
		GeradorDeRelatorios gdr;
		final Produto[] produtos = carregaProdutos();
		final Scanner sc = new Scanner(System.in);
		
		int alg = -1;
		do{	
			//int[] opcoesDispo = {0, 1};
			try {
				System.out.println("Digite tipo de algoritmo: ");
				System.out.println("(1) InsertionSort");
				System.out.println("(2) QuickSort");
				alg = sc.nextInt() - 1;
				if (alg != 0 && alg != 1){
					throw new ExcValorInvalido();//alg, opcoesDispo);
				}				
				validador = true;
			} catch (final InputMismatchException e) {
				validador = false;
				sc.nextLine();
				System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
			}
			catch (ExcValorInvalido e) {
				validador = false;
				sc.nextLine();
				System.out.println(e.toString());
			}
		}while(!validador);

		TipoAlg tp = null;
		switch (alg) {
			case 0:
				tp = TipoAlg.values()[alg];
				break;
			case 1:
				tp = TipoAlg.values()[alg];
				break;
			/*default:
				alg = 1;
				System.out.println("\n~ERRO: OPCAO INVALIDA.");
				System.out.println("FOI ESCOLHIDA A OPCAO PADRAO: 'QuickSort'~\n");
				tp = TipoAlg.values()[alg];*/
		}
		final StrategyAlg sa = tp.getStrategyAlg();

		int crit = -1;
		do{	
			//int[] opcoesDispo = {0, 1, 2, 3, 4, 5};
			try {
				System.out.println("Digite tipo de criterio: ");
				System.out.println("(1) Descricao crescente");
				System.out.println("(2) Preco crescente");
				System.out.println("(3) Estoque crescente");
				System.out.println("(4) Descricao decrescente");
				System.out.println("(5) Preco decrescente");
				System.out.println("(6) Estoque decrescente");
				crit = sc.nextInt() - 1;
				if (crit != 0 && crit != 1 && crit != 2 && crit != 3 && crit != 4 && crit != 5 ){
					throw new ExcValorInvalido();//crit, opcoesDispo);
				}				
				validador = true;
			} catch (final InputMismatchException e) {
				validador = false;
				sc.nextLine();
				System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
			}
			catch (ExcValorInvalido e) {
				validador = false;
				sc.nextLine();
				System.out.println(e.toString());
			}
		}while(!validador);
		
		TipoCrit tc = null;
		switch (crit) {
			case 0:
				tc = TipoCrit.values()[crit];
				break;
			case 1:
				tc = TipoCrit.values()[crit];
				break;
			case 2:
				tc = TipoCrit.values()[crit];
				break;
			case 3:
				tc = TipoCrit.values()[crit];
				break;
			case 4:
				tc = TipoCrit.values()[crit];
				break;
			case 5:
				tc = TipoCrit.values()[crit];
				break;
			/*default:
				crit = 0;
				System.out.println("\n~ERRO: OPCAO INVALIDA.");
				System.out.println("FOI ESCOLHIDA A OPCAO PADRAO: 'Descricao Crescente'~\n");
				tc = TipoCrit.values()[0];
				break;*/
		}
		final StrategyCrit scr = tc.getStrategyCrit();
		
		int filtro = -1;
		do{	
			//int[] opcoesDispo = {0, 1, 2, 3, 4};
			try {
				System.out.println("Digite tipo de filtro: ");
				System.out.println("(1) Todos");
				System.out.println("(2) Estoque");
				System.out.println("(3) Categoria");
				System.out.println("(4) Faixa de preco");
				System.out.println("(5) Substring");
				filtro = sc.nextInt() - 1;
				if (filtro != 0 && filtro != 1 && filtro != 2 && filtro != 3 && filtro != 4 ){
					throw new ExcValorInvalido();//crit, opcoesDispo);
				}				
				validador = true;
			} catch (final InputMismatchException e) {
				validador = false;
				sc.nextLine();
				System.out.println("\n~ERRO: TIPO INVALIDO.~\n");
			}
			catch (ExcValorInvalido e) {
				validador = false;
				sc.nextLine();
				System.out.println(e.toString());
			}
		}while(!validador);
		 
		TipoFiltro tf = null;
		switch (filtro) {
			case 0:
				tf = TipoFiltro.values()[filtro];
				break;
			case 1:
				tf = TipoFiltro.values()[filtro];
				break;
			case 2:
				tf = TipoFiltro.values()[filtro];
				break;
			case 3:
				tf = TipoFiltro.values()[filtro];
				break;
			case 4:
				tf = TipoFiltro.values()[filtro];
				break;
			/*default:
				filtro = 0;
				System.out.println("\n~ERRO: OPCAO INVALIDA.");
				System.out.println("FOI ESCOLHIDA A OPCAO PADRAO: 'Todos'~\n");
				tf = TipoFiltro.values()[filtro];
				break;*/
		}

		final StrategyFiltro sf = tf.getStrategyFiltro();

		Object f = null;
		final Object[] f2 = new Object[2];
		if (filtro == 1) {
			System.out.println("Digite o estoque minimo: ");
			f = sc.nextInt();
		} else if (filtro == 2) {
			System.out.println("Digite tipo de categoria: ");
			System.out.println("(Livros, Informatica, Games, Telefonia)");
			f = sc.next();
		} else if (filtro == 3) {
			System.out.println("Digite preco minimo: ");
			f2[0] = sc.nextInt();
			System.out.println("Digite preco maximo: ");
			f2[1] = sc.nextInt();
		} else if (filtro == 4) {
			System.out.println("Digite substring");
			f = sc.next();
		}

		gdr = new GeradorDeRelatorios(produtos, sa, scr, sf, f, f2);
		try {
			gdr.geraRelatorio("saida.html");
		} catch (final IOException e) {
			
			e.printStackTrace();
		}
	}
}