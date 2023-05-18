
package interfaz;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.* ;
import javax.swing.border.LineBorder;

/**
 * Clase que reúne los elementos para diseñar la interfaz gráfica de una 
 * calculadora.
 * 
 * @author Adrián Arjona
 * @version Mayo 2023
 */
public class MarcoPrincipal extends JFrame{
    
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 9: comunicándonos con el usuario. Interfaces.
    */
    
    
    // ---------------- DECLARACIÓN DE VARIABLES ------------------
    
    
    // Display para mostrar los números
    
    JLabel marcoSecundario ;
    
    // Cantidad de botones de la calculadora
    
    int numBotones = 17 ;
    
    // Array de botones para números y operaciones
    
    JButton botones[] = new JButton[numBotones] ;
    
    // Array de strings para las etiquetas de los botones
    
    String textoBotones[]  = {"=", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", ".", "+"} ;
    
    // Array de posiciones en X de cada botón
    
    int xBotones[] = {15, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210} ;
    
    // Array de posiciones en Y de cada botón
    
    int yBotones[] = {90, 155, 155, 155, 155, 220, 220, 220, 220, 285, 285, 285, 285, 350, 350, 350, 350} ;
    
    // Array de índices del array de botones que corresponden a número ( en el orden en el que pintarán)
    
    int numerosBotones[] = {14, 9 , 10, 11, 5, 6, 7, 1, 2, 3} ;
    
    // Array de índices del array de botones que corresponden a operaciones ( en el orden en el que se pintarán)
    
    int[] operacionesBotones = {16, 12, 8, 4} ;
    
    // Alto y ancho de cada botón
    
    int anchoBoton = 50 ;
    int altoBoton = 50 ;
    
    // Para indicar que he terminado de escribir dígitos un número y que voy a añadir el siguiente
    
    boolean nuevoNumero = true ;
    
    // Para indicar si ya he utilizado el punto decimal en ese número (sólo puede haber uno)
    
    boolean puntoDecimal = false ;
    
    // Para almacnar los resultados parciales y totales de las operaciones realizadas
    
    double operando1 = 0 ;
    double operando2 = 0 ;
    
    double resultado = 0 ;
    
    // Para almacenar el string de la operación realizada (+, -, *, /)
    
    String operacion = "" ;
    
    
    // ------------ MÉTODOS -------------------
    
        // ------- CONSTRUCTOR ------

        /**
         * Constructor de la clase MarcoPrincipal
         */
        public MarcoPrincipal(){

            initDisplay() ; // Display de la calculadora
            initBotones(); // Botones de la calculadora
            initPantalla() ; // Opciones del JFrame
            eventosNumeros() ; // Eventos asociados a los botones de núemros de la calculadora
            eventoDecimal() ;// Eventos asociados al botón decimal "." de la calculadora
            eventosOperaciones() ; // Eventos asociados a los botones de operaciones (+, -, *, /) de la calculadora
            eventoResultado() ; // Eventos asociados al botón resultado de la calculadora
            eventoLimpiar() ; // Eventos asociados al botón de limpiar "C" de la calculadora
        }
        
        
        /**
         * Método privado que sirve para iniciar el marco secundadio (JLabel).
         */
        private void initDisplay(){
            
            marcoSecundario = new JLabel("0") ; // Inicio JLabel
            marcoSecundario.setBounds(15, 15, 245, 60) ; // Posición y dimensiones
            marcoSecundario.setOpaque(true) ; // Para poder darle un color de fondo
            marcoSecundario.setBackground(Color.BLACK) ; // Color de fondo
            marcoSecundario.setForeground(Color.GREEN) ; // Color de fuente
            marcoSecundario.setBorder(new LineBorder(Color.DARK_GRAY)) ; // Borde
            marcoSecundario.setFont(new Font("MONOSPACED", PLAIN, 24)) ; // Fuente
            marcoSecundario.setHorizontalAlignment(SwingConstants.RIGHT) ; // Alineamiento horizontal derecha
            add(marcoSecundario) ; // Añado el JLabel al JFrame
        }
        
        
        /**
         * Método privado que inicializa los botones de la interfaz y los añade 
         * al JFrame.
         */
        private void initBotones(){
            
            for (int i = 0; i < numBotones; i++) {
                
                botones[i] = new JButton(textoBotones[i]) ; // Inicializo JButton
                int size = (i == 0) ? 30 : 26 ; // El botón de Resultado tendrá un tamaño de fuente menor que todos los demás
                int ancho = (i == 0) ? 245 : anchoBoton ;  // El botón de Resultado será más ancho que todos los demás
                
                botones[i].setBounds(xBotones[i], yBotones[i], ancho, altoBoton) ; // Posición y dimensiones
                botones[i].setFont(new Font("MONOSPACED", PLAIN, size)) ; // Fuente
                botones[i].setOpaque(true) ; // Para poder darle un color de fondo
                botones[i].setFocusPainted(false) ; // Para que no salga un recuadro azul cuando tenga el foco
                botones[i].setBackground(Color.ORANGE) ; // Color de fondo
                botones[i].setForeground(Color.BLACK) ; // Color de fuente
                botones[i].setBorder(new LineBorder(Color.DARK_GRAY)) ; // Borde
                
                add(botones[i]) ; // Añado el JButton al JFrame
            }
        }
        
        
        /**
         * Método privado que da formato al JFrame
         */
        private void initPantalla(){
            
            setLayout(null) ; // Layout absoluto
            setTitle("Calculadora") ; // Título del JFrame
            setSize(290, 455) ; // Dimensiones del JFrame
            setResizable(false) ; // No redimensionable
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; // Cerrar proceso al cerrar ventana
            getContentPane().setBackground(Color.BLACK) ; // Color de fondo
            setVisible(true) ; // Mostrar JFrame
        }
        
        
        /**
         * Método privado que recoge los eventos para la pulsación de los 
         * botones numéricos de la calculadora.
         */
        private void eventosNumeros(){
            
            for (int i = 0; i < 10; i++) {
                
                int numBoton = numerosBotones[i] ;
                botones[numBoton].addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e){
                        // Si es un nuevo número y no es 0, sustituyo el valor del display
                        
                        if (nuevoNumero && operacion.equals("")) {
                            
                            if (!textoBotones[numBoton].equals("0")) {
                                
                            marcoSecundario.setText(textoBotones[numBoton]) ;
                            nuevoNumero = false ; // Ya no es un nuevo número
                            }
                            
                        }
                        else if (nuevoNumero && !(operacion.equals(""))){
                            marcoSecundario.setText(textoBotones[numBoton]) ;
                            nuevoNumero = false ; // Ya no es un nuevo número
                            
                        }
                        else{
                            // Si no, lo añado a los dígitos que ya hubiera
                            
                            marcoSecundario.setText(marcoSecundario.getText() + textoBotones[numBoton]) ;
                        }
                    }
                    
                }) ; // Cierra el ActionListener()
            }
        }
        
        
        
        /**
         * Método privado que añade funcionalidad al botón "." de la calculadora.
         */
        private void eventoDecimal(){
            
            botones[15].addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e){
                    // Si todavía no he añadido el punto decimal al número actual
                    
                    if (!puntoDecimal) {
                        
                        marcoSecundario.setText(marcoSecundario.getText() + textoBotones[15]) ;
                        puntoDecimal = true ; // Ya no puedo añadir el punto decimal en este número
                        nuevoNumero = false ; // Por si empiezo el número con punto decimal ( por ejemplo, .537)
                    }
                    
                } // Cierra actionPerformed()
                
            }); // Cierra ActionListener()
        }
        
        
         
        /**
         * Método privado que añade la función de calcular operaciones a la 
         * calculadora.
         */
        private void eventosOperaciones(){
            
            for (int numBoton : operacionesBotones) { 
                
                botones[numBoton].addActionListener(new ActionListener(){
                    
                    @Override
                    public void actionPerformed(ActionEvent e){
                                                
                        if (operacion.equals("")) {
                            // Si no tenía ninguna operación pendiente de realizar
                            
                            operacion = textoBotones[numBoton] ; // Asocio la operación del botón a la variable
                            
                            operando2 = Double.parseDouble(marcoSecundario.getText()) ; // Asigno a operando2 el valor del marco secundario (display) (como double)
                            
                            nuevoNumero = true ; // Reseteo para poder introducir otro número y otro decimal
                            
                            puntoDecimal = false ;
                        }
                        else if (operacion== operacion) 
                        {
                            try
                            {
                                JOptionPane.showMessageDialog(marcoSecundario, "Deja de pulsar un operador, ya está bien \n\t(╯°□°）╯︵ ┻━┻", "Error", HEIGHT);
                                limpiar() ;
                            }
                            catch (Exception ex){
                                marcoSecundario.setText("Error") ;
                            }
                        }
                       
                        
                        else{
                            // Si tenía alguna pendiente, calculo el resultado de la anterior y luego me guardo la actual
                            
                            operando2 = resultado() ; // Se almacena en operando2 para poder encadenar operaciones posteriores.
                            operacion = textoBotones[numBoton] ;
                        }
                        
                        System.out.print(operando2 + " " + operacion + " ") ; // SOUT para comprobar que estoy guardando los valores adecuados.

                        
                    } // Cierra actionPerformed()
                    
                }); // Cierra ActionListener()
            }
        }
        
        
        /**
         * Calcula el reusltado en funcinón de la operación y lo devuelve formateado en el desplay.
         * 
         * @return Devuelve el resultado formateado.
         */
        private double resultado(){
            
            operando1 = Double.parseDouble(marcoSecundario.getText()) ; // Recojo el valor del display (marco secundario)
            System.out.print(operando1 + "\n") ;
            
            switch (operacion){
                // Selecciono y realizo operación
                
                case "+": // SUMA
                    resultado = operando2 + operando1 ;
                    break ;
                    
                case "-": // RESTA
                    resultado = operando2 - operando1 ;
                    break ;
                    
                case "*": // MULTIPLICACIÓN
                    resultado = operando2 * operando1 ;
                    break ;
                    
                case "/": // DIVISIÓN
                    
                    if (operando1 == 0) 
                    {
                        JOptionPane.showMessageDialog(marcoSecundario, "No se puede dividir entre 0.\n\tㄟ( ▔, ▔ )ㄏ", "Error", HEIGHT);
                    }
                    else
                    {
                        resultado = operando2 / operando1 ;
                    }
                    break ;
            }
            
            
            // Formateo y muestro en el display
            
            Locale localActual = Locale.GERMAN ; 
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(localActual) ;
            simbolos.setDecimalSeparator('.') ;
            DecimalFormat formatoResultado = new DecimalFormat("#.######", simbolos) ;
            marcoSecundario.setText(String.valueOf(formatoResultado.format(resultado))) ;
            
            // Limpio variables para poder continuar
            
            limpiar() ;
            
            // Devuelvo el valor del resultado
            
            return resultado ;
        }
        
        
        /**
         * Resetea los valores de la calculadora para poder continar haciendo operaciones.
         */
        private void limpiar(){
            
            operando1 = operando2 = 0 ;
            operacion = "" ;
            nuevoNumero = true ;
            puntoDecimal = false ;
        }
        
        
        
        /**
         * Método que controla el evento asociado al resultado de las operaciones.
         */
        private void eventoResultado(){
            
            botones[0].addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e){
                    /* Al pulsar el botón de resultado, directamente lo calculo y reseteo la calculadora
                    sin necesidad de almacenar el resultado para futuras operaciones.
                    */
                    
                    resultado() ;
                } // Cierra el actionPerformed()
                
            }); // Cierra el ActionListener()
        }
        
        
        /**
         * Método privado asociado al evento de limpiar los datos de la calculadora.
         */
        private void eventoLimpiar(){
            
            botones[13].addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e){
                    // Al pulsar el botón de limpìar, se resetean el display y las variables de la calcudaldor.
                    
                    marcoSecundario.setText("0") ;
                    limpiar();
                    
                } // Ciera actionPerformed()
                
            }); // Cierra ActionListener()
            
        }
        
        public static void main(String[] args) {
        
            new MarcoPrincipal() ;
    }
}
