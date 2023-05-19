
package ejercicio2.excepciones;

/**
 * Excepción personalizada para la clase CuerpoCeleste.
 * 
 * @author Adrián Arjona
 * @version 2.0 Mayo 2023
 */
public class ExcepcionCuerpoCeleste extends Exception{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 9: comunicándonos con el usuario. Interfaces.
    */
    
   /**
    * Excepción para los cuerspos celestes.
    * 
    * @param msj Mensaje al usuario.
    */
    public ExcepcionCuerpoCeleste (String msj){
        
        super(msj) ;
    }
}
