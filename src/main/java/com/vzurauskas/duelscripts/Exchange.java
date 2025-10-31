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
        final Parry parry1 = this.fighter1.parry();
        final Strike strike2 = this.fighter2.strike();
        final Parry parry2 = this.fighter2.parry();
        
        if (!parry2.deflects(strike1)) {
            this.fighter2.takeDamage(strike1.damage());
        }
        if (!parry1.deflects(strike2)) {
            this.fighter1.takeDamage(strike2.damage());
        }
    }
}

