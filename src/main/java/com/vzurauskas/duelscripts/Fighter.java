package com.vzurauskas.duelscripts;

final class Fighter {
    private final String name;
    private int hitPoints;
    private BodyPart strikeTarget;
    private BodyPart parryTarget;
    
    Fighter(final String name) {
        this.name = name;
        this.hitPoints = 20;
        this.strikeTarget = BodyPart.HEAD;
        this.parryTarget = BodyPart.HEAD;
    }
    
    String name() {
        return this.name;
    }
    
    int hitPoints() {
        return this.hitPoints;
    }
    
    void decideActions(
        final BodyPart strikeTarget,
        final BodyPart parryTarget
    ) {
        this.strikeTarget = strikeTarget;
        this.parryTarget = parryTarget;
    }
    
    Strike strike() {
        return new Strike(this.strikeTarget);
    }
    
    Parry parry() {
        return new Parry(this.parryTarget);
    }
    
    void takeDamage(final int amount) {
        this.hitPoints = this.hitPoints - amount;
    }
}

