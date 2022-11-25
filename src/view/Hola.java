/*
 * Created by JFormDesigner on Thu Nov 24 19:46:19 CET 2022
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Hola extends JFrame {
    public Hola() {
        initComponents();
    }

    private void bAdrian(ActionEvent e) {
        //close current window
        this.dispose();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        bAdrian = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- bAdrian ----
        bAdrian.setText("Aceptar");
        bAdrian.addActionListener(e -> {
			bAdrian(e);
			bAdrian(e);
		});
        contentPane.add(bAdrian);
        bAdrian.setBounds(new Rectangle(new Point(210, 130), bAdrian.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(515, 395));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton bAdrian;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
