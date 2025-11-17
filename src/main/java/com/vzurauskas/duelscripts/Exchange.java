package com.vzurauskas.duelscripts;

final class Exchange {
    private final Fighter fighter1;
    private final Fighter fighter2;
    
    Exchange(final Fighter fighter1, final Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }
    
    void resolve() {
        final Strike strike1 = this.fighter1.strike();
        final Strike strike2 = this.fighter2.strike();
        
        strike1.landOn(this.fighter2);
        strike2.landOn(this.fighter1);
    }
}

