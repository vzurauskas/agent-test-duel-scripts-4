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
    public int damageValue() {
        return this.type.damageValue();
    }
    
    @Override
    public void acceptStrike(final Fighter owner) {
        // Deflects - no damage applied
    }
}

