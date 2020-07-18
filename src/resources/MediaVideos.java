/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import TDA.CircularLinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soyjosephavila
 */
public class MediaVideos {

  
   
   
    
    
    
    
    
    public static CircularLinkedList readFileOfVideo( )  {
         CircularLinkedList<String> videosList= new CircularLinkedList<>();
        try {
           
            Scanner sc =new Scanner(new File("videos.txt"));
            while (sc.hasNextLine()) {
                
                String line = sc.nextLine();
                
                videosList.addLast("/resources/videos/"+line);}
            sc.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MediaVideos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videosList;
    }  
     public static void addVideo(String nombreFichero,String linea){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreFichero,true);
            pw = new PrintWriter(fichero);        
            pw.println(linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        CircularLinkedList<String> urls=readFileOfVideo();
        //Iterator<String> data = urls.iterator();
        //addVideo("videos.txt", "video1.mp4");
        //addVideo("videos.txt", "video2.mp4");
        //addVideo("videos.txt", "video3.mp4");
        
            
    }
   
}

