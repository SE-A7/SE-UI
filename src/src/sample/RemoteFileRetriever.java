package sample;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFileRetriever {

    private static final String ENCODING = "UTF-8";

    /**
     * Retrieves a file from the specified url.
     * @param url The place on the web where the file is located.
     * @return A string with the contents of the file.
     */
    public static String getFile(String url) {
        URL xwikiDoc = null;
        try {
            xwikiDoc = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(xwikiDoc.openStream(), writer, ENCODING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String urlContents = writer.toString();

        return urlContents;
    }
}
