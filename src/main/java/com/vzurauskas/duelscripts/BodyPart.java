package com.vzurauskas.duelscripts;

interface BodyPart {
    String name();
    int damageValue();
    void acceptStrike(Fighter owner);
}

