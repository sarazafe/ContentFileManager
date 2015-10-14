# ContentFileManager
It replaces in a file some contents; and, if it is specified, it can add new lines on it

# How to use

There is a .jar file in releases folder; this needs two or three arguments:
1.- The path of the file that will be modified
2.- A collection of pairs text_to_be_replaced1@new_text1,text_to_be_replaced2@new_text2,...
3.- The path of the file with new information to add to origin file (this argument is optional)

## Example
From cms execute this line: java -jar releases/contentfilemanager_1.0.jar example.txt  information@data,change@replace more.txt
