/*
 * Created by JFormDesigner on Wed Nov 23 01:20:36 CET 2022
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class PantallaPrincipal extends JFrame {
    public PantallaPrincipal() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Proveedores");

                //---- menuItem2 ----
                menuItem2.setText("Gesti\u00f3n de Proveedores");
                menu1.add(menuItem2);

                //======== menu2 ========
                {
                    menu2.setText("Consulta de Proveedores");

                    //---- menuItem3 ----
                    menuItem3.setText("Por c\u00f3digo");
                    menu2.add(menuItem3);

                    //---- menuItem4 ----
                    menuItem4.setText("Por nombre");
                    menu2.add(menuItem4);

                    //---- menuItem5 ----
                    menuItem5.setText("Por direcci\u00f3n");
                    menu2.add(menuItem5);
                }
                menu1.add(menu2);
            }
            menuBar1.add(menu1);
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
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
