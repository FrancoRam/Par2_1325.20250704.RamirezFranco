
package ar.edu.utn.fra.prog2.cine.persistencia;

import ar.edu.utn.fra.prog2.cine.modelo.Cine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PersistenciaDatos {
    
    private static final String ARCHIVO_CINE = "cine.ser";
    
    //Serializa en el archivo 'cine.ser' el contenido del obj cine. Debe implementar la ifz serializable
    public static void guardarCine(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CINE))) {
            oos.writeObject(cine);
        }catch (FileNotFoundException fnf){
            System.out.println("Problemas con el archivo: "+ fnf.getMessage());
        }catch (IOException e) {
            System.out.println("ERROR al guardar el archivo: "+ e.getMessage());
        }
    }
    
    public static Cine cargarCine() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CINE))) {
            return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Cine(); // Si no existe, se retorna un cine vacío
        }
    }
}
