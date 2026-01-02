package com.vzurauskas.duelscripts;

final class UnparriedBodyPart implements BodyPart {
    private final BodyPartType type;
    
    UnparriedBodyPart(final BodyPartType type) {
        this.type = type;
    }
    
    @Override
    public String name() {
        return this.type.partName();
    }

    @Override
    public void acceptStrike(final Fighter owner, final double weaponDamage) {
        owner.takeDamage((int) (weaponDamage * this.type.damageValue()));
    }
}

