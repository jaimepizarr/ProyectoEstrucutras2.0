/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import TDA.CircularLinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author soyjosephavila
 */
public class MediaView {

  
   
   
    
    
    
    
    
    public static CircularLinkedList readFileOfVideo( ) {
        CircularLinkedList<String> videosList= new CircularLinkedList<>();
        String fileVideo="./videos.txt";
    
        File fp = new File(fileVideo);
        try {
        Scanner sc = new Scanner(fp); 
        while (sc.hasNextLine()) {
            System.out.println("Reading........");
            String line = sc.nextLine();
           videosList.addLast(line);}sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
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
    
    
    
}

