package com.hsbg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

class SomethingDoerMockerTest {

	@Test
	void testSomethingDoer() {
		assertTrue(true);
	}

	@Test
	void testPrint() {
		// ForeignClass foreign = mock(ForeignClass.class);
		SomethingDoer sm = mock(SomethingDoer.class);
		OngoingStubbing<String> s = when(sm.print("Test")).thenReturn("Vilas1");
		// assertEquals(s., "Vilas1");
		System.out.println("##############################################");
		System.out.println(sm.print("Test"));
		System.out.println(sm.print("SomeOtherValue"));
		System.out.println("##############################################");
		assertEquals(sm.print("Test"), "Vilas1");
	}

	@Test
	void testAdd() {
		assertTrue(true);
	}

}
