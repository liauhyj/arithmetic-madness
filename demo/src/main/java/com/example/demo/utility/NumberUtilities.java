package com.example.demo.utility;

import java.util.Random;

public class NumberUtilities 
{
	// generates a random number from floor (inclusive) to ceiling (exclusive)
	public static int getRandomNumber(int floor, int ceiling)
	{
		return new Random().nextInt((ceiling - floor) + floor);
	}
}
