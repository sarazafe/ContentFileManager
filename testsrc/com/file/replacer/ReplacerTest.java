package com.file.replacer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class of {@code Replacer}
 *
 * @author <a href="mailto:sarazafe@gmail.com>Sara Zapico Fernandez (SZF)</a>
 *
 */
public class ReplacerTest {

	Replacer replacer;

	@Before
	public void setUp() {
		replacer = new Replacer();
	}

	@Test
	public void testReplaceContent() {

		// GIVEN

		// Content
		String content = "Content to replace is TEXT and TEST";

		// Texts to replace
		List<String> textsToReplace = new ArrayList<String>();
		textsToReplace.add("TEXT@NEW TEXT");
		textsToReplace.add("TEST@NEW TEST");

		// Expected content
		String expected = "Content to replace is NEW TEXT and NEW TEST";

		// WHEN
		String actual = replacer.replaceContent(content, textsToReplace);

		// THEN
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);

		// Content
		content = "Content to replace is TEXT and TEST";

		// Texts to replace
		textsToReplace = new ArrayList<String>();
		textsToReplace.add("TEXT.NEW TEXT");
		textsToReplace.add("TEST@NEW TEST");

		// Expected content
		expected = "Content to replace is TEXT and NEW TEST";

		// WHEN
		actual = replacer.replaceContent(content, textsToReplace);

		// THEN
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

	@Test
	public void testReplaceContentWithoutSomeData() {

		// GIVEN

		// Content
		String content = null;

		// Texts to replace
		List<String> textsToReplace = new ArrayList<String>();
		textsToReplace.add("TEXT@NEW TEXT");
		textsToReplace.add("TEST@NEW TEST");

		// Expected content
		String expected = "";

		// WHEN
		String actual = replacer.replaceContent(content, textsToReplace);

		// THEN
		assertEquals("Expected empty" + actual, expected, actual);

		// Content
		content = "Content to replace is TEXT and TEST";

		// Texts to replace
		textsToReplace = null;

		// Expected content
		expected = "";

		// WHEN
		actual = replacer.replaceContent(content, textsToReplace);

		// THEN
		assertEquals("Expected empty", expected, actual);
	}

	@Test
	public void testReplaceText() {

		// GIVEN

		// Content
		String content = "Content to replace is TEXT";

		// Text to replace
		String textToReplace = "TEXT";

		// New text
		String newText = "NEW TEXT";

		// Expected content
		String expected = "Content to replace is NEW TEXT";

		// WHEN
		String actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

	@Test
	public void testReplaceTextWithContainsTextToReplace() {

		// GIVEN

		// Content
		String content = "Content to replace is REPLACED";

		// Text to replace
		String textToReplace = "REPLACED";

		// New text
		String newText = "REPLACED";

		// Expected content
		String expected = "Content to replace is REPLACED";

		// WHEN
		String actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

	@Test
	public void testReplaceTextWithoutContentTextToReplaceOrNewText() {

		// GIVEN

		// Content
		String content = null;

		// Text to replace
		String textToReplace = "TEXT";

		// New text
		String newText = "NEW TEXT";

		// Expected content
		String expected = "";

		// WHEN
		String actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected empty", expected, actual);

		// GIVEN
		// Content
		content = "Content to replace is TEXT";

		// Text to replace
		textToReplace = null;

		// New text
		newText = "NEW TEXT";

		// Expected content
		expected = "";

		// WHEN
		actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected empty", expected, actual);

		// GIVEN
		// Content
		content = "Content to replace is TEXT";

		// Text to replace
		textToReplace = "TEXT";

		// New text
		newText = null;

		// Expected content
		expected = "";

		// WHEN
		actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected empty", expected, actual);

		// GIVEN
		// Content
		content = "";

		// Text to replace
		textToReplace = "";

		// New text
		newText = "";

		// Expected content
		expected = "";

		// WHEN
		actual = replacer.replace(content, textToReplace, newText);

		// THEN
		assertEquals("Expected empty", expected, actual);
	}

}
