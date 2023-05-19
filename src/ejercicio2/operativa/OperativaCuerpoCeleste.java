
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
    
    // ------------- DECLARACIÓN DE VARIABLES ----------------
    
    private static File fichero = new File("sistemasolar.dat") ;
    private static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    
    
    
    // ------------- MÉTODOS ---------------------
    
    /**
     * Método privado que añade cuerpos celestes.
     */
    private static void aniadirCuerpoCeleste(){
        
        short codigoCuerpo ;
        String nombre ;
        String tipoObjeto ;
        int diametro ;
        
        boolean validador ;
        
        
        GestionFicheros.abrir(fichero, cuerposCelestes);
        
        do // Pide y comprueba el código hasta que sea válido
        {
            codigoCuerpo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste (3 dígitos max.):") ;
            validador = OperativaCuerpoCeleste.compruebaCodigo(codigoCuerpo) ;
            
        } while (!validador);
        
        validador = false ;
        
        do // Pide y comprueba el nombre hasta que sea válido
        {
            nombre = Utilidades.leerStringBuffer("\nIntroduce en el nombre del cuerpo celeste (15 caracteres max.):") ;
            validador = OperativaCuerpoCeleste.compruebaNombre(nombre) ;
            
        } while (!validador);
        
        validador = false ;
        
        // Pedimos el tipo de objeto
        
        tipoObjeto = Utilidades.leerStringBuffer("\nIntroduce el tipo de cuerpo celeste:") ;
        
        do // Pide y comprueba el diámetro hasta que sea válido
        { 
            diametro = Utilidades.leerEnteroBuffer("\nIntroduce el diámetro (6 dígitos max.):") ;
            validador = OperativaCuerpoCeleste.compruebaDiametro(diametro) ;
            
        } while (!validador);
        
        /*
            Hemos terminado de pedir los datos y han sido comprobados. Si son 
            válidos continuamos almacenándolos.
        */
        
        if (cuerposCelestes.isEmpty()) // Si el array está vacío...
        {
            cuerposCelestes = new ArrayList<CuerpoCeleste>() ; // ... créalo.
        }
        
        try
        {
            cuerposCelestes.add(new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro)) ;
        }
        catch(ExcepcionCuerpoCeleste e){
            
            System.out.println(e.getMessage());
        }
        
        GestionFicheros.escribirArchivo(fichero, cuerposCelestes) ;
        System.out.println("\nCuerpo Celeste " + cuerposCelestes.size()+ " añadido");
    }
    
    
    /**
     * Método que nos permite visualizar todos los datos almacenador.
     * Primero comprobamos que el fichero exista.
     * Si existe, lo abrimos y comprobamos que no esté vacío recorriendo todo su contenido.
     */
    private static void listarCuerpoCeleste(){
        
        if (!fichero.exists()) 
        {
            System.out.println("\nNO EXISTEN DATOS");
        }
        else
        {
            GestionFicheros.abrir(fichero, cuerposCelestes);
            
            if (cuerposCelestes != null) 
            {
                int contador = 1 ;
                
                for (CuerpoCeleste objeto: cuerposCelestes) 
                {
                    System.out.println("Registro nº " + contador + " - "  + objeto.toString());
                    contador++ ;
                }
            }
            else
            {
                System.out.println("\nNo existen registros de cuerpos celestes.");
            }
        }
    }
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su código.
     */
    private static void buscarCuerpoCelestePorCodigo(){
        
        int contador ;
        boolean encontrado = false ;
        
        do
        {
            short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;
        
            GestionFicheros.abrir(fichero, cuerposCelestes) ;
            
            contador = 1 ;

            for (CuerpoCeleste cuerpoCeleste: cuerposCelestes) 
            {
                if (cuerpoCeleste.getCodigoCuerpo() == codigo) 
                {
                    encontrado = true ;
                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                }
                
                contador++ ;
            }
            
            if (!encontrado) 
            {
                System.out.println("\nREGISTRO NO ENCONTRADO.");
            }
            
        } while (!Utilidades.secuenciaSalida("¿Quieres buscar otro registro?"));
    }
    
    
    /**
     * Método que nos permite buscar un registro concreto buscándolo por su tipo.
     */
    private static void buscarCuerpoCelestePorTipo(){
        
        int contador ;
        boolean encontrado = false ;
        
        do
        {
            String tipo = Utilidades.leerStringBuffer("\nIntroduce el código del cuerpo celeste que deseas buscar: ") ;
        
            GestionFicheros.abrir(fichero, cuerposCelestes) ;
            
            contador = 1 ;

            for (CuerpoCeleste cuerpoCeleste: cuerposCelestes) 
            {
                if (cuerpoCeleste.getTipoObjeto().equalsIgnoreCase(tipo)) 
                {
                    encontrado = true ;
                    System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                }
                
                contador++ ;
            }
            
            if (!encontrado) 
            {
                System.out.println("\nNO EXISTEN CUERPOS CELESTES DE ESE TIPO.");
            }
            
        } while (!Utilidades.secuenciaSalida("¿Quieres buscar otro registro?"));
    }
    
    
    /**
     * Método similar al anterior pero que en lugar de limitarse a mostrarnos el 
     * resultado de la búsqueda, nos permite decidir si deseamos elminar el 
     * registro encontrado.
     */
    private static void eliminarCuerpoCeleste(){ // NO FUNCIONA CORRECTAMENTE, VOY A SEGUIR Y LUEGO LO ATIENDO
        
        /*
        Uno de los errores es que elmina una entrada. Poniendo 1 como código, por ejemplo, 
        ha dado un error pero ha borrado la entrada 1 del fichero. Eso no debería ocurrir porque 
        el código no coincide con 1.
        */
        
        int contador ;
        boolean encontrado ;
        
        try
        {
            do 
            {
                short codigo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste que deseas eliminar: ") ;
        
                GestionFicheros.abrir(fichero, cuerposCelestes) ;

                contador = 1 ;
                
                encontrado = false ;

                for(CuerpoCeleste cuerpoCeleste: cuerposCelestes)
                {
                    if (cuerpoCeleste.getCodigoCuerpo() == codigo)
                    {
                        encontrado = true ;
                        System.out.println("\nRegistro nº" + contador + " - " + cuerpoCeleste.toString());
                        
                        if (!Utilidades.secuenciaSalida("¿Quiere eliminar este registro?")) 
                        {
                            cuerposCelestes.remove((contador - 1)) ;
                            GestionFicheros.escribirArchivo(fichero, cuerposCelestes) ;
                            System.out.printf("\nREGISTRO Nº%d ELIMINADO", contador);
                        }
                    }
                    
                contador++ ;
                }
            
                if (!encontrado) 
                {   
                    System.out.println("\nREGISTRO NO ENCONTRADO.") ;
                }
            
            } while (!Utilidades.secuenciaSalida("\n¿Quieres buscar otro registro?"));
        }
        catch(ConcurrentModificationException e){
            System.err.println("");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Método que nos elimina el fichero de datos del disco.
     */
    private static void eliminarFichero(){
        
        boolean respuesta ;
        boolean borrado ;
        
        try
        {
            respuesta = Utilidades.secuenciaSalida("\n¿Desea eliminar el fichero completo?") ;
            
            if (!respuesta)
            {
                borrado = fichero.delete() ;
                
                if (borrado) 
                {
                    System.out.println("\nFICHERO DE DATOS ELMINADO.");
                    cuerposCelestes.clear();
                }
            }
            else
            {
                System.out.println("\nNO SE HA REALIZADO NINGUNA ACCIÓN.");
            }
        }
        catch (Exception e){
            System.err.println("\nAlgún error ocurrió: " + e.getMessage());
        }
    }
    
    
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
