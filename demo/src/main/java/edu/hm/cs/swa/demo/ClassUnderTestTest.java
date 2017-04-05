package edu.hm.cs.swa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClassUnderTestTest {

	@Test
	public void test() {
		assertEquals(6, new ClassUnderTest().calculateValue());
	}

	@Test
	public void test2() {
		assertEquals(5, new ClassUnderTest().calculateValue());
	}



}
