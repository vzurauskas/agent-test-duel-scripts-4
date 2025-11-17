package com.vzurauskas.duelscripts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class ArenaTest {

    @Test
    void fighterStrikesOpponentsHeadUndefendedAndDeals5Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPartType.HEAD, BodyPartType.HEAD);
        boromir.decideActions(BodyPartType.HEAD, BodyPartType.LEGS);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(15, boromir.hitPoints());
    }

    @Test
    void fighterStrikesOpponentsTorsoUndefendedAndDeals3Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPartType.TORSO, BodyPartType.HEAD);
        boromir.decideActions(BodyPartType.HEAD, BodyPartType.HEAD);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(17, boromir.hitPoints());
    }

    @Test
    void fighterStrikesOpponentsLegsUndefendedAndDeals2Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPartType.LEGS, BodyPartType.HEAD);
        boromir.decideActions(BodyPartType.HEAD, BodyPartType.TORSO);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(18, boromir.hitPoints());
    }

    @Test
    void strikeIsDeflectedWhenFighterParriesTheTargetedBodyPart() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPartType.HEAD, BodyPartType.HEAD);
        boromir.decideActions(BodyPartType.HEAD, BodyPartType.HEAD);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(20, boromir.hitPoints());
    }

    @Test
    void bothFightersStrikeEachOtherSuccessfullyInSimultaneousExchange() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPartType.HEAD, BodyPartType.TORSO);
        boromir.decideActions(BodyPartType.LEGS, BodyPartType.LEGS);
        arena.executeExchange();
        
        assertEquals(18, aragorn.hitPoints());
        assertEquals(15, boromir.hitPoints());
    }
}

