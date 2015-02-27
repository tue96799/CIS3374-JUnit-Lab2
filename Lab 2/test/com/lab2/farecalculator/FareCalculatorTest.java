package com.lab2.farecalculator;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.lab2.transit.FareCalculator;

import java.util.Collection;
import java.util.Arrays;


@RunWith(Parameterized.class)
public class FareCalculatorTest {
	
	private static final double DELTA = 1e-15;

	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	
	public FareCalculatorTest(double expected, int age, String time, boolean isHoliday) {
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}
	
	@Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][] {
				{0.0, 4, "6:00", false},
				{0.0, 5, "6:00", false},
				{2.5, 6, "6:00", false},
				{2.5, 64, "6:00", false},
				{0.0, 65, "6:00", false},
				{0.0, 66, "6:00", false},
				{0.0, 69, "6:59", false},
				{2.5, 70, "7:00", false},
				{2.5, 71, "7:01", false},
				{2.5, 72, "8:59", false},
				{2.5, 73, "9:00", false},
				{0.0, 74, "9:01", false},
				{0.0, 75, "6:59", true},
				{0.0, 4, "7:00", true},
				{0.0, 3, "7:01", true},
				{0.0, 78, "8:59", true},
				{0.0, 79, "9:00", true},
				{0.0, 80, "9:01", true},
		});
		
	}
	
	@Test
	public void calculateFare() {
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}
	
}
