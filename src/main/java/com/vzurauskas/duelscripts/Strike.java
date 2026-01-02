package com.vzurauskas.duelscripts;

final class Strike {
    private final BodyPartType target;
    private final Weapon weapon;

    Strike(final BodyPartType target, final Weapon weapon) {
        this.target = target;
        this.weapon = weapon;
    }

    void landOn(final Fighter fighter) {
        final BodyPart bodyPart = fighter.bodyPart(this.target);
        bodyPart.acceptStrike(fighter, this.weapon.damage());
    }
}

