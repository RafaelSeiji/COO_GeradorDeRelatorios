public enum TipoFiltro {
    FiltroTodos{
        @Override
        public StrategyFiltro getStrategyFiltro() {
            return new FiltroTodos();
        }
    },
    FiltroEst {
        @Override
        public StrategyFiltro getStrategyFiltro() {
            return new FiltroEst();
        }
    },
    FiltroCat{
        @Override
        public StrategyFiltro getStrategyFiltro(){
            return new FiltroCat();
        }
    },
    FiltroPreco {
        @Override
        public StrategyFiltro getStrategyFiltro() {
            return new FiltroPreco();
        }
    },
    FiltroSub{
        @Override
        public StrategyFiltro getStrategyFiltro(){
            return new FiltroSub();
        }
    };


    public abstract StrategyFiltro getStrategyFiltro();
}
