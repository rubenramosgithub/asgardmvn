package com.ap.main;

import com.ap.configuracion.Parametros;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Clase principal del juego. Se trata de un <code>JFrame</code> sobre el que se declarará, 
 * en un principio, un <code>PanelPresentacion</code> que servirá de introducción al juego. 
 * Una vez se cumplan las condiciones marcadas en dicho <code>PanelPresentacion</code>, éste
 * será eliminado y sobre el frame principal se situará un nuevo <code>PanelJuego</code>, ya con 
 * el contenido jugable.
 * 
 * @author Sergio
 * @version 1.0, 6 Jun 2014
 * @see PanelPresentacion
 * @see PanelJuego
 */
public final class Main extends javax.swing.JFrame {

    private PanelPresentacion panelPresentacion;
    private PanelJuego panelJuego; 
    /**
     * Crea un nuevo elemento <code>Main</code>
     */
    public Main()
    {initComponents();
        initMoreComponents();}
    
    /**
     * Continua con la inicialización de parámetros del <code>Main</code>, centrándolo
     * en pantalla, fijando el idioma como español y situando sobre él un <code>PanelPresentacion</code>
     * 
     * @see PanelPresentacion
     */
    public void initMoreComponents(){
        
        setLocationRelativeTo(null); //centro el frame en la pantalla
        com.ap.configuracion.Parametros.getInstance().setLocalizacion(new Locale("es")); //Fijo idioma
        this.setVisible(true);
        panelPresentacion = new PanelPresentacion(this);
        panelPresentacion.setBounds(
                0,
                0,
                Parametros.getInstance().getANCHO_PANTALLA_JUEGO(),
                Parametros.getInstance().getALTO_PANTALLA_JUEGO()
            );
        add(panelPresentacion,new Integer(0));
        panelPresentacion.requestFocus();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuItOpciones = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asgard");
        setMinimumSize(new java.awt.Dimension(640, 482));
        setResizable(false);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Editor de mapas...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuItOpciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuItOpciones.setText("Opciones");
        menuItOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItOpcionesActionPerformed(evt);
            }
        });
        jMenu1.add(menuItOpciones);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sale del programa.
     * @param evt 
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Abre el editor de pantallas
     * @param evt 
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        com.ap.editor.Main editorMapas = new com.ap.editor.Main();
        editorMapas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cuando demos a la X de cerrar, SOLO destruirá este nuevo panel
        editorMapas.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Abre el diálogo de opciones
     * @param evt 
     */
    private void menuItOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItOpcionesActionPerformed
        DialogoMenu dialogoMenu = new DialogoMenu(this,false);
        dialogoMenu.setLocationRelativeTo(panelJuego);
        
        dialogoMenu.setVisible(true);
        PanelJuego.getPanelDialogo().setVisible(false);
        this.panelJuego.getPersonaje().setFinDialogo(true);
        dialogoMenu.requestFocus();
    }//GEN-LAST:event_menuItOpcionesActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuItOpciones;
    // End of variables declaration//GEN-END:variables

    /**
     * Fija el atributo <code>PanelJuego</code>
     * @param panelJuego Atributo <code>PanelJuego</code>
     */
    public void setPanelJuego(PanelJuego panelJuego){
        this.panelJuego = panelJuego;
    }

    /**
     * Devuelve un elemento <code>PanelJuego</code>
     * @return Atributo <code>PanelJuego</code>
     */
    public PanelJuego getPanelJuego() {
        return panelJuego;
    }
}
