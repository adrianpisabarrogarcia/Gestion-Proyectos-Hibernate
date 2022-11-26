/*
 * Created by JFormDesigner on Sat Nov 26 12:33:02 CET 2022
 */

package view.proveedores;

import java.awt.event.*;
import java.beans.*;

import controller.proveedores.ProveedoresController;
import model.ProveedoresEntity;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author unknown
 */
public class ProveedoresView extends JFrame {
    public ProveedoresView() {
        initComponents();
        this.setTitle("Gestión de Proveedores");
    }

    private void bFiltrar(ActionEvent e) {
        String nombre = tfNombre.getText();
        String id = tfId.getText();
        String direccion = tfDireccion.getText();

        ArrayList<ProveedoresEntity> proveedores = ProveedoresController.filtrarPor(nombre, id, direccion);
        cargarTablaListadoProveedores(proveedores);
    }

    private void bVaciarFiltro(ActionEvent e) {
        textFieldsBlanc();
        cargarTodosLosProveedores();
    }

    private void tabListaProveedoresComponentShown(ComponentEvent e) {
        cargarTodosLosProveedores();
        textFieldsBlanc();
    }

    private void textFieldsBlanc() {
        tfNombre.setText("");
        tfId.setText("");
        tfDireccion.setText("");
    }

    private void TabListaProveedoresPropertyChange(PropertyChangeEvent e) {
        cargarTodosLosProveedores();
    }



