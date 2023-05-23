
package ejercicio2.interfaz;

import ejercicio2.modelo.CuerpoCeleste;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrián
 */
public class VentanaSecundaria extends javax.swing.JFrame {
    
    
    // ------------ DECLARACIÓN DE VARIABLES -----------------

    private static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    
    
    // ---------------- MÉTODOS ------------------
    
        // --- CONSTRUCTORES ---
    
    /**
     * Creates new form VentanaSecundaria
     */
    public VentanaSecundaria(List<CuerpoCeleste> cuerposCelestes) {
        initComponents();
        setLocationRelativeTo(null) ;
        
        JTable  tabla ;
        DefaultTableModel modeloTabla ;
        
        cuerposCelestes = InterfazGrafica.cuerposCelestes ;
        
         // Crear los datos de la tabla en un arreglo bidimensional
        Object[][] data = new Object[cuerposCelestes.size()][5];
        for (int i = 0; i < cuerposCelestes.size(); i++) {
            CuerpoCeleste cuerpoCeleste = cuerposCelestes.get(i);
            data[i][0] = i + 1 ;
            data[i][1] = cuerpoCeleste.getCodigoCuerpo() ;
            data[i][2] = cuerpoCeleste.getNombre();
            data[i][3] = cuerpoCeleste.getTipoObjeto();
            data[i][4] = cuerpoCeleste.getDiametro();
        }

        // Crear los nombres de las columnas
        String[] columnNames = { "Registro", "Código", "Nombre", "Tipo", "Diámetro" };

        // Crear el modelo de la tabla con los datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo
        tabla = new JTable(model);

        // Agregar la tabla a un JScrollPane para permitir el desplazamiento si hay muchos registros
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        add(scrollPane);
        scrollPane.setVisible(true) ;
        tabla.setVisible(true);
        
        marcoPrincipal.setLayout(null) ;
        scrollPane.setBounds(200, 100, 600, 400) ;
        marcoPrincipal.add(scrollPane) ;
    }
    
    
      /**
     * Creates new form VentanaSecundaria
     */
    public VentanaSecundaria(List<CuerpoCeleste> cuerposCelestes, DefaultTableModel modeloTabla) {
        initComponents();
        setLocationRelativeTo(null) ;
        
        JTable  tabla ;
        
        cuerposCelestes = InterfazGrafica.cuerposCelestes ;
        
         // Crear los datos de la tabla en un arreglo bidimensional
        Object[][] data = new Object[cuerposCelestes.size()][4];
        for (int i = 0; i < cuerposCelestes.size(); i++) {
            CuerpoCeleste cuerpoCeleste = cuerposCelestes.get(i);
            data[i][0] = cuerpoCeleste.getCodigoCuerpo() ;
            data[i][1] = cuerpoCeleste.getNombre();
            data[i][2] = cuerpoCeleste.getTipoObjeto();
            data[i][3] = cuerpoCeleste.getDiametro();
        }

        // Crear los nombres de las columnas
        String[] columnNames = { "Código", "Nombre", "Tipo", "Diámetro" };

        // Crear el modelo de la tabla con los datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo
        tabla = new JTable(model);

        // Agregar la tabla a un JScrollPane para permitir el desplazamiento si hay muchos registros
        JScrollPane scrollPane = new JScrollPane(tabla);
        
        add(scrollPane);
        scrollPane.setVisible(true) ;
        tabla.setVisible(true);
        
        marcoPrincipal.setLayout(null) ;
        scrollPane.setBounds(200, 100, 600, 400) ;
        marcoPrincipal.add(scrollPane) ;
    }

    
    
    // ----------------- CÓDIGO GENERADO POR NETBEANS ---------------------
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marcoPrincipal = new javax.swing.JPanel();
        botonVolver = new javax.swing.JButton();
        consolaMensajes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        consolaMensajes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        consolaMensajes.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout marcoPrincipalLayout = new javax.swing.GroupLayout(marcoPrincipal);
        marcoPrincipal.setLayout(marcoPrincipalLayout);
        marcoPrincipalLayout.setHorizontalGroup(
            marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPrincipalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(consolaMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353))
        );
        marcoPrincipalLayout.setVerticalGroup(
            marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(marcoPrincipalLayout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(marcoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, marcoPrincipalLayout.createSequentialGroup()
                        .addComponent(consolaMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(marcoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(marcoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        dispose() ;
        
        InterfazGrafica ventanaPrincipal = new InterfazGrafica() ;
        ventanaPrincipal.setVisible(true) ;
    }//GEN-LAST:event_botonVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSecundaria(cuerposCelestes).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver;
    public static javax.swing.JLabel consolaMensajes;
    private javax.swing.JPanel marcoPrincipal;
    // End of variables declaration//GEN-END:variables
}
