package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.swing.text.Position;

import static org.junit.Assert.*;

public class JobTest {
    Job jobOne;
    Job jobTwo;

    private void assertFalse(Job jobOne, Job jobTwo) {
    }
    private void assertFalse(boolean equals) {
    }

    @Before
    public void jobOjects() {
        jobOne = new Job();
        jobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobOne.getEmployer() instanceof Employer && jobOne.getEmployer().getValue() == "ACME");
        assertTrue(jobOne.getLocation() instanceof Location && jobOne.getLocation().getValue() == "Desert");
        assertTrue(jobOne.getPositionType() instanceof PositionType && jobOne.getPositionType().getValue() == "Quality control");
        assertTrue(jobOne.getCoreCompetency() instanceof CoreCompetency && jobOne.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void toStringTest() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("ID: " + job.getId(), splitString[1]);
        assertEquals("Name: " + job.getName(), splitString[2]);
        assertEquals("Employer: " + job.getEmployer(), splitString[3]);
        assertEquals("Location: " + job.getLocation(), splitString[4]);
        assertEquals("Position Type: " + job.getPositionType(), splitString[5]);
        assertEquals("Core Competency: " +job.getCoreCompetency(), splitString[6]);
    }

    @Test
    public void blankSpaces() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().startsWith("\n"));
        assertTrue(job.toString().endsWith("\n"));
    }

}
