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
- **Knowledge Sources:**
  - My name (field)
  - My current hit points (field)
  - Which body part to strike on opponent (I can ask my Script, or own decision for now)
  - Which of my body parts to parry (I can ask my Script, or own decision for now)
  - My current body part states for this turn (1 parried, 2 unparried)
  - Damage amount (given as parameter when taking damage)
- **Collaborators:**
  - Strike (I create them)
  - Body Part (I create parried/unparried versions; I provide them when asked; they tell me to take damage)
  - Script (I consult for decisions - future iteration)

**Arena**
- **Responsibilities:**
  - Accept fighters who wish to duel
  - Orchestrate simultaneous exchanges between fighters
- **Knowledge Sources:**
  - The two fighters in the duel (fields)
- **Collaborators:**
  - Fighter (I orchestrate their exchanges)
  - Exchange (I create and execute them)

**Strike**
- **Responsibilities:**
  - Land on a target body part
- **Knowledge Sources:**
  - Which body part type I target (head, torso, or legs) (field)
  - The actual body part to land on (I ask target Fighter)
- **Collaborators:**
  - Fighter (I ask for the body part I'm targeting)
  - Body Part (I land on it - could be parried or unparried)

**Unparried Body Part**
- **Responsibilities:**
  - ID self (head, torso, or legs)
  - Handle being struck (apply damage to my owner)
- **Knowledge Sources:**
  - My identity (head, torso, or legs) (field)
  - My damage value (field: head=25, torso=15, legs=10)
  - My owner Fighter (field)
- **Collaborators:**
  - Fighter (I tell my owner to take damage when I'm struck)

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
- **Knowledge Sources:**
  - The two fighters (given as parameters)
  - Each fighter's strike for this exchange (I can ask Fighters)
- **Collaborators:**
  - Fighter (I ask for their strike)
  - Strike (I tell them to land)

