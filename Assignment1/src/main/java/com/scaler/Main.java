package com.scaler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // create instance of directory
        File dir = new File("/Users/briyadav/IdeaProjects/Assignment1/files");
        File newFile = new File("/Users/briyadav/IdeaProjects/Assignment1/output/output.txt");
        newFile.createNewFile();
        FileWriter myWriter = new FileWriter("/Users/briyadav/IdeaProjects/Assignment1/output/output.txt");

        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();
        List<Integer> list = new ArrayList<Integer>();
        for(String fileName: fileNames){

            File f = new File(dir,fileName);

            BufferedReader br = new BufferedReader(new FileReader(f));

            String line  = br.readLine();

            while(line != null){

                list.add(Integer.parseInt(line));

                line = br.readLine();
            }
        }

        System.out.println(list);
        int[] primitive = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        Main.mergeSort(primitive,0,list.size()-1);
        System.out.println("primitive");
        for (int num:primitive
             ) {
            System.out.println(num);
            myWriter.write(String.valueOf(num));
            myWriter.write("\r\n");
        }
        myWriter.close();

    }


    public static void merge(int Arr[], int start, int mid, int end) {

        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1; i += 1;
            }
            else {
                temp[k] = Arr[j];
                k += 1; j += 1;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

// Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr

    public static void mergeSort(int Arr[], int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }
}