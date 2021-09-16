public class ExcValorInvalido extends Exception {
    //protected int op;
    //protected int[] opDispo;
/*
    public ExcValorInvalido (int op, int[] opDispo){
        super();
        this.op = op;
        this.opDispo= opDispo;
        
    }*/

    /**
 *
 */

@Override
    public String toString(){
        return "\nERRO: OPCAO INDISPONÍVEL, CONFIRA NOVAMENTE A TABELA\n";
    }
}