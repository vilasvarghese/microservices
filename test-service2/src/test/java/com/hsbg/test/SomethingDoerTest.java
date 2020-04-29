package com.hsbg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomethingDoerTest {

	@Test
	void testDo() {
		assertTrue(true);
	}

	@Test
	public void testAdd() {
		ForeignClass foreign = new ForeignClass();
		foreign.setId("1");
		foreign.setName("Vilas");
		SomethingDoer sm = new SomethingDoer(foreign);
		assertEquals(sm.print("Test"), "Test1");
	}
	
	@Test
	public void testAdd1() {
		ForeignClass foreign = new ForeignClass();
		foreign.setId("1");
		foreign.setName("Vilas");
		SomethingDoer sm = new SomethingDoer(foreign);
		assertEquals(sm.print("Test"), "Test2");
	}
}
