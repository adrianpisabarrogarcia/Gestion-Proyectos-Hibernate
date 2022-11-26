/*
 * Created by JFormDesigner on Wed Nov 23 01:20:36 CET 2022
 */

package view;

import java.awt.event.*;
import model.PiezasEntity;
import view.proveedores.GestionProveedores;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantallaPrincipal extends JFrame {
    public PantallaPrincipal() {
        initComponents();
    }

    private void bProoveedores(ActionEvent e) {
        GestionProveedores gestionProveedores = new GestionProveedores();
        gestionProveedores.setVisible(true);
    }

    private void mGestionProveedores(ActionEvent e) {
        // TODO add your code here
    }

    private void mProveedores(ActionEvent e) {
        GestionProveedores gestionProveedores = new GestionProveedores();
        gestionProveedores.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        mProveedores = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem1 = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //---- mProveedores ----
            mProveedores.setText("Proveedores");
            mProveedores.addActionListener(e -> mProveedores(e));
            menuBar1.add(mProveedores);

            //---- menuItem4 ----
            menuItem4.setText("text");
            menuBar1.add(menuItem4);

            //---- menuItem3 ----
            menuItem3.setText("text");
            menuBar1.add(menuItem3);

            //---- menuItem2 ----
            menuItem2.setText("text");
            menuBar1.add(menuItem2);

            //---- menuItem1 ----
            menuItem1.setText("text");
            menuBar1.add(menuItem1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setIcon(new ImageIcon("/Users/adrianpisabarrogarcia/Desktop/Git/GestionProtectos/assets/ges_proyec.jpg"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 35), label1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(715, 505));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenuItem mProveedores;
    private JMenuItem menuItem4;
    private JMenuItem menuItem3;
    private JMenuItem menuItem2;
    private JMenuItem menuItem1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
