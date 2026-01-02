package com.vzurauskas.duelscripts;

final class Weapon {
    private final double multiplier;
    private final double criticalChance;
    private final double criticalMultiplier;

    Weapon(
        final double multiplier,
        final double criticalChance,
        final double criticalMultiplier
    ) {
        this.multiplier = multiplier;
        this.criticalChance = criticalChance;
        this.criticalMultiplier = criticalMultiplier;
    }

    double damage() {
        if (Math.random() < this.criticalChance) {
            return this.multiplier * this.criticalMultiplier;
        }
        return this.multiplier;
    }
}

