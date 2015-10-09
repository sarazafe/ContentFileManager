package com.file.replacer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Replace some text of a file and add new lines if this is specified
 *
 * @author <a href="mailto:sarazafe@gmail.com>Sara Zapico Fernandez (SZF)</a>
 *
 */
public class ContentFileReplacer
{

	ContentFileReplacer()
	{

	}



	/**
	 * Replaces some text and adds new lines of a file
	 *
	 * @param args
	 *           <ul>
	 *           <li>args[0]: local.properties location</li>
	 *           <li>args[1]: text to replace</li>
	 *           <li>args[2]: text to use for replacing</li>
	 *           </ul>
	 */
	public static void main(String[] args)
	{
		//If args's lenth is 3, replace text
		if (args.length == 3)
		{
			try
			{

				System.out.println("STARTING TO REPLACE FILE " + args[0]);

				//Gets file
				final Path path = Paths.get(args[0]);
				final Charset charset = StandardCharsets.UTF_8;

				//Replaces text
				String content = new String(Files.readAllBytes(path), charset);
				if (!content.contains(args[2]))
				{
					content = content.replaceAll(args[1], args[2]);
				}

				//Adds property for setting server faster
				if (!content.contains("cronjob.timertask.loadonstartup= false"))
				{
					content += "\r\ncronjob.timertask.loadonstartup= false";
				}

				//Writes new content
				Files.write(path, content.getBytes(charset));

				System.out.println("END REPLACEMENT OF FILE " + args[0]);
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
