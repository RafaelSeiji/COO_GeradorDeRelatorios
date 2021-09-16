public class FiltroCat extends StrategyFiltro{
    public boolean Filtro(Produto p, Object filtro) {
        if(p.getCategoria().equalsIgnoreCase((String)filtro)) return true;
        return false;
    }
}
