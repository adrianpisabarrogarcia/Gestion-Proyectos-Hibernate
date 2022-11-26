package model;

import java.io.Serializable;
import java.util.Objects;

public class GestionEntityPK implements Serializable {
    private int idproveedor;
    private int idpieza;
    private int idproyecto;

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(int idpieza) {
        this.idpieza = idpieza;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionEntityPK that = (GestionEntityPK) o;
        return idproveedor == that.idproveedor && idpieza == that.idpieza && idproyecto == that.idproyecto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproveedor, idpieza, idproyecto);
    }
}
