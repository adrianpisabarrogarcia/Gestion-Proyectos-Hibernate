package model;

import javax.persistence.*;

@Entity
@Table(name = "proyectos", schema = "gestionproyectos")
public class ProyectosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Basic
    @Column(name = "ciudad", nullable = true, length = 40)
    private String ciudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Proyecto {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }

    public Object[] toArray() {
        return new Object[]{Integer.toString(id), nombre, ciudad};
    }

    public static String[] getColumns() {
        return new String[]{"ID", "Nombre", "Ciudad"};
    }
}
