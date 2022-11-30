/*
 * Created by JFormDesigner on Wed Nov 30 20:49:03 CET 2022
 */

package view.gestion;

import java.awt.event.*;

import controller.generales.GestionController;
import controller.generales.ProveedoresController;
import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author unknown
 */
public class SuministrosPorProveedorView extends JFrame {
    public SuministrosPorProveedorView() {
        initComponents();
        this.setTitle("Suministros por proveedor");
        cargarCombo();
        cargarTabla();
    }

    private void cargarTabla() {
        int idProveedor = Integer.parseInt(comboInfo.getSelectedItem().toString());
        ArrayList<PiezasEntity> piezas = GestionController.getGestionFilterByProveedorToPiezas(idProveedor);
        ArrayList<ProyectosEntity> proyectos = GestionController.getGestionFilterByProveedorToProyectos(idProveedor);

        Object[][] data = new Object[piezas.size()+proyectos.size()][PiezasEntity.getColumns().length+ProyectosEntity.getColumns().length];
        for (int i = 0; i < piezas.size(); i++) {
            PiezasEntity piezasEntity = piezas.get(i);
            ProyectosEntity proyectosEntity = proyectos.get(i);
            Object[] piezasArray = piezasEntity.toArray();
            Object[] proyectosArray = proyectosEntity.toArray();
            for (int j = 0; j < piezasArray.length; j++) {
                data[i][j] = piezasArray[j];
            }
            for (int j = 0; j < proyectosArray.length; j++) {
                data[i][j+piezasArray.length] = proyectosArray[j];
            }
        }


        String[] columns = new String[PiezasEntity.getColumns().length+ProyectosEntity.getColumns().length];
        for (int j = 0; j < PiezasEntity.getColumns().length; j++) {
            columns[j] = PiezasEntity.getColumns()[j];
        }
        for (int j = 0; j < ProyectosEntity.getColumns().length; j++) {
            columns[j+PiezasEntity.getColumns().length] = ProyectosEntity.getColumns()[j];
        }

        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columns
        ));

        //Cargar los literales
        labelOne.setText("Piezas suministradas: "+piezas.size());
        labelOne2.setText("Proyectos: "+proyectos.size());
    }

    private void cargarCombo() {
        ArrayList<ProveedoresEntity> proveedores = ProveedoresController.getProveedores();
        for (ProveedoresEntity proveedor : proveedores) {
            comboInfo.addItem(""+proveedor.getId());
        }
        if (proveedores.size() > 0) {
            comboInfo.setSelectedIndex(0);
        }
    }

    private void comboInfoItemStateChanged(ItemEvent e) {
        String id = (String) comboInfo.getSelectedItem();
        ProveedoresEntity proveedor = ProveedoresController.getProveedor(Integer.parseInt(id));
        if (proveedor != null) {
            tpObjeto.setText(proveedor.toString());
            cargarTabla();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        comboInfo = new JComboBox();
        scrollPane1 = new JScrollPane();
        tpObjeto = new JTextPane();
        scrollPane2 = new JScrollPane();
        table = new JTable();
        labelOne = new JLabel();
        labelOne2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Proveedor");
        contentPane.add(label1);
        label1.setBounds(35, 50, 85, label1.getPreferredSize().height);

        //---- comboInfo ----
        comboInfo.addItemListener(e -> comboInfoItemStateChanged(e));
        contentPane.add(comboInfo);
        comboInfo.setBounds(115, 45, 120, comboInfo.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- tpObjeto ----
            tpObjeto.setEditable(false);
            scrollPane1.setViewportView(tpObjeto);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(260, 35, 460, 75);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(35, 145, 690, 175);

        //---- labelOne ----
        labelOne.setText("text");
        contentPane.add(labelOne);
        labelOne.setBounds(115, 345, 200, labelOne.getPreferredSize().height);

        //---- labelOne2 ----
        labelOne2.setText("text");
        contentPane.add(labelOne2);
        labelOne2.setBounds(425, 345, 210, 16);

        contentPane.setPreferredSize(new Dimension(770, 420));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JComboBox comboInfo;
    private JScrollPane scrollPane1;
    private JTextPane tpObjeto;
    private JScrollPane scrollPane2;
    private JTable table;
    private JLabel labelOne;
    private JLabel labelOne2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
