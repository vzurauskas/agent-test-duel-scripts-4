A Script is an algorithm that determines a fighter's actions each turn. The fighter consults their script to decide where to strike and what to parry. The script makes these decisions based on knowledge of the fighter themselves, their opponent, and the fight history.

---

## Thick Description

Every fighter carries within them a script—a battle philosophy encoded as behavior. Before each exchange, the fighter turns inward and asks: "Where shall I strike? What shall I parry?" The script answers.

Consider Greta the Grim, who follows the Headhunter script. Her philosophy is brutally simple: always strike the head, always parry the head. When asked, her script speaks without hesitation: "Head. Head." She never wavers, never adapts. Against opponents who neglect their cranial defense, she is devastating. Against those who mirror her strategy, she is stalemated—both fighters endlessly parrying each other's predictable blows.

Marcus the Swift follows a different script: the Adaptive Dancer. His script remembers. It knows where Greta struck last turn, where she parried. It notices patterns. When Marcus asks his script for guidance, it considers the fight history—the sequence of exchanges that have unfolded—and makes a calculated choice. Perhaps Greta has struck the head three times in a row; the Adaptive Dancer anticipates a fourth and parries accordingly, while striking the legs she has neglected to protect.

This matters because the script is the fighter's brain. The fighter knows their own hit points, their weapon, their name—but the script knows *strategy*. When `decideActions` is called on a fighter, the fighter doesn't invent tactics on the spot. Instead, the fighter asks the script: "Given what you know, where should I strike? What should I parry?" The script returns its verdict, and the fighter obeys.

### What the Script Knows

A script cannot make decisions in a vacuum. It must be informed. When consulted, the script receives context:

- **The fighter it serves**: The script knows its owner's current state—remaining hit points, perhaps the weapon they wield. A wounded fighter's script might become more defensive or more desperate.

- **The opponent**: The script knows who stands across the arena. It can see the opponent's remaining hit points, their weapon. A script might exploit a weakened foe by pressing the attack.

- **The fight history**: The script remembers what has transpired. Which body parts were struck? Which were parried? Did the last strike land, or was it deflected? A script that tracks history can detect patterns and adapt—or be fooled by a clever opponent who varies their rhythm.

### A Simple Script: Always Head

The simplest script ignores all context. It always returns the same answer: strike head, parry head. Such a script needs no memory, no analysis. It is pure stubbornness. Yet it is a valid script, and some fighters swear by it.

When Brock the Brawler—who follows this script—asks "Where should I strike?", the script answers "Head." When he asks "What should I parry?", the script answers "Head." Every turn, without fail. Brock is predictable, but predictability has its own power: an opponent who knows Brock will strike the head can parry it, but must sacrifice protection elsewhere.

### An Adaptive Script: Pattern Matcher

A more sophisticated script studies the opponent. It tracks the last several exchanges and looks for tendencies. If the opponent has struck the torso three times running, perhaps they'll strike it again—or perhaps they'll switch. The script makes a bet based on probability and history.

When Marcus asks his Adaptive Dancer script for guidance, the script reviews the fight history, calculates the most likely target, and advises accordingly. This script is harder to predict, but it can also be fooled by an opponent who intentionally varies their pattern.

### The Consultation

The moment of consultation happens at the start of each turn, before the exchange. The fighter prepares for action by asking the script two questions:

1. "Where should I strike?" — The script returns a body part type (head, torso, or legs).
2. "What should I parry?" — The script returns a body part type.

Armed with these answers, the fighter sets up their body parts (one parried, two unparried) and prepares a strike aimed at the designated target. The exchange then proceeds as before: strikes land, damage is calculated, hit points fall.

### Observable Outcomes

After a duel, the fight history reveals the script's influence. A fighter following the Headhunter script will have struck the head every single turn. A fighter following the Adaptive Dancer will show a varied pattern that responds to the opponent's behavior. The script's personality is visible in the record of actions taken.

When a fighter describes themselves, they might mention their script—"I follow the Headhunter philosophy"—just as they mention their weapon. The script is part of their identity as a combatant.

