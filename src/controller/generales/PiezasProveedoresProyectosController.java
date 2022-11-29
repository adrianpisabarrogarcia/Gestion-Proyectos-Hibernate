package controller.generales;

import controller.hibernate.Utils;
import model.GestionEntityPK;

public class PiezasProveedoresProyectosController {
    public static void getProveedorPiezaProyecto(String idPieza, String idProveedor, String idProyecto) {
        GestionEntityPK gestionEntityPK = new GestionEntityPK();
        gestionEntityPK.setIdproveedor(Integer.parseInt(idPieza));
        gestionEntityPK.setIdpieza(1);
        gestionEntityPK.setIdproyecto(1);
        gestionEntityPK = (GestionEntityPK) Utils.getRelation(GestionEntityPK.class, gestionEntityPK);
        return;
    }
}
