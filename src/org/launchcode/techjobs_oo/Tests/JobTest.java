package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job testJob1;
    private Job testJob2;
    private Job testerJob;
    private Job testerJob2;
    private Job testerJob3;
    private Job testerJob4;

    @Before
    public void jobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
        testerJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testerJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testerJob3 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testerJob4 = new Job("", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }
    @Test //tests the empty constructor
    public void testSettingJobID(){
        assertTrue(!testJob1.equals(testJob2));
        assertFalse(testJob1.equals(testJob2));
        assertEquals(testJob1.getId(),testJob2.getId()-1);
        //System.out.println(testJob1.getId());
        //System.out.println(testJob2.getId());
    }

    @Test //test the full constructor
    public void testJobConstructorSetsAllFields(){
    assertEquals(testerJob.getName(),"Product tester");
    assertEquals(testerJob.getEmployer().getValue(),"ACME");
    assertEquals(testerJob.getLocation().getValue(),"Desert");
    assertEquals(testerJob.getPositionType().getValue(),"Quality control");
    assertEquals(testerJob.getCoreCompetency().getValue(),"Persistence");
    }

    @Test //test the equals method
        public void testJobsForEquality(){
        assertFalse(testerJob.equals(testerJob2));
    }

    @Test //returns a blank line before and after the job info
        public void testToString() {
        assertTrue(testerJob.toString().charAt(0) == testerJob.toString().charAt(testerJob.toString().length()-1));
        assertEquals(testerJob.toString(), "\n\n ID: " + testerJob.getId() + "\n Name: Product tester\n Employer: ACME\n Location: Desert\n Position Type: Quality control\n Core Competency: Persistence\n");
        assertEquals(testerJob3.toString(), "\n\n ID: " + testerJob3.getId() + "\n Name: Data not available\n Employer: ACME\n Location: Desert\n Position Type: Quality control\n Core Competency: Persistence\n");
        assertEquals(testerJob4.toString(), "\n\n ID: " + testerJob4.getId() + "\n Name: Data not available\n Employer: Data not available\n Location: Desert\n Position Type: Quality control\n Core Competency: Persistence\n");
    }

}
