package ipl.java.src.test;

import ipl.java.src.Main;
import ipl.java.src.Match;
import ipl.java.src.Delivery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMain {
//    Number of matches played per year of all the years in IPL.
    @Test
    public void numberOfMatchesPlayedPerYearTest() {
        Match match1 = new Match();
        match1.setSeason("2006");

        Match match2 = new Match();
        match2.setSeason("2007");

        Match match3 = new Match();
        match3.setSeason("2007");

        Match match4 = new Match();
        match4.setSeason("2010");

        Match match5 = new Match();
        match5.setSeason("2010");

        List<Match> matches = Arrays.asList(match1, match2, match3, match4, match5);

        HashMap<String, Integer> result = Main.findNumberOfMatchesPlayedPerYear(matches);

        assertEquals(1, (int) result.get("2006"));
        assertEquals(2, (int) result.get("2007"));
        assertEquals(2, (int) result.get("2010"));
        assertNull(result.get("2014"));
    }

//    Number of matches won of all teams over all the years of IPL.
    @Test
    public void numberOfMatchesWonByAllTeamsTest() {
        Match match1 = new Match();
        match1.setSeason("2006");
        match1.setWinner("TeamA");

        Match match2 = new Match();
        match2.setSeason("2007");
        match2.setWinner("TeamB");

        Match match3 = new Match();
        match3.setSeason("2007");
        match3.setWinner("TeamA");

        Match match4 = new Match();
        match4.setSeason("2010");
        match4.setWinner("TeamC");

        Match match5 = new Match();
        match5.setSeason("2010");
        match5.setWinner("TeamB");

        List<Match> matches = Arrays.asList(match1, match2, match3, match4, match5);

        HashMap<String, HashMap<String, Integer>> result = Main.numberOfMatchesWonByAllTeams(matches);


        assertEquals(1, (int) result.get("2006").get("TeamA"));
        assertEquals(1, (int) result.get("2007").get("TeamA"));
        assertEquals(1, (int) result.get("2007").get("TeamB"));
        assertEquals(1, (int) result.get("2010").get("TeamC"));
        assertEquals(1, (int) result.get("2010").get("TeamB"));
        assertNull(result.get("2012"));
    }
//    For the year 2016 get the extra runs conceded per team.
    @Test
    public void extraRunConcedePerTeamTest() {
        Match match1 = new Match();
        match1.setSeason("2016");
        match1.setId("1");

        Match match2 = new Match();
        match2.setSeason("2016");
        match2.setId("2");

        Delivery delivery1 = new Delivery();
        delivery1.setMatch_id("1");
        delivery1.setBowling_team("TeamA");
        delivery1.setExtra_runs("5");

        Delivery delivery2 = new Delivery();
        delivery2.setMatch_id("1");
        delivery2.setBowling_team("TeamB");
        delivery2.setExtra_runs("10");

        Delivery delivery3 = new Delivery();
        delivery3.setMatch_id("2");
        delivery3.setBowling_team("TeamA");
        delivery3.setExtra_runs("7");

        List<Match> matches = Arrays.asList(match1, match2);
        List<Delivery> deliveries = Arrays.asList(delivery1, delivery2, delivery3);

        HashMap<String, Integer> result = Main.ExtraRunConcedePerTeam(matches, deliveries);

        assertEquals(12, (int) result.get("TeamA"));
        assertEquals(10, (int) result.get("TeamB"));
        assertNull(result.get("TeamC"));
    }

//    For the year 2015 get the top economical bowlers.
    @Test
    public void top10EconomicalBowlerTest() {
        Match match1 = new Match();
        match1.setSeason("2015");
        match1.setId("1");

        Match match2 = new Match();
        match2.setSeason("2015");
        match2.setId("2");

        Delivery delivery1 = new Delivery();
        delivery1.setMatch_id("1");
        delivery1.setBowler("BowlerA");
        delivery1.setTotal_runs("4");
        delivery1.setBye_runs("1");
        delivery1.setLegbye_runs("0");
        delivery1.setPenalty_runs("0");
        delivery1.setWide_runs("0");
        delivery1.setNoball_runs("0");

        Delivery delivery2 = new Delivery();
        delivery2.setMatch_id("2");
        delivery2.setBowler("BowlerB");
        delivery2.setTotal_runs("3");
        delivery2.setBye_runs("0");
        delivery2.setLegbye_runs("0");
        delivery2.setPenalty_runs("0");
        delivery2.setWide_runs("0");
        delivery2.setNoball_runs("0");

        List<Match> matches = Arrays.asList(match1, match2);
        List<Delivery> deliveries = Arrays.asList(delivery1, delivery2);

        LinkedHashMap<String,Float> result = Main.Top10EconomicalBowler(matches, deliveries);
        assertEquals(18.0f,result.get("BowlerB"));
        assertNull(result.get("BowlerC"));
    }



//    Find the number of times each team won the toss and also won the match
    @Test
    public void teamWonTossAndMatchTest() {
        Match match1 = new Match();
        match1.setToss_winner("TeamA");
        match1.setWinner("TeamA");

        Match match2 = new Match();
        match2.setToss_winner("TeamB");
        match2.setWinner("TeamB");

        Match match3 = new Match();
        match3.setToss_winner("TeamA");
        match3.setWinner("TeamB");

        Match match4 = new Match();
        match4.setToss_winner("TeamC");
        match4.setWinner("TeamC");

        Match match5 = new Match();
        match5.setToss_winner("TeamD");
        match5.setWinner("TeamD");

        List<Match> matches = Arrays.asList(match1, match2, match3, match4, match5);

        HashMap<String, Integer> result = Main.teamWonTossAndMatch(matches);

        assertEquals(1, (int) result.get("TeamA"));
        assertEquals(1, (int) result.get("TeamB"));
        assertEquals(1, (int) result.get("TeamC"));
        assertEquals(1, (int) result.get("TeamD"));
        assertNull(result.get("TeamE"));
    }


}
