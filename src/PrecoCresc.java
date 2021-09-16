public class PrecoCresc implements StrategyCrit{

    @Override
    public void Crit(Produto[] p, Produto x, int[] array) {//QUICK
        do{
            array[1]--;

        } while(p[array[1]].getPreco() > x.getPreco());

        do{
            array[0]++;

        } while(p[array[0]].getPreco() < x.getPreco());
    }

    @Override
    public boolean Crit(Produto[] p, Produto x, int j) {
        if(x.getPreco() < p[j].getPreco()){

            p[j + 1] = p[j];
            return true;
        }
        else return false;
    }
}
