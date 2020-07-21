package com.testclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base_Practice;

public class PracticeTestClass extends Base_Practice {
	
	public PracticeTestClass() {
		super();
		System.out.println("Im in the child constructor");
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		
	}
	
	@Test
	public void testMethod() {
		
	}

}
