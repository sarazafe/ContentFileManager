package com.file.replacer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class manages files information
 *
 * @author <a href="mailto:sarazafe@gmail.com>Sara Zapico Fernandez (SZF)</a>
 *
 */
public class FileManager {

	/**
	 * The replacer of contents
	 */
	Replacer replacer;

	FileManager() {
		replacer = new Replacer();
	}

	/**
	 * It completes a file, replacing texts with new values
	 *
	 * @param contentPath
	 *            the path of the file to complete
	 * @param textsToReplace
	 *            the pairs of text@newText
	 * @throws IOException
	 */
	public void completeFile(String contentPath, List<String> textsToReplace)
			throws IOException {
		completeFile(contentPath, textsToReplace, null);
	}

	/**
	 * It completes a file, replacing texts with new values and adding new data
	 * that will be in newInfoPath file
	 *
	 * @param contentPath
	 *            the path of the file to complete
	 * @param textsToReplace
	 *            the pairs of text@newText
	 * @param newInfoPath
	 *            the path of the file with new information to add to content
	 * @throws IOException
	 */
	public void completeFile(String contentPath, List<String> textsToReplace,
			String newInfoPath) throws IOException {

		if (contentPath == null) {
			return;
		}

		// Getting the content of the file
		String content = readContent(contentPath);

		// If there is data, complete it
		if (!content.isEmpty()) {

			// Replacing texts
			if (textsToReplace != null && !textsToReplace.isEmpty()) {
				content = replacer.replaceContent(content, textsToReplace);
			}

			// Adding new data
			if (newInfoPath != null && !newInfoPath.isEmpty()) {
				content = addNewContent(newInfoPath, content);
			}
		}

		// Writing new content on file
		writeContent(contentPath, content);
	}

	/**
	 * It adds to content all data of file in pathFileWithNewData
	 *
	 * @param newDataFilePath
	 *            the path of the file with data to add
	 * @param content
	 *            content to add more information on it
	 * @return the complet content
	 * @throws IOException
	 */
	String addNewContent(String newDataFilePath, String content)
			throws IOException {
		if (newDataFilePath == null || content == null) {
			return "";
		}

		// Getting new content
		String contentToAdd = readContent(newDataFilePath);

		// Adding new content to content
		content += "\r\n" + contentToAdd;

		return content;
	}

	/**
	 * It reads the content of a file
	 *
	 * @param path
	 *            the path of the file to read
	 * @return the read content
	 * @throws IOException
	 */
	private String readContent(String path) throws IOException {
		if (path == null) {
			return "";
		}

		final Path contentPath = Paths.get(path);

		// Getting content
		return new String(Files.readAllBytes(contentPath),
				StandardCharsets.UTF_8);
	}

	/**
	 * It writes some content on a file
	 *
	 * @param path
	 *            the path of the file
	 * @param content
	 *            the content to write
	 * @throws IOException
	 */
	private void writeContent(String path, String content) throws IOException {

		if (path == null || content == null) {
			return;
		}

		final Path contentPath = Paths.get(path);

		// Writing content
		Files.write(contentPath, content.getBytes(StandardCharsets.UTF_8));
	}

}
