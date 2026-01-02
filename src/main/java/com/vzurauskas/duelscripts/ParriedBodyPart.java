package com.vzurauskas.duelscripts;

final class ParriedBodyPart implements BodyPart {
    private final BodyPartType type;
    
    ParriedBodyPart(final BodyPartType type) {
        this.type = type;
    }
    
    @Override
    public String name() {
        return this.type.partName();
    }

    @Override
    public void acceptStrike(final Fighter owner, final double weaponDamage) {
    }
}

