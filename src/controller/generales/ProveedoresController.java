package controller.generales;

import controller.hibernate.Utils;
import model.PiezasEntity;
import model.ProveedoresEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresController {

    public static ArrayList<ProveedoresEntity> getProveedores() {
        List<Object> proveedores = Utils.getAll(ProveedoresEntity.class);
        ArrayList<ProveedoresEntity> proveedoresEntity = new ArrayList<>();
        for (Object proveedor : proveedores) {
            proveedoresEntity.add((ProveedoresEntity) proveedor);
        }
        return proveedoresEntity;
    }

    public static ArrayList<PiezasEntity> getPiezas() {
        List<Object> piezas = Utils.getAll(PiezasEntity.class);
        ArrayList<PiezasEntity> piezasEntity = new ArrayList<>();
        for (Object pieza : piezas) {
            piezasEntity.add((PiezasEntity) pieza);
        }
        return piezasEntity;
    }

    public static ArrayList<ProveedoresEntity> filtrarPor(String nombre, String id, String direccion) {

        String where = " 1 = 1 ";
        if (!nombre.equals("")) {
            where += "AND UPPER(nombre) LIKE '%" + nombre.toUpperCase() + "%' ";
        }
        if (!id.equals("")) {
            where += "AND id = " + id + " ";
        }
        if (!direccion.equals("")) {
            where += "AND UPPER(direccion) LIKE '%" + direccion.toUpperCase() + "%' ";
        }

        List<Object> objects = Utils.getAllWithWhere(ProveedoresEntity.class, where);
        ArrayList<ProveedoresEntity> proveedoresEntity = new ArrayList<>();
        for (Object object : objects) {
            proveedoresEntity.add((ProveedoresEntity) object);
        }

        return proveedoresEntity;
    }

    public static ProveedoresEntity getProveedor(int id) {
        ProveedoresEntity proveedor = (ProveedoresEntity) Utils.get(ProveedoresEntity.class, id);
        return proveedor;
    }

    public static String updateProveedor(String id, String nombre, String apellidos, String direccion) {
        String accion = validarCampos(id, nombre, apellidos, direccion);

        if (accion.equals("")) {
            try {
                Integer idInt = Integer.parseInt(id);
                ProveedoresEntity proveedor = getProveedor(idInt);
                if(proveedor != null){
                    proveedor.setNombre(nombre);
                    proveedor.setApellidos(apellidos);
                    proveedor.setDireccion(direccion);
                    Utils.update(proveedor);
                    accion = "ok";
                } else {
                    accion += "No existe el proveedor con id " + id + "\n";
                }
            } catch (NumberFormatException e) {
                accion += "Código no valido\n";
            }
        }

        return accion;
    }

    public static String insertProveedor(String nombre, String apellidos, String direccion) {
        String accion = validarCampos("idVacio", nombre, apellidos, direccion);
        if(accion.equals("")){
            ProveedoresEntity proveedor = new ProveedoresEntity();
            proveedor.setNombre(nombre);
            proveedor.setApellidos(apellidos);
            proveedor.setDireccion(direccion);
            Utils.save(proveedor);
            accion = "ok";
        }
        return accion;
    }

    public static String deleteProveedor(int intId) {
        ProveedoresEntity proveedor = (ProveedoresEntity) Utils.get(ProveedoresEntity.class, intId);
        if(proveedor != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres eliminar el proveedor " + proveedor.getNombre() + "?", "Eliminar proveedor", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                Utils.delete(proveedor);
                return "ok";
            }
            return "no";
        } else {
            return "No existe el proveedor con id " + intId;
        }
    }

    private static String validarCampos(String id, String nombre, String apellidos, String direccion){
        String accion = "";
        if(nombre.equals("")) {
            accion += "El nombre no puede estar vacío\n";
        }
        if(nombre.length() > 20) {
            accion += "El nombre no puede tener más de 20 caracteres\n";
        }
        if(apellidos.equals("")) {
            accion += "Los apellidos no pueden estar vacíos\n";
        }
        if (apellidos.length() > 30) {
            accion += "Los apellidos no pueden tener más de 30 caracteres\n";
        }
        if(direccion.equals("")) {
            accion += "La dirección no puede estar vacía\n";
        }
        if (direccion.length() > 40) {
            accion += "La dirección no puede tener más de 40 caracteres\n";
        }
        if(id.equals("")){
            accion += "El id no puede estar vacío para modificar el proveedor\n";
        }
        return accion;
    }

}
