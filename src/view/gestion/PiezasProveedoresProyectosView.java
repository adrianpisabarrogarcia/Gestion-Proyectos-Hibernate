/*
 * Created by JFormDesigner on Mon Nov 28 21:08:01 CET 2022
 */

package view.gestion;

import controller.generales.PiezasController;
import controller.generales.GestionController;
import controller.generales.ProveedoresController;
import controller.generales.ProyectosController;
import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author adrianpisabarrogarcia
 */
public class PiezasProveedoresProyectosView extends JFrame {

    private boolean isUpdate = false;
    public PiezasProveedoresProyectosView() {
        initComponents();
        this.setTitle("Gestión global - Piezas, Proveedores y Proyectos");
        cargarDatos();
    }

    // Carga los datos en los combobox nada más abrir la ventana
    private void cargarDatos() {
        ArrayList<PiezasEntity> piezas = PiezasController.getPiezas();
        int contadorPiezas = 0;
        for (PiezasEntity pieza : piezas) {
            cbPieza.addItem(Integer.toString(pieza.getId()));
            if (contadorPiezas == 0) {
                tpPieza.setText(pieza.toString());
            }
            contadorPiezas++;
        }
        ArrayList<ProveedoresEntity> proveedores = ProveedoresController.getProveedores();
        int contadorProveedores = 0;
        for (ProveedoresEntity proveedor : proveedores) {
            cbProveedor.addItem(Integer.toString(proveedor.getId()));
            if (contadorProveedores == 0) {
                tpProveedor.setText(proveedor.toString());
            }
            contadorProveedores++;
        }
        ArrayList<ProyectosEntity> proyectos = ProyectosController.getProyectos();
        int contadorProyectos = 0;
        for (ProyectosEntity proyecto : proyectos) {
            cbProyecto.addItem(Integer.toString(proyecto.getId()));
            if (contadorProyectos == 0) {
                tpProyecto.setText(proyecto.toString());
            }
            contadorProyectos++;
        }

        if (piezas.size() > 0 && proveedores.size() > 0 && proyectos.size() > 0) {
            PiezasEntity pieza = piezas.get(0);
            int idPieza = pieza.getId();
            ProyectosEntity proyecto = proyectos.get(0);
            int idProyecto = proyecto.getId();
            ProveedoresEntity proveedor = proveedores.get(0);
            int idProveedor = proveedor.getId();

            GestionEntity gestion = GestionController.getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
            if (gestion != null) {
                tfCantidad.setText(gestion.getCantidad().toString());
            }
        }
        isUpdate = true;
    }

    // Cargar los datos en los textpane cuando se cambia el combobox e imprimir si existe la cantidad
    private void cargarDatosSelected(){
        int idPieza = Integer.parseInt(cbPieza.getSelectedItem().toString());
        int idProveedor = Integer.parseInt(cbProveedor.getSelectedItem().toString());
        int idProyecto = Integer.parseInt(cbProyecto.getSelectedItem().toString());
        PiezasEntity pieza = PiezasController.getPieza(idPieza);
        ProveedoresEntity proveedor = ProveedoresController.getProveedor(idProveedor);
        ProyectosEntity proyecto = ProyectosController.getProyecto(idProyecto);
        tpPieza.setText(pieza.toString());
        tpProveedor.setText(proveedor.toString());
        tpProyecto.setText(proyecto.toString());
        GestionEntity gestion = GestionController.getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
        if (gestion != null) {
            tfCantidad.setText(gestion.getCantidad().toString());
        } else {
            tfCantidad.setText("");
        }
    }

    private void bInsertar(ActionEvent e) {
        String cantidad = tfCantidad.getText();
        int idPieza = Integer.parseInt(cbPieza.getSelectedItem().toString());
        int idProveedor = Integer.parseInt(cbProveedor.getSelectedItem().toString());
        int idProyecto = Integer.parseInt(cbProyecto.getSelectedItem().toString());
        String accion = GestionController.insertarPiezaProveedorProyecto(idPieza, idProveedor, idProyecto, cantidad);
        JOptionPane.showMessageDialog(null, accion);
    }

    private void cbProveedorItemStateChanged(ItemEvent e) {
        if(isUpdate){
            cargarDatosSelected();
        }
    }

    private void cbPiezaItemStateChanged(ItemEvent e) {
        if(isUpdate){
            cargarDatosSelected();
        }
    }

    private void cbProyectoItemStateChanged(ItemEvent e) {
        if(isUpdate){
            cargarDatosSelected();
        }
    }

    private void bModificar(ActionEvent e) {
        String cantidad = tfCantidad.getText();
        int idPieza = Integer.parseInt(cbPieza.getSelectedItem().toString());
        int idProveedor = Integer.parseInt(cbProveedor.getSelectedItem().toString());
        int idProyecto = Integer.parseInt(cbProyecto.getSelectedItem().toString());
        String accion = GestionController.modificarPiezaProveedorProyecto(idPieza, idProveedor, idProyecto, cantidad);
        JOptionPane.showMessageDialog(null, accion);
    }

    private void bEliminar(ActionEvent e) {
        int idPieza = Integer.parseInt(cbPieza.getSelectedItem().toString());
        int idProveedor = Integer.parseInt(cbProveedor.getSelectedItem().toString());
        int idProyecto = Integer.parseInt(cbProyecto.getSelectedItem().toString());
        String accion = GestionController.eliminarPiezaProveedorProyecto(idPieza, idProveedor, idProyecto);
        JOptionPane.showMessageDialog(null, accion);
        if (accion.equals("Se ha eliminado correctamente")) {
            tfCantidad.setText("");
        }
    }

    private void bListado(ActionEvent e) {
        Listado listado = new Listado();
        listado.setVisible(true);
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
        label1.setBounds(new Rectangle(new Point(500, 40), label1.getPreferredSize()));

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

        //---- cbProveedor ----
        cbProveedor.addItemListener(e -> cbProveedorItemStateChanged(e));
        contentPane.add(cbProveedor);
        cbProveedor.setBounds(115, 85, 95, cbProveedor.getPreferredSize().height);

        //---- label3 ----
        label3.setText("Pieza:");
        contentPane.add(label3);
        label3.setBounds(35, 185, 66, 16);

        //---- cbPieza ----
        cbPieza.addItemListener(e -> cbPiezaItemStateChanged(e));
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

        //---- cbProyecto ----
        cbProyecto.addItemListener(e -> cbProyectoItemStateChanged(e));
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
            bInsertar.addActionListener(e -> bInsertar(e));
            toolBar1.add(bInsertar);

            //---- bModificar ----
            bModificar.setText("Modificar");
            bModificar.addActionListener(e -> bModificar(e));
            toolBar1.add(bModificar);

            //---- bEliminar ----
            bEliminar.setText("Eliminar");
            bEliminar.addActionListener(e -> bEliminar(e));
            toolBar1.add(bEliminar);

            //---- bListado ----
            bListado.setText("Listado");
            bListado.addActionListener(e -> bListado(e));
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
