package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    static Job testJob;
    static Job testJob2;
    Job testJob3;
    Job testJob4;

    @BeforeClass
    public static void createFirstJobObjects(){
        testJob = new Job();
        testJob2 = new Job();
    }
    @Before
    public void createJobObject(){
        testJob3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        testJob4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){

        assertEquals(1,testJob.getId());
        assertEquals(2,testJob2.getId());
    }
    @Test
    public void  testJobConstructorSetsAllFields(){
       assertEquals("Product tester",testJob3.getName());
       assertEquals("ACME",testJob3.getEmployer().toString());
       assertEquals("Desert",testJob3.getLocation().toString());
       assertEquals("Quality control", testJob3.getPositionType().toString());
       assertEquals("Persistence",testJob3.getCoreCompetency().toString());
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(testJob3.equals(testJob4));
    }
    @Test
    public void testBlankLinesInToString(){
        assertEquals(testJob3.toString(),"\n"+testJob3.toString().trim()+"\n");
    }
    @Test
    public void testJobToStringFormat(){
        assertEquals("\nID: "+testJob3.getId()+
                "\nName: "+testJob3.getName()+
                "\nEmployer: "+testJob3.getEmployer()+
                "\nLocation: "+testJob3.getLocation()+
                "\nPosition Type: "+testJob3.getPositionType()+
                "\nCore Competency: "+testJob3.getCoreCompetency()+
                "\n",testJob3.toString());
    }
    @Test
    public void testJobToStringEmptyField(){
        Job testNoData = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));
        assertEquals("\nID: "+testNoData.getId()+
                "\nName: "+"Data not available"+
                "\nEmployer: "+"Data not available"+
                "\nLocation: "+"Data not available"+
                "\nPosition Type: "+"Data not available"+
                "\nCore Competency: "+"Data not available"+
                "\n",testNoData.toString());
    }

}
