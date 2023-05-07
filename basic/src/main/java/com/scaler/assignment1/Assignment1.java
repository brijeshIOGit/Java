package com.scaler.assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Assignment1 {

    public static void main(String[] args) throws IOException {
        // create instance of directory
        File dir = new File("../../../files");

        HashMap hm = new HashMap();


        // create object of PrintWriter for output file
        PrintWriter pw = new PrintWriter("../../../files/output.txt");

        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();

        for(String fileName: fileNames){
            List<Integer> list = new ArrayList<Integer>();
            System.out.println("Reading from: "+fileName);
            File f = new File(dir,fileName);

            BufferedReader br = new BufferedReader(new FileReader(f));

            String line  = br.readLine();

            while(line != null){
                System.out.println(line);

                line = br.readLine();
            }
        }

    }
}
