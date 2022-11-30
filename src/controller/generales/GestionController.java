package controller.generales;

import controller.hibernate.Utils;
import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GestionController {
    public static GestionEntity getProveedorPiezaProyecto(int idPieza, int idProveedor, int idProyecto) {
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, "idpieza = " + idPieza + " AND idproveedor = " + idProveedor + " AND idproyecto = " + idProyecto);
        for (Object object : objects) {
            return (GestionEntity) object;
        }
        return null;
    }

    public static ArrayList<PiezasEntity> getGestionFilterByProveedorToPiezas(int idProveedor) {
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, " idproveedor = " + idProveedor);
        ArrayList<PiezasEntity> piezas = new ArrayList<>();
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            PiezasEntity pieza = PiezasController.getPieza(gestionEntity.getIdpieza().getId());
            piezas.add(pieza);
        }
        return piezas;
    }

    public static ArrayList<ProveedoresEntity> getGestionFilterByPizasToProveedor(int idPieza) {
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, " idpieza = " + idPieza);
        ArrayList<ProveedoresEntity> proveedores = new ArrayList<>();
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            ProveedoresEntity proveedor = ProveedoresController.getProveedor(gestionEntity.getIdproveedor().getId());
            proveedores.add(proveedor);
        }
        return proveedores;
    }

    public static ArrayList<ProyectosEntity> getGestionFilterByPizasToProyecto(int idProyecto) {
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, " idproyecto = " + idProyecto);
        ArrayList<ProyectosEntity> proyectos = new ArrayList<>();
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            ProyectosEntity proyecto = ProyectosController.getProyecto(gestionEntity.getIdproyecto().getId());
            proyectos.add(proyecto);
        }
        return proyectos;
    }

    public static ArrayList<ProyectosEntity> getGestionFilterByProveedorToProyectos(int idProveedor) {
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, " idproveedor = " + idProveedor);
        ArrayList<ProyectosEntity> proyectos = new ArrayList<>();
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            ProyectosEntity proyecto = ProyectosController.getProyecto(gestionEntity.getIdproyecto().getId());
            proyectos.add(proyecto);
        }
        return proyectos;
    }

    public static String insertarPiezaProveedorProyecto(int idPieza, int idProveedor, int idProyecto, String cantidad) {
        String accion = comprobar(cantidad);
        if (accion.equals("")){
            GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
            if(gestionEntity == null){
                gestionEntity = new GestionEntity();
                ProveedoresEntity proveedoresEntity = ProveedoresController.getProveedor(idProveedor);
                gestionEntity.setIdproveedor(proveedoresEntity);
                PiezasEntity piezasEntity = PiezasController.getPieza(idPieza);
                gestionEntity.setIdpieza(piezasEntity);
                ProyectosEntity proyectosEntity = ProyectosController.getProyecto(idProyecto);
                gestionEntity.setIdproyecto(proyectosEntity);
                gestionEntity.setCantidad(Float.parseFloat(cantidad));
                Utils.save(gestionEntity);
                return "Se ha insertado correctamente";
            }else {
                return "Ya existe una relación entre la pieza, el proveedor y el proyecto, eliminala antes.";
            }
        }
        return accion;
    }

    private static String comprobar(String cantidad) {
        String accion = "";
        try {
            Double.parseDouble(cantidad);
        } catch (NumberFormatException e) {
            accion =  "Error: La cantidad debe ser un número";
        }
        return accion;
    }

    public static String modificarPiezaProveedorProyecto(int idPieza, int idProveedor, int idProyecto, String cantidad) {
        String accion = comprobar(cantidad);
        if (accion.equals("")){
            GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
            if(gestionEntity != null){
                gestionEntity.setCantidad(Float.parseFloat(cantidad));
                Utils.update(gestionEntity);
                return "Se ha modificado correctamente";
            }else {
                return "No existe una relación entre la pieza, el proveedor y el proyecto, insertala antes.";
            }
        }
        return accion;
    }

    public static String eliminarPiezaProveedorProyecto(int idPieza, int idProveedor, int idProyecto) {
        GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
        if(gestionEntity != null){
            boolean eliminar = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar la relación entre la pieza, el proveedor y el proyecto?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            if (eliminar) {
                Utils.delete(gestionEntity);
                return "Se ha eliminado correctamente";
            }
            return "Se ha cancelado la eliminación";
        }else {
            return "No existe una relación entre la pieza, el proveedor y el proyecto, insertala antes.";
        }
    }

    public static String getListado() {
        String listado = "";
        List<Object> objects = Utils.getAll(GestionEntity.class);
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            PiezasEntity piezasEntity = PiezasController.getPieza(gestionEntity.getIdpieza().getId());
            ProveedoresEntity proveedoresEntity = ProveedoresController.getProveedor(gestionEntity.getIdproveedor().getId());
            ProyectosEntity proyectosEntity = ProyectosController.getProyecto(gestionEntity.getIdproyecto().getId());
            listado += "ID: " + gestionEntity.getId() + " - Cantidad: " + gestionEntity.getCantidad() + " - " + piezasEntity.toString() + " - " + proveedoresEntity.toString() + " - " + proyectosEntity.toString() + "\n\n";

        }
        return listado;
    }


}
