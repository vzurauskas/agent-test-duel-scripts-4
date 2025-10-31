package com.vzurauskas.duelscripts;

final class Parry {
    private final BodyPart protectedPart;
    
    Parry(final BodyPart protectedPart) {
        this.protectedPart = protectedPart;
    }
    
    BodyPart protects() {
        return this.protectedPart;
    }
    
    boolean deflects(final Strike strike) {
        return this.protectedPart == strike.target();
    }
}

