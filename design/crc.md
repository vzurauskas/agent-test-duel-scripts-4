# CRC Cards

**Fighter**
- **Responsibilities:**
  - ID self
  - Describe self
  - Decide where to strike and what to parry
  - Prepare for turn (create parried and unparried body parts)
  - Create a strike against an opponent's body part 
  - Provide a body part when asked (parried or unparried version)
  - Take damage to hit points
  - Notify FightHistory of damage taken, remaining HP, and death
- **Knowledge Sources:**
  - My name (field)
  - My current hit points (field)
  - Which body part to strike on opponent (I can ask my Script, or own decision for now)
  - Which of my body parts to parry (I can ask my Script, or own decision for now)
  - My current body part states for this turn (1 parried, 2 unparried)
  - Damage amount (given as parameter when taking damage)
  - My weapon (field) - to create Strike
  - FightHistory (field) - to create Strike
- **Collaborators:**
  - Strike (I create them)
  - Body Part (I create parried/unparried versions; I provide them when asked; they tell me to take damage)
  - Script (I consult for decisions - future iteration)
  - Weapon 
  - FightHistory

**Arena**
- **Responsibilities:**
  - Accept fighters who wish to duel
  - Orchestrate simultaneous exchanges between fighters
- **Knowledge Sources:**
  - The two fighters in the duel (fields)
  - FightHistory (field) - to create Exchange
- **Collaborators:**
  - Fighter (I orchestrate their exchanges)
  - Exchange (I create and execute them)
  - FightHistory

**Strike**
- **Responsibilities:**
  - Land on a target body part
  - Notify FightHistory of target, weapon, and whether parried or landed
- **Knowledge Sources:**
  - BodyPart type (head, torso, or legs) (field) - to ask from target Fighter
  - BodyPart (I ask target Fighter) - to land on
  - The weapon used in this strike (field) - ask for damage
- **Collaborators:**
  - Fighter (I ask for the body part I'm targeting)
  - Body Part 
  - Weapon 
  - FightHistory

**Unparried Body Part**
- **Responsibilities:**
  - ID self (head, torso, or legs)
  - Handle being struck (apply damage to my owner)
  - Notify FightHistory of damage received
- **Knowledge Sources:**
  - My identity (head, torso, or legs) (field)
  - My base damage value (field)
  - My owner Fighter (field)
  - Weapon damage (given as parameter when struck)
  - FightHistory (field)
- **Collaborators:**
  - Fighter (I tell my owner to take damage when I'm struck)
  - FightHistory

**Parried Body Part**
- **Responsibilities:**
  - ID self (head, torso, or legs)
  - Handle being struck (deflect - no damage)
- **Knowledge Sources:**
  - My identity (head, torso, or legs) (field)
  - My owner Fighter (field) (not used, but I could describe myself as parried)
- **Collaborators:**
  - (none - I deflect strikes without applying damage)

**Exchange**
- **Responsibilities:**
  - Execute both fighters' strikes simultaneously
  - Coordinate the landing of strikes
  - Notify FightHistory of round boundaries (start/end)
- **Knowledge Sources:**
  - The two fighters (given as parameters)
  - Each fighter's strike for this exchange (I can ask Fighters)
- **Collaborators:**
  - Fighter (I ask for their strike)
  - Strike (I tell them to land)
  - FightHistory

**Weapon**
- **Responsibilities:**
  - ID self 
  - Calculate damage for a strike (multiplier × critical multiplier if critical)
  - Determine if a strike is critical
  - Notify FightHistory of critical hit when one occurs
- **Knowledge Sources:**
  - My damage multiplier (field) 
  - My critical hit chance (field) 
  - My critical multiplier (field)
  - FightHistory (field)
- **Collaborators:**
  - FightHistory

**FightHistory**
- **Responsibilities:**
  - Accept notifications from objects and remember facts
  - Describe self round by round
  - Report fighters' remaining health at end of each round
  - Report if a fighter died
- **Knowledge Sources:**
  - The accumulated facts/events (field)
- **Collaborators:**
  - (none)

