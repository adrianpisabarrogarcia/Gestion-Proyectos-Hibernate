/*
 * Created by JFormDesigner on Wed Nov 30 22:06:39 CET 2022
 */

package view.gestion;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Estadisticas extends JFrame {
    public Estadisticas() {
        initComponents();
        this.setTitle("Resúmenes estadísticos - Piezas, proyectos y proveedores");
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
        textPane2 = new JTextPane();
        scrollPane5 = new JScrollPane();
        textPane3 = new JTextPane();
        scrollPane6 = new JScrollPane();
        textPane4 = new JTextPane();
        scrollPane7 = new JScrollPane();
        textPane5 = new JTextPane();

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
        scrollPane1.setBounds(20, 65, 640, 100);

        //---- label2 ----
        label2.setText("Pieza de la que se ha suministrado m\u00e1s cantidad: ");
        contentPane.add(label2);
        label2.setBounds(20, 180, 330, 45);

        //---- label3 ----
        label3.setText("Pieza de la que se ha suministrado a m\u00e1s proyectos:");
        contentPane.add(label3);
        label3.setBounds(20, 230, 330, 45);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(20, 285, 635, 100);

        //---- label4 ----
        label4.setText("Proveedor que ha suministrado m\u00e1s cantidad de piezas:");
        contentPane.add(label4);
        label4.setBounds(20, 395, 370, 45);

        //---- label5 ----
        label5.setText("Proveedor que ha suministrado a m\u00e1s proyectos/n\u00ba proy:");
        contentPane.add(label5);
        label5.setBounds(20, 455, 370, 45);

        //---- label6 ----
        label6.setText("Proveedor que ha suministrado m\u00e1s piezas/n\u00ba piezas:");
        contentPane.add(label6);
        label6.setBounds(15, 515, 370, 45);

        //======== scrollPane3 ========
        {

            //---- textPane1 ----
            textPane1.setEditable(false);
            scrollPane3.setViewportView(textPane1);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(365, 230, 380, 45);

        //======== scrollPane4 ========
        {

            //---- textPane2 ----
            textPane2.setEditable(false);
            scrollPane4.setViewportView(textPane2);
        }
        contentPane.add(scrollPane4);
        scrollPane4.setBounds(365, 175, 380, 45);

        //======== scrollPane5 ========
        {
            scrollPane5.setViewportView(textPane3);
        }
        contentPane.add(scrollPane5);
        scrollPane5.setBounds(395, 395, 350, 50);

        //======== scrollPane6 ========
        {
            scrollPane6.setViewportView(textPane4);
        }
        contentPane.add(scrollPane6);
        scrollPane6.setBounds(395, 455, 350, 50);

        //======== scrollPane7 ========
        {
            scrollPane7.setViewportView(textPane5);
        }
        contentPane.add(scrollPane7);
        scrollPane7.setBounds(395, 515, 350, 50);

        contentPane.setPreferredSize(new Dimension(770, 620));
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
    private JTextPane textPane2;
    private JScrollPane scrollPane5;
    private JTextPane textPane3;
    private JScrollPane scrollPane6;
    private JTextPane textPane4;
    private JScrollPane scrollPane7;
    private JTextPane textPane5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
