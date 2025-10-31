# CRC Cards

**Fighter**
- **Responsibilities:**
  - ID self
  - Describe self
  - Decide where to strike and what to parry
  - Create a strike against an opponent's body part
  - Create a parry for own body part
  - Take damage to hit points
- **Knowledge Sources:**
  - My name (field)
  - My current hit points (field)
  - Which body part to strike on opponent (own decision)
  - Which of my body parts to parry (own decision)
  - Damage amount (given as parameter when taking damage)
- **Collaborators:**
  - Strike (I create them)
  - Parry (I create them)
  - Body Part (I choose them for strike/parry)

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
  - Target a specific body part 
  - Land if not deflected by parry
  - Be deflected by matching parry
  - Deal damage to hit points when landing
- **Knowledge Sources:**
  - My target body part (field)
  - Damage amount for that body part (I can ask Body Part)
- **Collaborators:**
  - Body Part (I ask for damage value)

**Parry**
- **Responsibilities:**
  - Protect one body part 
  - Deflect strikes to the protected body part 
- **Knowledge Sources:**
  - Which body part is protected
  - Whether incoming strike targets that body part
- **Collaborators:**
  - Body Part (I know which one I protect)
  - Strike (I can ask what body part it targets)

**Body Part**
- **Responsibilities:**
  - ID self (head, torso, or legs)
  - Be a target for strikes 
  - Represent different damage 
- **Knowledge Sources:**
  - My identity (head, torso, or legs) (field)
  - My damage value (head: 5, torso: 3, legs: 1) (field)
- **Collaborators:**
  - (none needed - I'm self-sufficient for my responsibilities)

**Exchange**
- **Responsibilities:**
  - Execute both fighters' strikes and parries simultaneously
  - Resolve which strikes land and which are blocked
  - Apply damage from successful strikes to fighters
- **Knowledge Sources:**
  - The two fighters (given as parameters)
  - Each fighter's strike and parry for this exchange (I can ask Fighters)
  - Whether a parry blocks a strike (I can ask Parry)
  - How much damage a strike deals (I can ask Strike)
- **Collaborators:**
  - Fighter (I ask for their actions and apply damage to them)
  - Strike (I ask for damage amounts)
  - Parry (I ask if they block strikes)

