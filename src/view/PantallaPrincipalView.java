/*
 * Created by JFormDesigner on Wed Nov 23 01:20:36 CET 2022
 */

package view;

import java.awt.event.*;

import view.ayuda.AyudaView;
import view.piezas.PiezasView;
import view.proveedores.ProveedoresView;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantallaPrincipalView extends JFrame {
    public PantallaPrincipalView() {
        initComponents();
        this.setTitle("Gestión de Proyectos");
    }

    private void bProoveedores(ActionEvent e) {
        ProveedoresView proveedoresView = new ProveedoresView();
        proveedoresView.setVisible(true);
    }

    private void mGestionProveedores(ActionEvent e) {
        // TODO add your code here
    }

    private void mProveedores(ActionEvent e) {
        ProveedoresView proveedoresView = new ProveedoresView();
        proveedoresView.setVisible(true);
    }

    private void mAyuda(ActionEvent e) {
        AyudaView ayudaView = new AyudaView();
        ayudaView.setVisible(true);
    }

    private void mPiezas(ActionEvent e) {
        PiezasView piezasView = new PiezasView();
        piezasView.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        mProveedores = new JMenuItem();
        mPiezas = new JMenuItem();
        mProyectos = new JMenuItem();
        mGestionGlobal = new JMenuItem();
        mAyuda = new JMenuItem();
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

            //---- mPiezas ----
            mPiezas.setText("Piezas");
            mPiezas.addActionListener(e -> mPiezas(e));
            menuBar1.add(mPiezas);

            //---- mProyectos ----
            mProyectos.setText("Proyectos");
            menuBar1.add(mProyectos);

            //---- mGestionGlobal ----
            mGestionGlobal.setText("Gesti\u00f3n Global");
            menuBar1.add(mGestionGlobal);

            //---- mAyuda ----
            mAyuda.setText("Ayuda");
            mAyuda.addActionListener(e -> mAyuda(e));
            menuBar1.add(mAyuda);
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
    private JMenuItem mPiezas;
    private JMenuItem mProyectos;
    private JMenuItem mGestionGlobal;
    private JMenuItem mAyuda;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
