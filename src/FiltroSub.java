public class FiltroSub extends StrategyFiltro {
    public boolean Filtro(Produto p, Object filtro) {
        String s1 = p.getDescricao().toLowerCase();
        String s2 = (String)filtro;
        s2 = s2.toLowerCase();
        if(s1.contains(s2)) return true;
        return false;
    }
}
