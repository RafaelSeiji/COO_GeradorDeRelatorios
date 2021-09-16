public class EstoqueCresc implements StrategyCrit{
    @Override
    public void Crit(Produto[] p, Produto x, int[] array) {//QUICK
        do{
            array[1]--;

        } while(p[array[1]].getQtdEstoque() > x.getQtdEstoque());

        do{
            array[0]++;

        } while(p[array[0]].getQtdEstoque() < x.getQtdEstoque());
    }

    @Override
    public boolean Crit(Produto[] p, Produto x, int j) {
        if (x.getQtdEstoque() < p[j].getQtdEstoque()) {

            p[j + 1] = p[j];
            return true;
        } else {
            return false;
        }
    }
}
