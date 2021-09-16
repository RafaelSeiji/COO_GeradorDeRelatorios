public class DescCresc implements  StrategyCrit{
    @Override
    public void Crit(Produto[] p, Produto x, int[] array) {//QUICK
        do{
            array[1]--;

        } while(p[array[1]].getDescricao().compareToIgnoreCase(x.getDescricao()) > 0);

        do{
            array[0]++;

        } while(p[array[0]].getDescricao().compareToIgnoreCase(x.getDescricao()) < 0);
    }

    @Override
    public boolean Crit(Produto[] p, Produto x, int j){
        if( x.getDescricao().compareToIgnoreCase(p[j].getDescricao()) < 0 ){

            p[j + 1] = p[j];
            return true;
        }else{
            return false;
        }
    }
}
