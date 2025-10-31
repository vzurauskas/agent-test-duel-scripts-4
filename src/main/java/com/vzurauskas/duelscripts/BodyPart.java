package com.vzurauskas.duelscripts;

final class BodyPart {
    static final BodyPart HEAD = new BodyPart("head", 5);
    static final BodyPart TORSO = new BodyPart("torso", 3);
    static final BodyPart LEGS = new BodyPart("legs", 2);
    
    private final String name;
    private final int damageValue;
    
    private BodyPart(final String name, final int damageValue) {
        this.name = name;
        this.damageValue = damageValue;
    }
    
    String name() {
        return this.name;
    }
    
    int damageValue() {
        return this.damageValue;
    }
}

