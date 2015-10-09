package com.file.replacer;

import java.util.List;

/**
 * Replace some contents in a file.
 *
 * These contents are defined in a list with the values WORD_TO_REPLACE:NEW_WORD
 *
 * @author <a href="mailto:sarazafe@gmail.com>Sara Zapico Fernandez (SZF)</a>
 *
 */
public class Replacer {

	/**
	 * Separator for each pair textToReplace:NewText
	 */
	private final String SEPARATOR = "@";

	/**
	 * It replaces a content with some new texts
	 *
	 * @param content
	 *            the content to replace
	 * @param textsToReplace
	 *            the list with texts to replace and its new values, the content
	 *            of the list will be a pair of textToReplace@newText
	 * @return replaced content
	 */
	public String replaceContent(String content, List<String> textsToReplace) {

		// Null safe
		if (content == null || textsToReplace == null) {
			return "";
		}

		// Replace all contents
		for (String text : textsToReplace) {

			// If there is a pair of textToReplace - newText, replace
			if (text.split(SEPARATOR).length >= 2) {
				content = replace(content, text.split(SEPARATOR)[0],
						text.split(SEPARATOR)[1]);
			}
		}

		return content;
	}

	/**
	 * It replaces, in a text content, some text with another. If content
	 * already contains the new text, the replacement will not be done
	 *
	 * @param content
	 *            the content which we want to make the replacement
	 * @param textToReplace
	 *            the text to replace
	 * @param newText
	 *            the new text
	 * @return the new content
	 */
	protected String replace(String content, String textToReplace,
			String newText) {

		// Null safe
		if (content == null || textToReplace == null || newText == null) {
			return "";
		}

		// If content does not have new Text, replace it
		if (!content.contains(newText)) {
			content = content.replaceAll(textToReplace, newText);
		}

		return content;
	}

}
