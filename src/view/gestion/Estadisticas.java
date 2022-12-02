/*
 * Created by JFormDesigner on Wed Nov 30 22:06:39 CET 2022
 */

package view.gestion;

import controller.generales.GestionController;
import controller.generales.ProveedoresController;
import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import static controller.generales.GestionController.piezaConMasProyectos;

/**
 * @author unknown
 */
public class Estadisticas extends JFrame {
    public Estadisticas() {
        initComponents();
        this.setTitle("Resúmenes estadísticos - Piezas, proyectos y proveedores");
        cargarTabla1();
        piezaConMasCantidad();
        piezaCountMasProyectos();
        cargarTabla2();
        proveedorConMasCantidadPiezas();
        proveedorConMasProyectos();
        proveedorConMasPiezas();

    }

    private void proveedorConMasPiezas() {
        ProveedoresEntity proveedor = GestionController.proveedorConMasPiezas();
        if (proveedor != null) {
            textPane5.setText(proveedor.toString());
        }else{
            textPane5.setText("No hay proveedores");
        }
    }

    private void proveedorConMasProyectos() {
        ProveedoresEntity proveedor = GestionController.proveedorConMasProyectos();
        if (proveedor != null) {
            textPane4.setText(proveedor.toString());
        }else{
            textPane4.setText("No hay proveedores");
        }
    }

    private void proveedorConMasCantidadPiezas() {
        ProveedoresEntity proveedor = GestionController.proveedorConMasCantidadPiezas();
        if (proveedor != null) {
            textPane3.setText(proveedor.toString());
        }else{
            textPane3.setText("No hay proveedores");
        }
    }

    private void cargarTabla2() {
        ArrayList<String[]> elementos = GestionController.numPiezasPorProveedores();
        Object[][] data = new Object[elementos.size()][6];
        for (int i = 0; i < elementos.size(); i++) {
            data[i][0] = elementos.get(i)[0];
            data[i][1] = elementos.get(i)[1];
            data[i][2] = elementos.get(i)[2];
            data[i][3] = elementos.get(i)[3];
            data[i][4] = elementos.get(i)[4];
            data[i][5] = elementos.get(i)[5];
        }

        table2.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String [] {
                        "ID Proveedor", "Nombre", "Apellidos", "Direccion", "Nº de peizas", "Cantidad total"
                }
        ));
    }

    private void piezaCountMasProyectos() {
        PiezasEntity pieza = piezaConMasProyectos();
        if (pieza != null) {
            textPane1.setText(pieza.toString());
        } else {
            textPane1.setText("No hay piezas");
        }
    }

    private void piezaConMasCantidad() {
        PiezasEntity pieza = GestionController.piezaConMasCantidad();
        if (pieza != null) {
            piezaMasGrande.setText(pieza.toString());
        }
    }

    private void cargarTabla1() {
        ArrayList<String[]> elementos = GestionController.numPiezasPorProyectos();
        Object[][] data = new Object[elementos.size()][5];
        for (int i = 0; i < elementos.size(); i++) {
            data[i][0] = elementos.get(i)[0];
            data[i][1] = elementos.get(i)[1];
            data[i][2] = elementos.get(i)[2];
            data[i][3] = elementos.get(i)[3];
            data[i][4] = elementos.get(i)[4];
        }

        table1.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String [] {
                        "ID Proyecto", "Nombre", "Ciudad", "Nº piezas", "Cantidad total"
                }
        ));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();
        scrollPane4 = new JScrollPane();
        piezaMasGrande = new JTextPane();
        scrollPane5 = new JScrollPane();
        textPane3 = new JTextPane();
        scrollPane6 = new JScrollPane();
        textPane4 = new JTextPane();
        scrollPane7 = new JScrollPane();
        textPane5 = new JTextPane();
        label7 = new JLabel();
        label8 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Res\u00famenes estad\u00edsticos - Piezas, proyectos y proveedores");
        label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(label1);
        label1.setBounds(20, 30, 635, label1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 95, 640, 100);

        //---- label2 ----
        label2.setText("Pieza de la que se ha suministrado m\u00e1s cantidad: ");
        contentPane.add(label2);
        label2.setBounds(20, 205, 330, 45);

        //---- label3 ----
        label3.setText("N\u00ba de piezas y cantidad de las piezas suministradas en proyectos:");
        contentPane.add(label3);
        label3.setBounds(30, 50, 655, 45);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(40, 345, 635, 100);

        //---- label4 ----
        label4.setText("Proveedor que ha suministrado m\u00e1s cantidad de piezas:");
        contentPane.add(label4);
        label4.setBounds(20, 460, 370, 45);

        //---- label5 ----
        label5.setText("Proveedor que ha suministrado a m\u00e1s proyectos/n\u00ba proy:");
        contentPane.add(label5);
        label5.setBounds(20, 525, 370, 45);

        //---- label6 ----
        label6.setText("Proveedor que ha suministrado m\u00e1s piezas/n\u00ba piezas:");
        contentPane.add(label6);
        label6.setBounds(15, 595, 370, 45);

        //======== scrollPane3 ========
        {

            //---- textPane1 ----
            textPane1.setEditable(false);
            scrollPane3.setViewportView(textPane1);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(365, 265, 380, 45);

        //======== scrollPane4 ========
        {

            //---- piezaMasGrande ----
            piezaMasGrande.setEditable(false);
            scrollPane4.setViewportView(piezaMasGrande);
        }
        contentPane.add(scrollPane4);
        scrollPane4.setBounds(365, 205, 380, 45);

        //======== scrollPane5 ========
        {
            scrollPane5.setViewportView(textPane3);
        }
        contentPane.add(scrollPane5);
        scrollPane5.setBounds(395, 455, 350, 50);

        //======== scrollPane6 ========
        {
            scrollPane6.setViewportView(textPane4);
        }
        contentPane.add(scrollPane6);
        scrollPane6.setBounds(395, 520, 350, 50);

        //======== scrollPane7 ========
        {
            scrollPane7.setViewportView(textPane5);
        }
        contentPane.add(scrollPane7);
        scrollPane7.setBounds(395, 590, 350, 50);

        //---- label7 ----
        label7.setText("N\u00ba de piezas y cantidad de piezas suministradas por proveedor:");
        contentPane.add(label7);
        label7.setBounds(40, 315, 640, label7.getPreferredSize().height);

        //---- label8 ----
        label8.setText("Pieza de la que se ha suministrado m\u00e1s cantidad: ");
        contentPane.add(label8);
        label8.setBounds(25, 265, 330, 45);

        contentPane.setPreferredSize(new Dimension(770, 710));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    private JScrollPane scrollPane4;
    private JTextPane piezaMasGrande;
    private JScrollPane scrollPane5;
    private JTextPane textPane3;
    private JScrollPane scrollPane6;
    private JTextPane textPane4;
    private JScrollPane scrollPane7;
    private JTextPane textPane5;
    private JLabel label7;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
