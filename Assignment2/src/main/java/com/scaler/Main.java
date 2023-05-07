package com.scaler;

import com.scaler.Album.AlbumClient;
import com.scaler.rest.Photo;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        AlbumClient client = new AlbumClient();

        var response = client.getApi().getPhotos().execute();
        List<Photo> list  = response.body();
        HashMap<Integer, List<Photo>> hashMap = new HashMap<>();
        File directory = new File("/Users/briyadav/Desktop/Java/Assignment2/albums/");
        if (! directory.exists()){
            directory.mkdir();
            System.out.println("creating album dir");
        }

        // group by album id
        for(int i = 0;i<list.size();i++){

            if(hashMap.containsKey(list.get(i).getAlbumId())){
                List<Photo> l = hashMap.get(list.get(i).getAlbumId());
                l.add(list.get(i));
            }else{
                List<Photo> l = new ArrayList<Photo>();
                l.add(list.get(i));
                hashMap.put(list.get(i).getAlbumId(),l);
            }
        }
        for(int i = 1;i<=10;i++){
            List<Photo> p = hashMap.get(i);
            File childDirectory = new File("/Users/briyadav/Desktop/Java/Assignment2/albums/"+p.get(i).getAlbumId());
            if (! childDirectory.exists()){
                childDirectory.mkdir();
            }
            for(File file: childDirectory.listFiles())
                if (!file.isDirectory())
                    file.delete();
            Main.downloadPhoto(p);

        }
        List<Photo> p = hashMap.get(1);
//        System.out.println(p.get(0).getAlbumId());

    }

    public static void downloadPhoto(List<Photo> photoList) throws IOException, URISyntaxException {
        for(int i = 0;i<2;i++){
            Photo p = photoList.get(i);

            URL url = new URL(p.getUrl());
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();



            URI uri = new URI(p.getUrl());
            String[] segments = uri.getPath().split("/");
            String fileName = segments[segments.length-1];




            FileOutputStream fos = new FileOutputStream("/Users/briyadav/Desktop/Java/Assignment2/albums/"+p.getAlbumId()+"/"+fileName+".jpg");
            fos.write(response);
            fos.close();
        }
    }



}