    private void bGBuscar(ActionEvent e) {
        String id = tfGId.getText();
        if(!id.equals("")) {
            try {
                int intId = Integer.parseInt(id);
                ProveedoresEntity proveedor = ProveedoresController.getProveedor(intId);
                if(proveedor != null) {
                    tfGNombre.setText(proveedor.getNombre());
                    tfGApellidos.setText(proveedor.getApellidos());
                    tfGDireccion.setText(proveedor.getDireccion());
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el proveedor");
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Código no válido");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Introduce un código para poder buscar");
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void bGLimpiar(ActionEvent e) {
        vaciarbG();
    }

    private void vaciarbG(){
        tfGId.setText("");
        tfGNombre.setText("");
        tfGApellidos.setText("");
        tfGDireccion.setText("");
    }

    private void bGModificar(ActionEvent e) {
        String id = tfGId.getText();
        String nombre = tfGNombre.getText();
        String apellidos = tfGApellidos.getText();
        String direccion = tfGDireccion.getText();

        String acciones = ProveedoresController.updateProveedor(id, nombre, apellidos, direccion);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente");
            vaciarbG();
        } else {
            JOptionPane.showMessageDialog(null, acciones);
        }
    }

    private void tabListadoProveedoresComponentShown(ComponentEvent e) {
        // TODO add your code here
    }

    private void panel1ComponentShown(ComponentEvent e) {
        // TODO add your code here
    }

    private void bGInsertar(ActionEvent e) {
        String nombre = tfGNombre.getText();
        String apellidos = tfGApellidos.getText();
        String direccion = tfGDireccion.getText();

        String acciones = ProveedoresController.insertProveedor(nombre, apellidos, direccion);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Proveedor insertado correctamente");
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
                String acciones = ProveedoresController.deleteProveedor(intId);
                if (acciones.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente");
                    vaciarbG();
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        tListadoProveedores = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        tfId = new JTextField();
        tfNombre = new JTextField();
        tfDireccion = new JTextField();
        bFiltrar = new JButton();
        bVaciarFiltro = new JButton();
        panel2 = new JPanel();
        tfGId = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        tfGNombre = new JTextField();
        tfGApellidos = new JTextField();
        tfGDireccion = new JTextField();
        label7 = new JLabel();
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
                panel1.addPropertyChangeListener(e -> TabListaProveedoresPropertyChange(e));
                panel1.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentShown(ComponentEvent e) {
                        panel1ComponentShown(e);
                        tabListadoProveedoresComponentShown(e);
                    }
                });
                panel1.setLayout(null);

                //======== scrollPane1 ========
                {

                    //---- tListadoProveedores ----
                    tListadoProveedores.setAutoCreateRowSorter(true);
                    tListadoProveedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    tListadoProveedores.setEnabled(false);
                    scrollPane1.setViewportView(tListadoProveedores);
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

                //---- label4 ----
                label4.setText("Direcci\u00f3n");
                panel1.add(label4);
                label4.setBounds(130, 425, 70, 16);
                panel1.add(tfId);
                tfId.setBounds(195, 350, 170, tfId.getPreferredSize().height);
                panel1.add(tfNombre);
                tfNombre.setBounds(195, 385, 170, 27);
                panel1.add(tfDireccion);
                tfDireccion.setBounds(195, 420, 170, tfDireccion.getPreferredSize().height);

                //---- bFiltrar ----
                bFiltrar.setText("Filtrar");
                bFiltrar.addActionListener(e -> bFiltrar(e));
                panel1.add(bFiltrar);
                bFiltrar.setBounds(430, 390, 125, bFiltrar.getPreferredSize().height);

                //---- bVaciarFiltro ----
                bVaciarFiltro.setText("Vaciar filtro");
                bVaciarFiltro.addActionListener(e -> {
			button1(e);
			bVaciarFiltro(e);
		});
                panel1.add(bVaciarFiltro);
                bVaciarFiltro.setBounds(430, 420, 125, bVaciarFiltro.getPreferredSize().height);

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
            tabbedPane1.addTab("Listado de Proveedores", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(tfGId);
                tfGId.setBounds(310, 75, 195, tfGId.getPreferredSize().height);

                //---- label5 ----
                label5.setText("C\u00f3digo de proveedor");
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(125, 80), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Nombre");
                panel2.add(label6);
                label6.setBounds(125, 125, 127, 16);
                panel2.add(tfGNombre);
                tfGNombre.setBounds(230, 120, 275, 27);
                panel2.add(tfGApellidos);
                tfGApellidos.setBounds(230, 165, 275, 27);
                panel2.add(tfGDireccion);
                tfGDireccion.setBounds(230, 210, 275, 27);

                //---- label7 ----
                label7.setText("Apellidos");
                panel2.add(label7);
                label7.setBounds(125, 170, 127, 16);

                //---- label8 ----
                label8.setText("Direcci\u00f3n");
                panel2.add(label8);
                label8.setBounds(125, 215, 127, 16);

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
            tabbedPane1.addTab("Gesti\u00f3n de Proveedores", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(5, 10, 865, 500);

        contentPane.setPreferredSize(new Dimension(890, 555));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        // Nada más cargar la ventana, se cargan los datos de la tabla
        cargarTodosLosProveedores();
    }


    //Métodos personalizados

    /**
     * Carga todos los proveedores pasados por parámetro a la tabla.
     * @param proveedores
     */
    private void cargarTablaListadoProveedores(ArrayList<ProveedoresEntity> proveedores) {
        Object[][] data = new Object[proveedores.size()][ProveedoresEntity.getColumns().length];
        for (int i = 0; i < proveedores.size(); i++) {
            ProveedoresEntity proveedor = proveedores.get(i);
            data[i] = proveedor.toArray();
        }

        tListadoProveedores.setModel(new javax.swing.table.DefaultTableModel(
                data,
                ProveedoresEntity.getColumns()
        ));
    }

    /**
     * Carga todos los proveedores de la base de datos a la tabla,
     * nada más incializar el componente de proveedores.
     */
    private void cargarTodosLosProveedores(){
        // Cargamos todos los proveedores
        ArrayList<ProveedoresEntity> proveedores = controller.proveedores.ProveedoresController.getProveedores();
        cargarTablaListadoProveedores(proveedores);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable tListadoProveedores;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField tfId;
    private JTextField tfNombre;
    private JTextField tfDireccion;
    private JButton bFiltrar;
    private JButton bVaciarFiltro;
    private JPanel panel2;
    private JTextField tfGId;
    private JLabel label5;
    private JLabel label6;
    private JTextField tfGNombre;
    private JTextField tfGApellidos;
    private JTextField tfGDireccion;
    private JLabel label7;
    private JLabel label8;
    private JButton bGBuscar;
    private JButton bGInsertar;
    private JButton bGModificar;
    private JButton bGEliminar;
    private JButton bGLimpiar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
