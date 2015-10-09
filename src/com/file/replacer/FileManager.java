package com.file.replacer;

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
	 * It adds to content all data of file in pathFileWithNewData
	 *
	 * @param pathFileWithNewData
	 *            the path of the file with data to add
	 * @param content
	 *            content to add more information on it
	 * @return the complet content
	 */
	String addNewContent(String pathFileWithNewData, String content) {
		if (pathFileWithNewData == null || content == null) {
			return "";
		}

		return "";
	}

}
