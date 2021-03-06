package com.cucumberJunit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreateHtmlDocument {
	public static void main(String[] args)
    {
        try {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html>");
            htmlStringBuilder.append("<head>");
            htmlStringBuilder.append("<meta http-equiv="+"content-language"+"content="+"en-us>");
            htmlStringBuilder.append("<meta http-equiv="+"content-type"+"content="+"text/html; charset=window-1252"+">");
         
           
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),"testfile.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
}
