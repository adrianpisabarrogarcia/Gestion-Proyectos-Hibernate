package controller.generales;

import controller.hibernate.Utils;
import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (accion.equals("")) {
            GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
            if (gestionEntity == null) {
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
            } else {
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
            accion = "Error: La cantidad debe ser un número";
        }
        return accion;
    }

    public static String modificarPiezaProveedorProyecto(int idPieza, int idProveedor, int idProyecto, String cantidad) {
        String accion = comprobar(cantidad);
        if (accion.equals("")) {
            GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
            if (gestionEntity != null) {
                gestionEntity.setCantidad(Float.parseFloat(cantidad));
                Utils.update(gestionEntity);
                return "Se ha modificado correctamente";
            } else {
                return "No existe una relación entre la pieza, el proveedor y el proyecto, insertala antes.";
            }
        }
        return accion;
    }

    public static String eliminarPiezaProveedorProyecto(int idPieza, int idProveedor, int idProyecto) {
        GestionEntity gestionEntity = getProveedorPiezaProyecto(idPieza, idProveedor, idProyecto);
        if (gestionEntity != null) {
            boolean eliminar = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar la relación entre la pieza, el proveedor y el proyecto?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            if (eliminar) {
                Utils.delete(gestionEntity);
                return "Se ha eliminado correctamente";
            }
            return "Se ha cancelado la eliminación";
        } else {
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


    public static ArrayList<String[]> numPiezasPorProyectos() {
        List<Object> objects = Utils.getQuery("SELECT p.*, ( SELECT count(*) FROM gestion g where g.idproyecto = p.id) as numpiezas, ( SELECT sum(cantidad) FROM gestion g2 WHERE g2.idproyecto = p.id ) as sumcantidad FROM proyectos p");
        ArrayList<String[]> listado = new ArrayList<>();
        for (Object object : objects) {
            Object[] row = (Object[]) object;
            String[] datos = new String[6];
            datos[0] = "" + row[0];
            datos[1] = "" + row[1];
            datos[2] = "" + row[2];
            datos[3] = "" + row[3];
            if (row[4] == null) {
                datos[4] = "0";
            } else {
                datos[4] = "" + row[4];
            }
            listado.add(datos);
        }
        return listado;
    }

    public static ArrayList<String[]> numPiezasPorProveedores() {
        List<Object> objects = Utils.getQuery("SELECT p.*, ( SELECT count(*) FROM gestion g where g.idproveedor = p.id) as numpiezas, ( SELECT sum(cantidad) FROM gestion g2 WHERE g2.idproveedor = p.id ) as sumcantidad FROM proveedores p");
        ArrayList<String[]> listado = new ArrayList<>();
        for (Object object : objects) {
            Object[] row = (Object[]) object;
            String[] datos = new String[6];
            datos[0] = "" + row[0];
            datos[1] = "" + row[1];
            datos[2] = "" + row[2];
            datos[3] = "" + row[3];
            datos[4] = "" + row[4];
            if (row[5] == null) {
                datos[5] = "0";
            } else {
                datos[5] = "" + row[5];
            }
            listado.add(datos);
        }
        return listado;
    }

    private static float getGestionFilterByProveedorToCantidad(int idProveedor) {
        float cantidad = 0;
        List<Object> objects = Utils.getAllWithWhere(GestionEntity.class, "idproveedor = " + idProveedor);
        for (Object object : objects) {
            GestionEntity gestionEntity = (GestionEntity) object;
            cantidad += gestionEntity.getCantidad();
        }
        return cantidad;
    }

    public static PiezasEntity piezaConMasCantidad() {
        List<Object> queryResult = Utils.getQuery("SELECT idpieza, MAX(cantidad) as cantidad FROM gestion g ");

        int idPieza = 0;
        for (Object object : queryResult) {
            //Get first column
            Object[] row = (Object[]) object;
            idPieza = (int) row[0];
        }
        if (idPieza != 0){
            PiezasEntity pieza = PiezasController.getPieza(idPieza);
            return pieza;
        }
        return null;
    }

    public static PiezasEntity piezaConMasProyectos() {
        List<Object> queryResult = Utils.getQuery("SELECT idpieza, COUNT( idproyecto ) AS total FROM gestion g GROUP BY idproyecto ORDER BY total DESC LIMIT 1");

        int idPieza = 0;
        for (Object object : queryResult) {
            //Get first column
            Object[] row = (Object[]) object;
            idPieza = (int) row[0];
        }
        if (idPieza != 0){
            PiezasEntity pieza = PiezasController.getPieza(idPieza);
            return pieza;
        }
        return null;
    }

    public static ProveedoresEntity proveedorConMasCantidadPiezas() {
        List<Object> queryResult = Utils.getQuery("SELECT p.*, ( SELECT sum(cantidad) FROM gestion g where g.idproveedor = p.id) as numpiezas, ( SELECT sum(cantidad) FROM gestion g2 WHERE g2.idproveedor = p.id ) as sumcantidad FROM proveedores p ORDER BY numpiezas DESC LIMIT 1");

        int idProveedor = 0;
        for (Object object : queryResult) {
            //Get first column
            Object[] row = (Object[]) object;
            idProveedor = (int) row[0];
        }
        if (idProveedor != 0){
            ProveedoresEntity proveedor = ProveedoresController.getProveedor(idProveedor);
            return proveedor;
        }
        return null;
    }

    public static ProveedoresEntity proveedorConMasProyectos() {
        List<Object> queryResult = Utils.getQuery("SELECT p.*, ( SELECT count(idproyecto) FROM gestion g where g.idproveedor = p.id) as numproyectos FROM proveedores p ORDER BY numproyectos DESC LIMIT 1");

        int idProveedor = 0;
        for (Object object : queryResult) {
            //Get first column
            Object[] row = (Object[]) object;
            idProveedor = (int) row[0];
        }
        if (idProveedor != 0){
            ProveedoresEntity proveedor = ProveedoresController.getProveedor(idProveedor);
            return proveedor;
        }
        return null;
    }

    public static ProveedoresEntity proveedorConMasPiezas() {
        List<Object> queryResult = Utils.getQuery("SELECT p.*, ( SELECT count(idpieza) FROM gestion g where g.idproveedor = p.id) as numproyectos FROM proveedores p ORDER BY numproyectos DESC LIMIT 1");

        int idProveedor = 0;
        for (Object object : queryResult) {
            //Get first column
            Object[] row = (Object[]) object;
            idProveedor = (int) row[0];
        }
        if (idProveedor != 0){
            ProveedoresEntity proveedor = ProveedoresController.getProveedor(idProveedor);
            return proveedor;
        }
        return null;
    }
}

