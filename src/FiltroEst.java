public class FiltroEst extends StrategyFiltro{

    public boolean Filtro(Produto p, Object filtro){
        if(p.getQtdEstoque() <= (Integer) filtro) return true;
        return false;
    }
}
