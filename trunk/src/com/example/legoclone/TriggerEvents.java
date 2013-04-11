package com.example.legoclone;

public class TriggerEvents {
	public static boolean ifBetweenValuesFLOAT (	float variable,
													float MIN_VALUE,
													float MAX_VALUE) {
		if (MIN_VALUE > MAX_VALUE) {
			throw new IllegalArgumentException(	"Minimum value can't be higher than " +
												"Max value" );
		}
		
		if (variable >= MIN_VALUE && variable <= MAX_VALUE) {
			return true;
		} else {
			return false;
		}
	}
}
