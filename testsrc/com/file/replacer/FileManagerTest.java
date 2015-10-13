package com.file.replacer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {

	private FileManager fileManager;

	@Before
	public void setUp() {
		fileManager = new FileManager();
	}

	@Test
	public void testCompletFileWithoutExtraContents() throws IOException {

		// GIVEN
		String contentPath = "testsrc/resources/content.txt";

		// Texts to replace
		List<String> textsToReplace = new ArrayList<String>();
		textsToReplace.add("TEXT@NEW TEXT");
		textsToReplace.add("TEST@NEW TEST");

		String expected = "Content to replace is NEW TEXT and NEW TEST";

		// WHEN

		// Completing fle
		fileManager.completeFile(contentPath, textsToReplace);

		// THEN
		final Path path = Paths.get(contentPath);
		final Charset charset = StandardCharsets.UTF_8;

		// Getting new content
		String actual = new String(Files.readAllBytes(path), charset);
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

	@Test
	public void testCompletFileExtraContents() throws IOException {

		// GIVEN
		String contentPath = "testsrc/resources/content.txt";

		// Texts to replace
		List<String> textsToReplace = new ArrayList<String>();
		textsToReplace.add("TEXT@NEW TEXT");
		textsToReplace.add("TEST@NEW TEST");

		String newInfoPath = "testsrc/resources/newinfo.txt";

		String expected = "Content to replace is NEW TEXT and NEW TEST\r\n"
				+ "cronjob.timertask.loadonstartup= false\r\nlang.packs=de,en,es,es_CO,ca,fr,it,ja,ko,pt,ru,zh,zh_TW";

		// WHEN

		// Completing fle
		fileManager.completeFile(contentPath, textsToReplace, newInfoPath);

		// THEN
		final Path path = Paths.get(contentPath);
		final Charset charset = StandardCharsets.UTF_8;

		// Getting new content
		String actual = new String(Files.readAllBytes(path), charset);
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

	@Test
	public void testAddContent() {

		try {
			// GIVEN

			String path = "testsrc/resources/newinfo.txt";

			String content = "Existing content";

			String expected = "Existing content\r\n"
					+ "cronjob.timertask.loadonstartup= false\r\nlang.packs=de,en,es,es_CO,ca,fr,it,ja,ko,pt,ru,zh,zh_TW";

			// WHEN
			String actual = fileManager.addNewContent(path, content);

			// THEN
			assertEquals("Expected content was " + expected + " but was "
					+ actual, expected, actual);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddContentWithoutData() {

		try {
			// GIVEN

			String path = null;

			String content = "Existing content";

			String expected = "";

			// WHEN
			String actual = fileManager.addNewContent(path, content);

			// THEN
			assertEquals("Result must be empty", expected, actual);

			// GIVEN

			path = "testsrc/resources/newinfo.txt";

			content = null;
			// WHEN
			actual = fileManager.addNewContent(path, content);

			// THEN
			assertEquals("Result must be empty", expected, actual);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
