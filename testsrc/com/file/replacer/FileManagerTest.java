package com.file.replacer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {

	private FileManager fileManager;

	@Before
	public void setUp() {
		fileManager = new FileManager();
	}

	@Test
	public void testAddContent() {

		// GIVEN
		// Gets file
		String path = "testsrc/resources/newinfo.txt";
		// final Path path = Paths.get("testsrc/resources/newinfo.txt");
		// final Charset charset = StandardCharsets.UTF_8;

		// String contentToAdd = new String(Files.readAllBytes(path), charset);

		String content = "Existing content";

		String expected = "Existing content\n"
				+ "cronjob.timertask.loadonstartup= false\nlang.packs=de,en,es,es_CO,ca,fr,it,ja,ko,pt,ru,zh,zh_TW";

		// WHEN
		String actual = fileManager.addNewContent(path, content);

		// THEN
		assertEquals("Expected content was " + expected + " but was " + actual,
				expected, actual);
	}

}
