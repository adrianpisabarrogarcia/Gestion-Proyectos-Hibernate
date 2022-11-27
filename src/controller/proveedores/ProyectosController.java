package controller.proveedores;

import controller.hibernate.Utils;
import model.ProveedoresEntity;
import model.ProyectosEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectosController {

    public static ArrayList<ProyectosEntity> getProyectos() {
        List<Object> proyectos = Utils.getAll(ProyectosEntity.class);
        ArrayList<ProyectosEntity> proyectosEntity = new ArrayList<>();
        for (Object proyecto : proyectosEntity) {
            proyectosEntity.add((ProyectosEntity) proyecto);
        }
        return proyectosEntity;
    }

    public static ArrayList<ProyectosEntity> filtrarPor(String nombre, String id, String ciudad) {

        String where = " 1 = 1 ";
        if (!nombre.equals("")) {
            where += "AND UPPER(nombre) LIKE '%" + nombre.toUpperCase() + "%' ";
        }
        if (!id.equals("")) {
            where += "AND id = " + id + " ";
        }
        if (!ciudad.equals("")) {
            where += "AND UPPER(ciudad) LIKE '%" + ciudad.toUpperCase() + "%' ";
        }


        System.out.println(where);

        List<Object> objects = Utils.getAllWithWhere(ProyectosEntity.class, where);
        ArrayList<ProyectosEntity> proyectosEntities = new ArrayList<>();
        for (Object object : objects) {
            proyectosEntities.add((ProyectosEntity) object);
        }

        return proyectosEntities;
    }

    public static ProyectosEntity getProyecto(int id) {
        ProyectosEntity proyecto = (ProyectosEntity) Utils.get(ProyectosEntity.class, id);
        return proyecto;
    }

    public static String updatePryecto(String id, String nombre, String ciudad) {
        String accion = validarCampos(id, nombre, ciudad);

        if (accion.equals("")) {
            try {
                Integer idInt = Integer.parseInt(id);
                ProyectosEntity proyecto = getProyecto(idInt);
                if(proyecto != null){
                    proyecto.setNombre(nombre);
                    proyecto.setCiudad(ciudad);
                    Utils.update(proyecto);
                    accion = "ok";
                } else {
                    accion += "No existe el proyecto con id " + id + "\n";
                }
            } catch (NumberFormatException e) {
                accion += "Código no valido\n";
            }
        }

        return accion;
    }

    public static String insertProyecto(String nombre, String ciudad) {
        String accion = validarCampos("idVacio", nombre, ciudad);
        if(accion.equals("")){
            ProyectosEntity proyecto = new ProyectosEntity();
            proyecto.setNombre(nombre);
            proyecto.setCiudad(ciudad);
            Utils.save(proyecto);
            accion = "ok";
        }
        return accion;
    }

    public static String deleteProyecto(int intId) {
        ProyectosEntity proyecto = (ProyectosEntity) Utils.get(ProyectosEntity.class, intId);
        if(proyecto != null){
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres eliminar el proyecto " + proyecto.getNombre() + "?", "Eliminar proyecto", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                Utils.delete(proyecto);
                return "ok";
            }
            return "no";
        } else {
            return "No existe el proyecto con id " + intId;
        }
    }

    private static String validarCampos(String id, String nombre, String ciudad){
        String accion = "";
        if (nombre.equals("")) {
            accion += "El nombre no puede estar vacío\n";
        }
        if (nombre.length() > 40) {
            accion += "El nombre no puede tener más de 40 caracteres\n";
        }
        if (ciudad.length() > 40) {
            accion += "La ciudad no puede tener más de 40 caracteres\n";
        }
        if (id.equals("")){
            accion += "El id no puede estar vacío para modificar el proyecto\n";
        }
        return accion;
    }


}
