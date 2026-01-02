package com.vzurauskas.duelscripts;

interface BodyPart {
    String name();
    void acceptStrike(Fighter owner, double weaponDamage);
}

