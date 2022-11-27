/*
 * Created by JFormDesigner on Sat Nov 26 12:33:02 CET 2022
 */

package view.piezas;

import controller.proveedores.PiezasController;
import controller.proveedores.ProveedoresController;
import model.PiezasEntity;
import model.ProveedoresEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class PiezasView extends JFrame {
    public PiezasView() {
        initComponents();
        this.setTitle("Gestión de Piezas");
        // Nada más cargar la ventana, se cargan los datos de la tabla
        cargarTodasLasPiezas();
    }

    //Métodos personalizados

    private void bFiltrar(ActionEvent e) {
        String nombre = tfNombre.getText();
        String id = tfId.getText();

        ArrayList<PiezasEntity> piezas = PiezasController.filtrarPor(nombre, id);
        cargarTablaListadoPiezas(piezas);
    }

    private void bVaciarFiltro(ActionEvent e) {
        textFieldsBlanc();
        cargarTodasLasPiezas();
    }

    private void tabListaProveedoresComponentShown(ComponentEvent e) {
        cargarTodasLasPiezas();
        textFieldsBlanc();
    }

    private void textFieldsBlanc() {
        tfNombre.setText("");
        tfId.setText("");
        tfGDescripcion.setText("");
        tfGPrecio.setText("");
    }

    private void TabListaPiezasPropertyChange(PropertyChangeEvent e) {
        cargarTodasLasPiezas();
    }



    private void bGBuscar(ActionEvent e) {
        String id = tfGId.getText();
        if(!id.equals("")) {
            try {
                int intId = Integer.parseInt(id);
                PiezasEntity pieza = PiezasController.getPieza(intId);
                if(pieza != null) {
                    tfGNombre.setText(pieza.getNombre());
                    tfGPrecio.setText(Double.toString(pieza.getPrecio()));
                    tfGDescripcion.setText(pieza.getDescripcion());
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la pieza");
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
        tfGPrecio.setText("");
        tfGDescripcion.setText("");
    }

    private void bGModificar(ActionEvent e) {
        String id = tfGId.getText();
        String nombre = tfGNombre.getText();
        String precio = tfGPrecio.getText();
        String descripcion = tfGDescripcion.getText();

        String acciones = PiezasController.updatePieza(id, nombre, precio, descripcion);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Pieza modificada correctamente");
            vaciarbG();
        } else {
            JOptionPane.showMessageDialog(null, acciones);
        }
    }
    private void bGInsertar(ActionEvent e) {
        String nombre = tfGNombre.getText();
        String precio = tfGPrecio.getText();
        String descripcion = tfGDescripcion.getText();

        String acciones = PiezasController.insertPieza(nombre, precio, descripcion);
        if (acciones.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Pieza insertada correctamente");
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
                String acciones = PiezasController.deletePieza(intId);
                if (acciones.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Piza eliminada correctamente");
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
     * Carga todas las piezas pasadas por parámetro a la tabla.
     * @param piezas
     */
    private void cargarTablaListadoPiezas(ArrayList<PiezasEntity> piezas) {
        Object[][] data = new Object[piezas.size()][PiezasEntity.getColumns().length];
        for (int i = 0; i < piezas.size(); i++) {
            PiezasEntity pieza = piezas.get(i);
            data[i] = pieza.toArray();
        }

        tListadoPiezas.setModel(new javax.swing.table.DefaultTableModel(
                data,
                PiezasEntity.getColumns()
        ));
    }

    /**
     * Carga todos las piezas de la base de datos a la tabla,
     * nada más incializar el componente de piezas.
     */
    private void cargarTodasLasPiezas(){
        // Cargamos todos los proveedores
        ArrayList<PiezasEntity> piezas = PiezasController.getPiezas();
        cargarTablaListadoPiezas(piezas);
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
        panel2 = new JPanel();
        tfGId = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        tfGNombre = new JTextField();
        tfGPrecio = new JTextField();
        tfGDescripcion = new JTextField();
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
                panel1.addPropertyChangeListener(e -> TabListaPiezasPropertyChange(e));
                panel1.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentShown(ComponentEvent e) {
                    }
                });
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
                bFiltrar.setBounds(430, 355, 125, bFiltrar.getPreferredSize().height);

                //---- bVaciarFiltro ----
                bVaciarFiltro.setText("Vaciar filtro");
                bVaciarFiltro.addActionListener(e -> {
			bVaciarFiltro(e);
		});
                panel1.add(bVaciarFiltro);
                bVaciarFiltro.setBounds(430, 385, 125, bVaciarFiltro.getPreferredSize().height);

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
            tabbedPane1.addTab("Listado de Piezas", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(tfGId);
                tfGId.setBounds(310, 75, 195, tfGId.getPreferredSize().height);

                //---- label5 ----
                label5.setText("C\u00f3digo de pieza");
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(125, 80), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Nombre");
                panel2.add(label6);
                label6.setBounds(125, 125, 127, 16);
                panel2.add(tfGNombre);
                tfGNombre.setBounds(230, 120, 275, 27);
                panel2.add(tfGPrecio);
                tfGPrecio.setBounds(230, 165, 275, 27);
                panel2.add(tfGDescripcion);
                tfGDescripcion.setBounds(230, 210, 275, 27);

                //---- label7 ----
                label7.setText("Precio");
                panel2.add(label7);
                label7.setBounds(125, 170, 127, 16);

                //---- label8 ----
                label8.setText("Descripci\u00f3n");
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
            tabbedPane1.addTab("Gesti\u00f3n de Piezas", panel2);
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
    private JPanel panel2;
    private JTextField tfGId;
    private JLabel label5;
    private JLabel label6;
    private JTextField tfGNombre;
    private JTextField tfGPrecio;
    private JTextField tfGDescripcion;
    private JLabel label7;
    private JLabel label8;
    private JButton bGBuscar;
    private JButton bGInsertar;
    private JButton bGModificar;
    private JButton bGEliminar;
    private JButton bGLimpiar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
