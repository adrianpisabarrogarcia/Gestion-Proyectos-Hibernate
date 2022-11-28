/*
 * Created by JFormDesigner on Mon Nov 28 21:08:01 CET 2022
 */

package view.gestion;

import java.awt.*;
import javax.swing.*;

/**
 * @author adrianpisabarrogarcia
 */
public class PiezasProveedoresProyectosView extends JFrame {
    public PiezasProveedoresProyectosView() {
        initComponents();
        this.setTitle("Gestión global - Piezas, Proveedores y Proyectos");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        tpProveedor = new JTextPane();
        cbProveedor = new JComboBox();
        label3 = new JLabel();
        cbPieza = new JComboBox();
        tpPieza = new JTextPane();
        tpProyecto = new JTextPane();
        label4 = new JLabel();
        cbProyecto = new JComboBox();
        label5 = new JLabel();
        tfCantidad = new JTextField();
        toolBar1 = new JToolBar();
        bInsertar = new JButton();
        bModificar = new JButton();
        bEliminar = new JButton();
        bListado = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Relaciones Piezas-Proveedores-Proyectos");
        label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 13));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(530, 45), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Proveedor:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 90), label2.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- tpProveedor ----
            tpProveedor.setEditable(false);
            scrollPane1.setViewportView(tpProveedor);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(235, 90, 510, 70);
        contentPane.add(cbProveedor);
        cbProveedor.setBounds(115, 85, 95, cbProveedor.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Pieza:");
        contentPane.add(label3);
        label3.setBounds(35, 185, 66, 16);
        contentPane.add(cbPieza);
        cbPieza.setBounds(115, 180, 95, 27);

        //---- tpPieza ----
        tpPieza.setEditable(false);
        contentPane.add(tpPieza);
        tpPieza.setBounds(235, 185, 506, 66);

        //---- tpProyecto ----
        tpProyecto.setEditable(false);
        contentPane.add(tpProyecto);
        tpProyecto.setBounds(235, 290, 506, 66);

        //---- label4 ----
        label4.setText("Proyecto:");
        contentPane.add(label4);
        label4.setBounds(35, 290, 66, 16);
        contentPane.add(cbProyecto);
        cbProyecto.setBounds(115, 285, 95, 27);

        //---- label5 ----
        label5.setText("Cantidad: ");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(235, 400), label5.getPreferredSize()));
        contentPane.add(tfCantidad);
        tfCantidad.setBounds(310, 395, 195, tfCantidad.getPreferredSize().height);

        //======== toolBar1 ========
        {

            //---- bInsertar ----
            bInsertar.setText("Insertar");
            toolBar1.add(bInsertar);

            //---- bModificar ----
            bModificar.setText("Modificar");
            toolBar1.add(bModificar);

            //---- bEliminar ----
            bEliminar.setText("Eliminar");
            toolBar1.add(bEliminar);

            //---- bListado ----
            bListado.setText("Listado");
            toolBar1.add(bListado);
        }
        contentPane.add(toolBar1);
        toolBar1.setBounds(0, 5, 825, toolBar1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(830, 495));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextPane tpProveedor;
    private JComboBox cbProveedor;
    private JLabel label3;
    private JComboBox cbPieza;
    private JTextPane tpPieza;
    private JTextPane tpProyecto;
    private JLabel label4;
    private JComboBox cbProyecto;
    private JLabel label5;
    private JTextField tfCantidad;
    private JToolBar toolBar1;
    private JButton bInsertar;
    private JButton bModificar;
    private JButton bEliminar;
    private JButton bListado;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
