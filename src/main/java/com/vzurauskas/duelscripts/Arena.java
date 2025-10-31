package com.vzurauskas.duelscripts;

final class Arena {
    private final Fighter fighter1;
    private final Fighter fighter2;
    
    Arena(final Fighter fighter1, final Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }
    
    void executeExchange() {
        final Exchange exchange = new Exchange(this.fighter1, this.fighter2);
        exchange.resolve();
    }
}

