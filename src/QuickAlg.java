public class QuickAlg  implements StrategyAlg{

    @Override
    public void Alg(int ini, int fim, StrategyCrit sc, Produto[] p){
        if(ini < fim) {

            int q = particiona(ini, fim, sc, p);

            Alg(ini, q,sc, p);
            Alg(q + 1, fim,sc, p);
        }
    }
    private int particiona(int ini, int fim, StrategyCrit sc, Produto[] p){
        Produto x = p[ini];
        int i = (ini - 1);
        int j = (fim + 1);
        int[] array = new int[2];
        array[0] = i;
        array[1]= j;
        while(true){
            sc.Crit(p,x,array);
                //throw new RuntimeException("Criterio invalido!");

            if(array[0] < array[1]){
                Produto temp = p[array[0]];
                p[array[0]] = p[array[1]];
                p[array[1]] = temp;
            }
            else return array[1];
        }
    }
}
