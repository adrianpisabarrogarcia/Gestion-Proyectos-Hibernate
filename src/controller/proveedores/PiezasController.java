package controller.proveedores;

import controller.hibernate.Utils;
import model.PiezasEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PiezasController {

    public static ArrayList<PiezasEntity> getPiezas() {
        List<Object> piezas = Utils.getAll(PiezasEntity.class);
        ArrayList<PiezasEntity> piezasEntity = new ArrayList<>();
        for (Object pieza : piezas) {
            piezasEntity.add((PiezasEntity) pieza);
        }
        return piezasEntity;
    }

    //aqui
    public static ArrayList<PiezasEntity> filtrarPor(String nombre, String id) {

        String where = " 1 = 1 ";
        if (!nombre.equals("")) {
            where += "AND UPPER(nombre) LIKE '%" + nombre.toUpperCase() + "%' ";
        }
        if (!id.equals("")) {
            where += "AND id = " + id + " ";
        }

        System.out.println(where);

        List<Object> objects = Utils.getAllWithWhere(PiezasEntity.class, where);
        ArrayList<PiezasEntity> piezasEntity = new ArrayList<>();
        for (Object object : objects) {
            piezasEntity.add((PiezasEntity) object);
        }

        return piezasEntity;
    }

    public static PiezasEntity getPieza(int id) {
        PiezasEntity pieza = (PiezasEntity) Utils.get(PiezasEntity.class, id);
        return pieza;
    }

    public static String updatePieza(String id, String nombre, String precio, String descripcion) {
        String accion = validarCampos(id, nombre, precio);

        if (accion.equals("")) {
            try {
                Integer idInt = Integer.parseInt(id);
                PiezasEntity pieza = getPieza(idInt);
                if(pieza != null){
                    pieza.setNombre(nombre);
                    pieza.setPrecio(Double.parseDouble(precio));
                    pieza.setDescripcion(descripcion);
                    Utils.update(pieza);
                    accion = "ok";
                } else {
                    accion += "No existe la pieza con id " + id + "\n";
                }
            } catch (NumberFormatException e) {
                accion += "Código no valido\n";
            }
        }

        return accion;
    }

    public static String insertPieza(String nombre, String precio, String descripcion) {
        String accion = validarCampos("vacioID", nombre, precio);
        if(accion.equals("")){
            PiezasEntity pieza = new PiezasEntity();
            pieza.setNombre(nombre);
            pieza.setPrecio(Double.parseDouble(precio));
            pieza.setDescripcion(descripcion);
            Utils.save(pieza);
            accion = "ok";
        }
        return accion;
    }

    public static String deletePieza(int intId) {
        PiezasEntity pieza = (PiezasEntity) Utils.get(PiezasEntity.class, intId);
        if(pieza != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres eliminar la pieza " + pieza.getNombre() + "?", "Eliminar pieza", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                Utils.delete(pieza);
                return "ok";
            }
            return "no";
        } else {
            return "No existe la pieza con id " + intId;
        }
    }

    private static String validarCampos(String id, String nombre, String precio){
        String accion = "";
        if(nombre.equals("")) {
            accion += "El nombre no puede estar vacío\n";
        }
        if(nombre.length() > 20) {
            accion += "El nombre no puede tener más de 20 caracteres\n";
        }
        if(id.equals("")){
            accion += "El id no puede estar vacío para modificar la pieza\n";
        }
        Double precioDouble;
        try {
            precioDouble = Double.parseDouble(precio);
        }catch (NumberFormatException e){
            accion += "El precio no es un número\n";
            precioDouble = 0.0;
        }
        return accion;
    }


}
