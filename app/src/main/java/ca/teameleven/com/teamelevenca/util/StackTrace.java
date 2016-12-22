package ca.teameleven.com.teamelevenca.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ahmedraaj on 22/12/16.
 */
public class StackTrace {
    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}
