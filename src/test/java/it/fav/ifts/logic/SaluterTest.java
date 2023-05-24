package it.fav.ifts.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SaluterTest {

	@Test
	void testEmpty() {
		Saluter saluter = new Saluter();
		assertEquals("Hello !", saluter.salute(""));
	}

	@Test
	void testName() {
		Saluter saluter = new Saluter();
		assertEquals("Hello FooBar!", saluter.salute("FooBar"));
	}
}
