public enum TipoCrit {
    DescCresc{
        @Override
        public StrategyCrit getStrategyCrit() {
            return new DescCresc();
        }
    },
    PrecoCresc {
        @Override
        public StrategyCrit getStrategyCrit() {
            return new PrecoCresc();
        }
    },
    EstoqueCrec{
        @Override
        public StrategyCrit getStrategyCrit(){
            return new EstoqueCresc();
        }
    },
    DescDecresc{
        @Override
        public StrategyCrit getStrategyCrit() {
            return new DescDecresc();
        }
    },
    PrecoDecresc {
        @Override
        public StrategyCrit getStrategyCrit() {
            return new PrecoDecresc();
        }
    },
    EstoqueDecresc{
        @Override
        public StrategyCrit getStrategyCrit(){
            return new EstoqueDecresc();
        }
    };

    public abstract StrategyCrit getStrategyCrit();
}
