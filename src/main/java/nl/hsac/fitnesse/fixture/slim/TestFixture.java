package nl.hsac.fitnesse.fixture.slim;

import java.io.*;

/**
 * Created by mathijsk on 13-4-2017.
 */
public class TestFixture extends SlimFixture{


    public String getCurrent() {
        final String dir = System.getProperty("user.dir");
        return dir;
    }

    public void getLiCount(String html) {


        // get number of clickable objects from the html and create loops based on levels
        // the end result will be loops within loops
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Automatisering\\Telfort\\text.txt"));
            out.write(html);  //Replace with the string
            //you are trying to write
            out.close();
        } catch (IOException  e){
            System.out.println("Exception ");
        }

    }





}
