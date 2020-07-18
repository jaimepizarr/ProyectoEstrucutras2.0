/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentesSistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public interface ClassSerializer {
    public default void  guardarObjeto(String source, Object o){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(source,true)){
                protected void writeStreamHeader() throws IOException {
                    reset();
            }
            };
            oos.writeObject(o);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
