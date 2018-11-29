package no.stelar7.api.l4j8.tests.league;

import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.basic.constants.types.*;
import no.stelar7.api.l4j8.impl.*;
import no.stelar7.api.l4j8.impl.builders.league.LeagueBuilder;
import no.stelar7.api.l4j8.impl.builders.spectator.SpectatorBuilder;
import no.stelar7.api.l4j8.impl.builders.summoner.SummonerBuilder;
import no.stelar7.api.l4j8.pojo.league.*;
import no.stelar7.api.l4j8.pojo.summoner.Summoner;
import no.stelar7.api.l4j8.tests.SecretFile;
import org.junit.*;

import java.util.*;

public class LeagueTest
{
    final L4J8 l4j8 = new L4J8(SecretFile.CREDS);
    LeagueBuilder lb = new LeagueBuilder().withPlatform(Platform.EUW1);
    
    @Test
    public void testMasterLeague()
    {
        LeagueList data = lb.withQueue(GameQueueType.RANKED_SOLO_5X5).getMasterLeague();
        assert data != null;
    }
    
    @Test
    public void testChallengerLeague()
    {
        LeagueList data = lb.withQueue(GameQueueType.RANKED_FLEX_SR).getChallengerLeague();
        assert data != null;
    }
    
    
    @Test
    public void testLeagueEntry()
    {
        String               id   = new SpectatorBuilder().withPlatform(Platform.EUW1).getFeaturedGames().get(0).getParticipants().get(0).getSummonerName();
        Summoner             s    = new SummonerBuilder().withPlatform(Platform.EUW1).withName(id).get();
        List<LeaguePosition> data = lb.withSummonerId(s.getSummonerId()).getLeaguePosition();
        assert data != null;
    }
    
}
