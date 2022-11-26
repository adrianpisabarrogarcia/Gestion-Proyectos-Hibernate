package model;

import javax.persistence.*;

@Entity
@Table(name = "gestion", schema = "gestionproyectos", catalog = "")
@IdClass(GestionEntityPK.class)
public class GestionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproveedor", nullable = false)
    private int idproveedor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpieza", nullable = false)
    private int idpieza;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproyecto", nullable = false)
    private int idproyecto;
    @Basic
    @Column(name = "cantidad", nullable = true, precision = 0)
    private Double cantidad;

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

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
