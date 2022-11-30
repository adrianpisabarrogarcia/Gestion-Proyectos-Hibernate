/*
 * Created by JFormDesigner on Wed Nov 30 20:13:15 CET 2022
 */

package view.gestion;

import controller.generales.PiezasProveedoresProyectosController;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Listado extends JFrame {
    public Listado() {
        initComponents();
        this.setTitle("Listado de piezas, proveedores y proyectos");
        cargarListado();
    }

    private void cargarListado() {
        String listado = PiezasProveedoresProyectosController.getListado();
        jtpListado.setText(listado);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        jtpListado = new JTextPane();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- jtpListado ----
            jtpListado.setEditable(false);
            scrollPane1.setViewportView(jtpListado);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 20, 845, 455);

        contentPane.setPreferredSize(new Dimension(910, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextPane jtpListado;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
