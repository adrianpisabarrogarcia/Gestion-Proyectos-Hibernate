package model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "gestion", schema = "gestionproyectos")
public class GestionEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idproveedor", nullable = false)
    private ProveedoresEntity idproveedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idpieza", nullable = false)
    private PiezasEntity idpieza;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idproyecto", nullable = false)
    private ProyectosEntity idproyecto;

    @Column(name = "cantidad")
    private Float cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProveedoresEntity getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(ProveedoresEntity idproveedor) {
        this.idproveedor = idproveedor;
    }

    public PiezasEntity getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(PiezasEntity idpieza) {
        this.idpieza = idpieza;
    }

    public ProyectosEntity getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(ProyectosEntity idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "GestionEntity{" +
                "id=" + id +
                ", proveedor=" + idproveedor +
                ", pieza=" + idpieza +
                ", proyecto=" + idproyecto +
                ", cantidad=" + cantidad +
                '}';
    }
}