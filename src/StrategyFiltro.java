public abstract class StrategyFiltro {
    public boolean Filtro(Produto p, Object filtro){
        return true;
    }
    public boolean Filtro(Produto p, Object[] filtro){
        return false;
    }
}
