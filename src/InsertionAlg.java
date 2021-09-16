public class InsertionAlg implements StrategyAlg{

    @Override
    public void Alg(int ini, int fim, StrategyCrit sc, Produto[] p) {
        for(int i = ini; i <= fim; i++){

            Produto x = p[i];
            int j = (i - 1);

            while(j >= ini){
                if(!sc.Crit(p, x, j)){
                    break;
                }else{
                    j--;
                }
                //else throw new RuntimeException("Criterio invalido!");
            }

            p[j + 1] = x;
        }
    }
}
