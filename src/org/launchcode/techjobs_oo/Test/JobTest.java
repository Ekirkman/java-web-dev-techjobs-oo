package org.launchcode.techjobs_oo.Test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob;
    Job testJob2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createJobObject(){
        testJob = new Job();
        testJob2 = new Job();
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
}
