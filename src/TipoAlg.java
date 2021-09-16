public enum TipoAlg {
    InsertionAlg{
        @Override
        public StrategyAlg getStrategyAlg() {
            return new InsertionAlg();
        }
    },
    QuickAlg {
        @Override
        public StrategyAlg getStrategyAlg() {
            return new QuickAlg();
        }
    };

    public abstract StrategyAlg getStrategyAlg();
}
