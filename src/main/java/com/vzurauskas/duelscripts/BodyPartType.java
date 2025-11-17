package com.vzurauskas.duelscripts;

enum BodyPartType {
    HEAD("head", 5),
    TORSO("torso", 3),
    LEGS("legs", 2);
    
    private final String name;
    private final int damageValue;
    
    BodyPartType(final String name, final int damageValue) {
        this.name = name;
        this.damageValue = damageValue;
    }
    
    String partName() {
        return this.name;
    }
    
    int damageValue() {
        return this.damageValue;
    }
}

