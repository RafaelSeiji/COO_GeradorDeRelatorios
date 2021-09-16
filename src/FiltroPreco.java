public class FiltroPreco extends StrategyFiltro{
    @Override
    public boolean Filtro(Produto p, Object[] filtro) {
        if(p.getPreco() >= (Integer) filtro[0] && p.getPreco() <= (Integer) filtro[1]) {
            return true;
        }
        return false;
    }
}
