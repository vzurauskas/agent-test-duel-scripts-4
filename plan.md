# Refactoring Plan: Polymorphic Body Parts

## Goal
Eliminate Parry as a separate object and use polymorphic body parts (Parried/Unparried) to handle strike deflection through polymorphism.

## Current State
- BodyPart: static constants (HEAD, TORSO, LEGS) with damage values
- Strike: holds BodyPart reference, provides damage()
- Parry: holds BodyPart reference, checks if it deflects Strike
- Exchange: asks Parry if deflected, applies damage to Fighter
- Fighter: creates Strike and Parry based on decisions
- All 5 tests pass ✅

## Target State
- BodyPart: interface with UnparriedBodyPart and ParriedBodyPart implementations
- Fighter: creates body part instances, provides them when asked
- Strike: asks Fighter for body part, lands on it
- Body parts: handle being struck polymorphically (accept or deflect)
- No Parry object
- No conditional "is blocked?" logic

## Refactoring Steps (Keep Tests Green)

### Step 1: Introduce BodyPart Interface
- [x] Convert BodyPart from class to interface (keep name() and damageValue())
- [x] Create BodyPartType enum (HEAD, TORSO, LEGS) to replace static constants
- [x] Update all code to use BodyPartType instead of BodyPart constants
- [x] Run tests - should still pass ✅

### Step 2: Create Unparried Body Part Implementation
- [x] Create UnparriedBodyPart implementing BodyPart
- [x] Add acceptStrike(Fighter owner) method to BodyPart interface
- [x] Implement acceptStrike() in UnparriedBodyPart (applies damage to owner)
- [x] Tests don't use this yet, so they still pass ✅

### Step 3: Create Parried Body Part Implementation
- [x] Create ParriedBodyPart implementing BodyPart
- [x] Implement acceptStrike() in ParriedBodyPart (does nothing - deflects)
- [x] Tests don't use this yet, so they still pass ✅

### Step 4: Update Fighter to Create Body Part Instances
- [x] Add Fighter.bodyPart(BodyPartType) method
- [x] Update Fighter.decideActions() to create 3 body part instances (1 parried, 2 unparried)
- [x] Keep Fighter.parry() for backward compatibility
- [x] Run tests - should still pass ✅

### Step 5: Update Strike to Land on Fighter's Body Parts
- [x] Change Strike constructor to accept BodyPartType (not BodyPart)
- [x] Add Strike.landOn(Fighter) method that calls fighter.bodyPart() and acceptStrike()
- [x] Keep Strike.damage() and Strike.target() for backward compatibility
- [x] Run tests - should still pass ✅

### Step 6: Refactor Exchange to Use New Strike Behavior
- [x] Change Exchange.resolve() to call strike.landOn(fighter) instead of checking parry
- [x] Run tests - should still pass (polymorphism now does the work!) ✅ 🎉

### Step 7: Remove Parry Object and Dead Code
- [x] Delete Parry.java
- [x] Remove Fighter.parry()
- [x] Remove Strike.damage() and Strike.target()
- [x] Run tests - should still pass ✅

## Verification ✅ COMPLETE
After each step, run: `mvn test`
Final check: All 5 tests pass ✅, Parry class deleted ✅, no conditional blocking logic ✅

## Refactoring Complete! 🎉

The polymorphic body part design is now fully implemented:
- Parry object eliminated
- UnparriedBodyPart and ParriedBodyPart handle blocking polymorphically
- Exchange has no conditional "is blocked?" logic
- All 5 tests pass
- Code is cleaner and more object-oriented

<!-- AI:DO-NOT-EDIT:BEGIN -->
Next: Weapon
<!-- AI:DO-NOT-EDIT:END -->