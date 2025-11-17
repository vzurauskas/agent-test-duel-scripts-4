package com.vzurauskas.duelscripts;

final class Strike {
    private final BodyPartType target;
    
    Strike(final BodyPartType target) {
        this.target = target;
    }
    
    void landOn(final Fighter fighter) {
        final BodyPart bodyPart = fighter.bodyPart(this.target);
        bodyPart.acceptStrike(fighter);
    }
}

