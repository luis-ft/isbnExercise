package com.exercise.isbn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.isbn.models.Isbn;

@SpringBootTest
class IsbnApplicationTests {

	
	@Test
	void isbn10Test() {
		assertEquals("Isbn is valid", Isbn.validateIsbn10("0-19-852663-6"));
		assertEquals("Isbn is blank", Isbn.validateIsbn10(""));
		assertEquals("Isbn is null", Isbn.validateIsbn10(null));
		assertEquals("Isbn is invalid length", Isbn.validateIsbn10("0-19-852663-677777"));
		assertEquals("Isbn is invalid length", Isbn.validateIsbn10("77777"));
		assertEquals("Isbn is invalid", Isbn.validateIsbn10("0-19-852663-X"));
		assertEquals("Isbn is not numeric", Isbn.validateIsbn10("TESTTESTTE"));
		//assertEquals("valid", isbn.validateIsbn10("0-19-852663-677777")); /* bad assertion to make sure the other assertions are working. It failed. As expected.*/
	}

	@Test
	void isbn13Test() {
		assertEquals("Isbn is valid", Isbn.validateIsbn13("9781861972712"));
		assertEquals("Isbn is not numeric", Isbn.validateIsbn13("AAAAAAAAAAAAA"));
	}	

	@Test
	void isbnTest() {
		assertEquals("Isbn is valid", Isbn.validateIsbn("0-19-852663-6"));
		assertEquals("Isbn is blank", Isbn.validateIsbn(""));
		assertEquals("Isbn is null", Isbn.validateIsbn(null));
		assertEquals("Isbn is invalid length", Isbn.validateIsbn("0-19-852663-677777"));
		assertEquals("Isbn is invalid length", Isbn.validateIsbn("77777"));
		assertEquals("Isbn is invalid", Isbn.validateIsbn("0-19-852663-X"));
		assertEquals("Isbn is not numeric", Isbn.validateIsbn("TESTTESTTE"));

		assertEquals("Isbn is valid", Isbn.validateIsbn("9781861972712"));
		assertEquals("Isbn is not numeric", Isbn.validateIsbn("AAAAAAAAAAAAA"));	
	}

}
