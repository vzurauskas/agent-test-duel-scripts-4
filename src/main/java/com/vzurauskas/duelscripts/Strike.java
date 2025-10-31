package com.vzurauskas.duelscripts;

final class Strike {
    private final BodyPart target;
    
    Strike(final BodyPart target) {
        this.target = target;
    }
    
    BodyPart target() {
        return this.target;
    }
    
    int damage() {
        return this.target.damageValue();
    }
}

