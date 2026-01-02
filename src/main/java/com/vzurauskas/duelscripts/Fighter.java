package com.vzurauskas.duelscripts;

final class Fighter {
    private final String name;
    private final Weapon weapon;
    private int hitPoints;
    private BodyPartType strikeTarget;
    private BodyPart head;
    private BodyPart torso;
    private BodyPart legs;

    Fighter(final String name) {
        this(name, new Weapon(1.0, 0.0, 1.0));
    }

    Fighter(final String name, final Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        this.hitPoints = 20;
        this.strikeTarget = BodyPartType.HEAD;
        this.head = new UnparriedBodyPart(BodyPartType.HEAD);
        this.torso = new UnparriedBodyPart(BodyPartType.TORSO);
        this.legs = new UnparriedBodyPart(BodyPartType.LEGS);
    }
    
    String name() {
        return this.name;
    }
    
    int hitPoints() {
        return this.hitPoints;
    }
    
    void decideActions(
        final BodyPartType strikeTarget,
        final BodyPartType parryTarget
    ) {
        this.strikeTarget = strikeTarget;
        if (parryTarget == BodyPartType.HEAD) {
            this.head = new ParriedBodyPart(BodyPartType.HEAD);
            this.torso = new UnparriedBodyPart(BodyPartType.TORSO);
            this.legs = new UnparriedBodyPart(BodyPartType.LEGS);
        } else if (parryTarget == BodyPartType.TORSO) {
            this.head = new UnparriedBodyPart(BodyPartType.HEAD);
            this.torso = new ParriedBodyPart(BodyPartType.TORSO);
            this.legs = new UnparriedBodyPart(BodyPartType.LEGS);
        } else {
            this.head = new UnparriedBodyPart(BodyPartType.HEAD);
            this.torso = new UnparriedBodyPart(BodyPartType.TORSO);
            this.legs = new ParriedBodyPart(BodyPartType.LEGS);
        }
    }
    
    BodyPart bodyPart(final BodyPartType type) {
        if (type == BodyPartType.HEAD) {
            return this.head;
        } else if (type == BodyPartType.TORSO) {
            return this.torso;
        } else {
            return this.legs;
        }
    }
    
    Strike strike() {
        return new Strike(this.strikeTarget, this.weapon);
    }
    
    void takeDamage(final int amount) {
        this.hitPoints = this.hitPoints - amount;
    }
}

