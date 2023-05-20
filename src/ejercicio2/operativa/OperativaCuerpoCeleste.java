
package ejercicio2.operativa;

import ejercicio2.excepciones.ExcepcionCuerpoCeleste;
import ejercicio2.gestionficheros.GestionFicheros;
import ejercicio2.modelo.CuerpoCeleste;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import utilidades.Utilidades;

/**
 * Clase que reúne los métodos responsables de la gestión de registros de 
 * cuerpos celestes.
 * 
 * @author Adrián Arjona
 * @version Mayo 2023
 */
public class OperativaCuerpoCeleste {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 9: comunicándonos con el usuario. Interfaces.
    */
    
      // ------------------ COMPROBADORES / VALIDAODRES ----------------------
    
     /**
     * Método que comprueba si el código del cuerpo celeste tiene 3 dígitos.
     * 
     * @param codigo Código del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaCodigo(short codigo){
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el nombre del cuerpo celeste tiene como máximo 15 caracteres.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaNombre(String nombre){
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    
    /**
     * Método que comprueba si el diámetro tiene 6 dígitos como máximo.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * @return Devuelve true si es válido, false si no.
     */
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
}
