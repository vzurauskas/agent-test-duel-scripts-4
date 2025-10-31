package com.vzurauskas.duelscripts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class ArenaTest {

    @Test
    void fighterStrikesOpponentsHeadUndefendedAndDeals5Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPart.HEAD, BodyPart.HEAD);
        boromir.decideActions(BodyPart.HEAD, BodyPart.LEGS);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(15, boromir.hitPoints());
    }

    @Test
    void fighterStrikesOpponentsTorsoUndefendedAndDeals3Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPart.TORSO, BodyPart.HEAD);
        boromir.decideActions(BodyPart.HEAD, BodyPart.HEAD);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(17, boromir.hitPoints());
    }

    @Test
    void fighterStrikesOpponentsLegsUndefendedAndDeals2Damage() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPart.LEGS, BodyPart.HEAD);
        boromir.decideActions(BodyPart.HEAD, BodyPart.TORSO);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(18, boromir.hitPoints());
    }

    @Test
    void strikeIsDeflectedWhenFighterParriesTheTargetedBodyPart() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPart.HEAD, BodyPart.HEAD);
        boromir.decideActions(BodyPart.HEAD, BodyPart.HEAD);
        arena.executeExchange();
        
        assertEquals(20, aragorn.hitPoints());
        assertEquals(20, boromir.hitPoints());
    }

    @Test
    void bothFightersStrikeEachOtherSuccessfullyInSimultaneousExchange() {
        final Fighter aragorn = new Fighter("Aragorn");
        final Fighter boromir = new Fighter("Boromir");
        final Arena arena = new Arena(aragorn, boromir);
        
        aragorn.decideActions(BodyPart.HEAD, BodyPart.TORSO);
        boromir.decideActions(BodyPart.LEGS, BodyPart.LEGS);
        arena.executeExchange();
        
        assertEquals(18, aragorn.hitPoints());
        assertEquals(15, boromir.hitPoints());
    }
}

