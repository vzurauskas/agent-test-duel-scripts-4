# CRC Review: Strike Object and Related Objects

**Date:** November 17, 2025  
**Reviewer:** CRC Designer (Object Thinking)

## Problem Identified

Strike, Parry, and Body Part were **anemic objects** - data structures masquerading as objects with only passive "tell" responsibilities.

### Strike (Original - PROBLEMATIC)
- **Responsibilities:**
  - Tell what body part I target ❌ (passive getter)
  - Tell how much damage I deal ❌ (passive getter)

**Issues:**
1. Only has passive responsibilities (getters)
2. Doesn't DO anything actively
3. Exchange was doing all the work, interrogating Strike for data
4. Violates "avoid passive responsibilities" principle
5. Can't be anthropomorphized meaningfully - a strike doesn't just sit there answering questions, it wants to LAND and DEAL DAMAGE

### Similar Issues
- **Parry:** "Tell what body part I protect" (passive)
- **Body Part:** All responsibilities were passive (ID self, represent damage)

## Solution Applied

Reframed all objects with **active responsibilities** that reflect what they actually DO:

### Strike (Revised - ACTIVE)
- **Responsibilities:**
  - Land on a Fighter (dealing damage if not blocked) ✅
  - Calculate my damage based on weapon and target ✅

Now Strike actively lands on Fighters and deals damage, rather than passively answering questions.

### Parry (Revised - ACTIVE)
- **Responsibilities:**
  - Block incoming strikes to my protected body part ✅
  - Deflect a strike (if it targets my protected part) ✅

Now Parry actively blocks and deflects, rather than just telling what it protects.

### Body Part (Revised - ACTIVE)
- **Responsibilities:**
  - ID self (head, torso, or legs)
  - Provide my damage value

Note: Body Part has one passive responsibility ("Provide my damage value"), but this is acceptable as it's acting as a value object. The key improvement is in Strike, Parry, and Exchange having active responsibilities.

## Key Principles Applied

1. **Active Responsibilities:** Objects DO things, they don't just tell things
2. **Anthropomorphization:** Each object can be imagined as a living entity with purpose
3. **Delegation:** Exchange coordinates, but delegates the actual work to Strike and Parry
4. **Behavioral Focus:** Responsibilities describe behaviors, not data access

## Design Pattern

The coordination model:
- **Exchange** orchestrates simultaneity (coordination responsibility)
- **Strike** and **Parry** perform the actual work (behavioral responsibilities)
- No object is just a passive data holder

## Result

All objects now have clear, active responsibilities that make them legitimate objects in the Object Thinking sense. Each object is a self-sufficient organism that actively contributes to the duel mechanics.

---

## Further Refinement: Polymorphic Body Parts

**Date:** November 17, 2025  
**Improvement:** Eliminated Parry as a separate object by using polymorphism

### Breakthrough Insight

Instead of having Strike check if it's blocked by a Parry, use **polymorphic body parts**:
- **Unparried Body Part**: accepts damage, applies it to owner
- **Parried Body Part**: refuses damage, deflects the strike

### How It Works

1. **Fighter prepares for turn**: decides which body part to parry, creates 1 Parried + 2 Unparried body parts
2. **Strike asks Fighter**: "give me your head" (or torso/legs)
3. **Fighter returns**: the body part (could be Parried or Unparried)
4. **Strike lands** on the body part
5. **Polymorphism handles blocking**:
   - Unparried: applies damage to owner
   - Parried: does nothing (deflects)

### Benefits

1. **Eliminated Parry object entirely** - no longer needed
2. **No conditional logic** - no "is this blocked?" checks anywhere
3. **Strike is simpler** - just lands, doesn't care about blocking
4. **Exchange is simpler** - just coordinates landing, no block resolution
5. **Polymorphism does the work** - blocking behavior is baked into body part type
6. **More object-oriented** - behavior (accept/refuse damage) is encapsulated in the object itself

### Final Object Model

**Objects:**
- Fighter
- Arena
- Strike
- Unparried Body Part
- Parried Body Part
- Exchange

**Eliminated:**
- ~~Parry~~ (replaced by polymorphism)

This is a textbook example of using polymorphism to eliminate conditional logic and simplify object interactions.

