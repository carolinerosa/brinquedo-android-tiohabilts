package com.example.legoclone;

public class TriggerEvents {
	public static boolean ifBetweenValuesFLOAT (	float variable,
													float MIN_VALUE,
													float MAX_VALUE) {
		if (variable >= MIN_VALUE && variable <= MAX_VALUE) {
			return true;
		} else {
			return false;
		}
	}
}
