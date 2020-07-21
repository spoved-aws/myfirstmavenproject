package com.practiceTestClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base_Practice;
import com.utilitiesPractice.Listener_CheckingStaticVariables;

@Listeners(Listener_CheckingStaticVariables.class)
public class CheckingStaticVariables extends Base_Practice {

	@BeforeMethod
	public void setUp() {

		initialization();
	}


	@Test
	public void changeTheValueOf_i() {

		/*System.out.println("The value of i before changing : " +i);
		System.out.println("***************************************");
		i=30;
		System.out.println("The value of i after changing : " +i);
		System.out.println("***************************************");
		*/

	}





}
