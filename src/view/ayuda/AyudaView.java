/*
 * Created by JFormDesigner on Sat Nov 26 19:08:10 CET 2022
 */

package view.ayuda;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;

/**
 * @author unknown
 */
public class AyudaView extends JFrame {
    public AyudaView() {
        initComponents();
        this.setTitle("Ayuda");
    }

    private void label5MouseClicked(MouseEvent e) {
        //hipervinculo para redireccionar a la pagina web
        try {
            //Abrir navegador predeterminado
            Desktop.getDesktop().browse(new URI("https://github.com/adrianpisabarrogarcia"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Informaci\u00f3n a cerca del autor");
        label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(140, 35), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Nombre y Apellidos: ");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(505, 105), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("URL Github:");
        contentPane.add(label3);
        label3.setBounds(505, 145, 85, 16);

        //---- label4 ----
        label4.setText("Adri\u00e1n Pisabarro Garc\u00eda");
        label4.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(640, 105), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("https://github.com/adrianpisabarrogarcia");
        label5.setForeground(Color.blue);
        label5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label5.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        label5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label5MouseClicked(e);
            }
        });
        contentPane.add(label5);
        label5.setBounds(595, 145, 295, 16);

        //---- label6 ----
        label6.setIcon(new ImageIcon("/Users/adrianpisabarrogarcia/Desktop/Git/GestionProtectos/assets/foto_autor.jpg"));
        contentPane.add(label6);
        label6.setBounds(45, 80, 440, 330);

        contentPane.setPreferredSize(new Dimension(945, 475));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
