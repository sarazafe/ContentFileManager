package com.file.replacer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Replace some text of a file and add new lines if this is specified
 *
 * @author <a href="mailto:sarazafe@gmail.com>Sara Zapico Fernandez (SZF)</a>
 *
 */
public class ContentFileCompletor {

	FileManager fileManager;

	ContentFileCompletor() {
		fileManager = new FileManager();
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
	void completeFile(String contentPath, List<String> textsToReplace,
			String newInfoPath) throws IOException {
		fileManager.completeFile(contentPath, textsToReplace, newInfoPath);
	}

	/**
	 * It completes a file, replacing texts with new values and adding new data
	 * that will be in newInfoPath file
	 *
	 * @param contentPath
	 *            the path of the file to complete
	 * @param textsToReplace
	 *            the pairs of text@newText
	 * @throws IOException
	 */
	void completeFile(String contentPath, List<String> textsToReplace)
			throws IOException {
		fileManager.completeFile(contentPath, textsToReplace, null);
	}

	/**
	 * Replaces some text and adds new lines of a file
	 *
	 * @param args
	 *            <ul>
	 *            <li>args[0]: path of file location</li>
	 *            <li>args[1]: texts to replace with new values</li>
	 *            <li>args[2]: path of file with some new information to add</li>
	 *            </ul>
	 */
	public static void main(String[] args) {
		// If args's length is 2 or more, replace text and add new lines
		if (args.length >= 2) {
			try {

				System.out.println("STARTING TO REPLACE FILE " + args[0]);

				ContentFileCompletor cFC = new ContentFileCompletor();

				List<String> textsToReplace = new ArrayList<String>();
				String[] texts = args[1].split(",");
				for (String text : texts) {
					textsToReplace.add(text);
				}

				if (args.length == 2) {
					cFC.completeFile(args[0], textsToReplace);
				} else if (args.length == 3) {
					cFC.completeFile(args[0], textsToReplace, args[2]);
				}

				System.out.println("END REPLACEMENT OF FILE " + args[0]);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}
}
