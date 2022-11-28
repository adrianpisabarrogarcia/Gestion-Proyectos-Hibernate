/*
 * Created by JFormDesigner on Sat Nov 26 12:33:02 CET 2022
 */

package view.proyectos;

import controller.proveedores.PiezasController;
import controller.proveedores.ProyectosController;
import model.PiezasEntity;
import model.ProyectosEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class ProyectosView extends JFrame {
    public ProyectosView() {
        initComponents();
        this.setTitle("Gestión de Proyectos");
        // Nada más cargar la ventana, se cargan los datos de la tabla
        cargarTodosLosProyectos();
    }

    //Métodos personalizados

    private void bFiltrar(ActionEvent e) {
        String nombre = tfNombre.getText();
        String id = tfId.getText();
        String ciudad = tfCiudad.getText();
        try{
            int idInt = Integer.parseInt(id);
            ArrayList<ProyectosEntity> proyectos = ProyectosController.filtrarPor(nombre, id, ciudad);
            cargarTablaListadoProyectos(proyectos);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "El id debe ser un número");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void bVaciarFiltro(ActionEvent e) {
        textFieldsBlanc();
        cargarTodosLosProyectos();
    }

    private void tabListaProveedoresComponentShown(ComponentEvent e) {
        cargarTodosLosProyectos();
        textFieldsBlanc();
    }

    private void textFieldsBlanc() {
        tfId.setText("");
        tfNombre.setText("");
        tfCiudad.setText("");
        tfGId.setText("");
        tfGNombre.setText("");
        tfGCiudad.setText("");
    }

    private void TabListaPiezasPropertyChange(PropertyChangeEvent e) {
        cargarTodosLosProyectos();
    }

    private void bGBuscar(ActionEvent e) {
        String id = tfGId.getText();
        if(!id.equals("")) {
            try {
                int intId = Integer.parseInt(id);
                ProyectosEntity proyecto = ProyectosController.getProyecto(intId);
                if(proyecto != null) {
                    tfGNombre.setText(proyecto.getNombre());
                    tfGCiudad.setText(proyecto.getCiudad());
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el proyecyo");
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código no válido");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Introduce un código para poder buscar");
        }
    }


    private void bGLimpiar(ActionEvent e) {
        vaciarbG();
    }

    private void vaciarbG(){
        tfGId.setText("");
        tfGNombre.setText("");
        tfGCiudad.setText("");
    }

    private void bGModificar(ActionEvent e) {
        String id = tfGId.getText();
        String nombre = tfGNombre.getText();
        String ciudad = tfGCiudad.getText();

        String acciones = ProyectosController.updatePryecto(id, nombre, ciudad);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Proyecto modificado correctamente");
            vaciarbG();
        } else {
            JOptionPane.showMessageDialog(null, acciones);
        }
    }
    private void bGInsertar(ActionEvent e) {
        String nombre = tfGNombre.getText();
        String ciudad = tfGCiudad.getText();

        String acciones = ProyectosController.insertProyecto(nombre, ciudad);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Proyecto insertado correctamente");
            vaciarbG();
        } else {
            JOptionPane.showMessageDialog(null, acciones);
        }
    }

    private void bGEliminar(ActionEvent e) {
        String id = tfGId.getText();
        if(!id.equals("")) {
            try {
                int intId = Integer.parseInt(id);
                String acciones = ProyectosController.deleteProyecto(intId);
                if (acciones.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Proyecto eliminado correctamente");
                    vaciarbG();
                } else if (acciones.equals("no")) {
                } else {
                    JOptionPane.showMessageDialog(null, acciones);
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código no válido");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Introduce un código para poder eliminar");
        }
    }

    /**
     * Carga todos los proyectos pasadas por parámetro a la tabla.
     * @param proyectos
     */
    private void cargarTablaListadoProyectos(ArrayList<ProyectosEntity> proyectos) {
        Object[][] data = new Object[proyectos.size()][ProyectosEntity.getColumns().length];
        for (int i = 0; i < proyectos.size(); i++) {
            ProyectosEntity proyecto = proyectos.get(i);
            data[i] = proyecto.toArray();
        }

        tListadoPiezas.setModel(new javax.swing.table.DefaultTableModel(
                data,
                ProyectosEntity.getColumns()
        ));
    }

    /**
     * Carga todos los proyectos de la base de datos a la tabla,
     * nada más incializar el componente de piezas.
     */
    private void cargarTodosLosProyectos(){
        // Cargamos todos los proyectos
        ArrayList<ProyectosEntity> proyectos = ProyectosController.getProyectos();
        cargarTablaListadoProyectos(proyectos);
    }

    private void TabListaProyectosPropertyChange(PropertyChangeEvent e) {
        cargarTodosLosProyectos();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        tListadoPiezas = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tfId = new JTextField();
        tfNombre = new JTextField();
        bFiltrar = new JButton();
        bVaciarFiltro = new JButton();
        label4 = new JLabel();
        tfCiudad = new JTextField();
        panel2 = new JPanel();
        tfGId = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        tfGNombre = new JTextField();
        tfGCiudad = new JTextField();
        label8 = new JLabel();
        bGBuscar = new JButton();
        bGInsertar = new JButton();
        bGModificar = new JButton();
        bGEliminar = new JButton();
        bGLimpiar = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.addPropertyChangeListener(e -> TabListaProyectosPropertyChange(e));
                panel1.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- tListadoPiezas ----
                    tListadoPiezas.setAutoCreateRowSorter(true);
                    tListadoPiezas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tListadoPiezas.setEnabled(false);
                    scrollPane1.setViewportView(tListadoPiezas);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(20, 20, 830, 240);

                //---- label1 ----
                label1.setText("Filtrar");
                label1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
                panel1.add(label1);
                label1.setBounds(new Rectangle(new Point(45, 280), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("C\u00f3digo");
                panel1.add(label2);
                label2.setBounds(new Rectangle(new Point(130, 355), label2.getPreferredSize()));

                //---- label3 ----
                label3.setText("Nombre");
                panel1.add(label3);
                label3.setBounds(130, 390, 75, 16);
                panel1.add(tfId);
                tfId.setBounds(195, 350, 170, tfId.getPreferredSize().height);
                panel1.add(tfNombre);
                tfNombre.setBounds(195, 385, 170, 27);

                //---- bFiltrar ----
                bFiltrar.setText("Filtrar");
                bFiltrar.addActionListener(e -> bFiltrar(e));
                panel1.add(bFiltrar);
                bFiltrar.setBounds(430, 380, 125, bFiltrar.getPreferredSize().height);

                //---- bVaciarFiltro ----
                bVaciarFiltro.setText("Vaciar filtro");
                bVaciarFiltro.addActionListener(e -> bVaciarFiltro(e));
                panel1.add(bVaciarFiltro);
                bVaciarFiltro.setBounds(430, 415, 125, bVaciarFiltro.getPreferredSize().height);

                //---- label4 ----
                label4.setText("Ciudad");
                panel1.add(label4);
                label4.setBounds(130, 425, 75, 16);
                panel1.add(tfCiudad);
                tfCiudad.setBounds(195, 420, 170, 27);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Listado de Proyectos", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(tfGId);
                tfGId.setBounds(310, 75, 195, tfGId.getPreferredSize().height);

                //---- label5 ----
                label5.setText("C\u00f3digo de proyecto");
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(125, 80), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Nombre");
                panel2.add(label6);
                label6.setBounds(125, 145, 127, 16);
                panel2.add(tfGNombre);
                tfGNombre.setBounds(235, 140, 275, 27);
                panel2.add(tfGCiudad);
                tfGCiudad.setBounds(235, 205, 275, 27);

                //---- label8 ----
                label8.setText("Ciudad");
                panel2.add(label8);
                label8.setBounds(125, 210, 127, 16);

                //---- bGBuscar ----
                bGBuscar.setText("Buscar");
                bGBuscar.addActionListener(e -> bGBuscar(e));
                panel2.add(bGBuscar);
                bGBuscar.setBounds(new Rectangle(new Point(530, 75), bGBuscar.getPreferredSize()));

                //---- bGInsertar ----
                bGInsertar.setText("Insertar");
                bGInsertar.addActionListener(e -> bGInsertar(e));
                panel2.add(bGInsertar);
                bGInsertar.setBounds(new Rectangle(new Point(150, 290), bGInsertar.getPreferredSize()));

                //---- bGModificar ----
                bGModificar.setText("Modificar");
                bGModificar.addActionListener(e -> bGModificar(e));
                panel2.add(bGModificar);
                bGModificar.setBounds(250, 290, 106, 27);

                //---- bGEliminar ----
                bGEliminar.setText("Eliminar");
                bGEliminar.addActionListener(e -> bGEliminar(e));
                panel2.add(bGEliminar);
                bGEliminar.setBounds(375, 290, 81, 27);

                //---- bGLimpiar ----
                bGLimpiar.setText("Limpiar");
                bGLimpiar.addActionListener(e -> bGLimpiar(e));
                panel2.add(bGLimpiar);
                bGLimpiar.setBounds(470, 290, 81, 27);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Gesti\u00f3n de Proyectos", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(5, 10, 865, 500);

        contentPane.setPreferredSize(new Dimension(890, 530));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable tListadoPiezas;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField tfId;
    private JTextField tfNombre;
    private JButton bFiltrar;
    private JButton bVaciarFiltro;
    private JLabel label4;
    private JTextField tfCiudad;
    private JPanel panel2;
    private JTextField tfGId;
    private JLabel label5;
    private JLabel label6;
    private JTextField tfGNombre;
    private JTextField tfGCiudad;
    private JLabel label8;
    private JButton bGBuscar;
    private JButton bGInsertar;
    private JButton bGModificar;
    private JButton bGEliminar;
    private JButton bGLimpiar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
