package controller.hibernate;

import model.GestionEntity;
import model.PiezasEntity;
import model.ProveedoresEntity;
import model.ProyectosEntity;

public class InsertData {

    public static void insertProveedores(){
        ProveedoresEntity proveedor1 = new ProveedoresEntity();
        proveedor1.setNombre("Roberto");
        proveedor1.setApellidos("Garcia Perez");
        proveedor1.setDireccion("Calle Bravo Murillo, 123");
        Utils.save(proveedor1);

        ProveedoresEntity proveedor2 = new ProveedoresEntity();
        proveedor2.setNombre("Maria");
        proveedor2.setApellidos("Gonzalez Lopez");
        proveedor2.setDireccion("Calle Alcala, 456");
        Utils.save(proveedor2);

        ProveedoresEntity proveedor3 = new ProveedoresEntity();
        proveedor3.setNombre("Jose");
        proveedor3.setApellidos("Gomez Sanchez");
        proveedor3.setDireccion("Calle Gran Via, 789");
        Utils.save(proveedor3);

        ProveedoresEntity proveedor4 = new ProveedoresEntity();
        proveedor4.setNombre("Luis");
        proveedor4.setApellidos("Fernandez Rodriguez");
        proveedor4.setDireccion("Calle Princesa, 101");
        Utils.save(proveedor4);

        ProveedoresEntity proveedor5 = new ProveedoresEntity();
        proveedor5.setNombre("Antonio");
        proveedor5.setApellidos("Martinez Ruiz");
        proveedor5.setDireccion("Calle Alcala, 112");
        Utils.save(proveedor5);

        ProveedoresEntity proveedor6 = new ProveedoresEntity();
        proveedor6.setNombre("Juan");
        proveedor6.setApellidos("Hernandez Jimenez");
        proveedor6.setDireccion("Calle Alcala, 123");
        Utils.save(proveedor6);

        ProveedoresEntity proveedor7 = new ProveedoresEntity();
        proveedor7.setNombre("Manuel");
        proveedor7.setApellidos("Diaz Garcia");
        proveedor7.setDireccion("Calle Alcala, 134");
        Utils.save(proveedor7);

        ProveedoresEntity proveedor8 = new ProveedoresEntity();
        proveedor8.setNombre("Francisco");
        proveedor8.setApellidos("Lopez Fernandez");
        proveedor8.setDireccion("Calle Alcala, 145");
        Utils.save(proveedor8);

        ProveedoresEntity proveedor9 = new ProveedoresEntity();
        proveedor9.setNombre("Javier");
        proveedor9.setApellidos("Martinez Lopez");
        proveedor9.setDireccion("Calle Alcala, 156");
        Utils.save(proveedor9);

        ProveedoresEntity proveedor10 = new ProveedoresEntity();
        proveedor10.setNombre("Miguel");
        proveedor10.setApellidos("Gonzalez Martinez");
        proveedor10.setDireccion("Calle Alcala, 167");
        Utils.save(proveedor10);

    }

    public static void insertPiezas(){
        PiezasEntity pieza1 = new PiezasEntity();
        pieza1.setNombre("Rueda");
        pieza1.setPrecio(20);
        pieza1.setDescripcion("Rueda de 16 pulgadas");
        Utils.save(pieza1);

        PiezasEntity pieza2 = new PiezasEntity();
        pieza2.setNombre("Motor");
        pieza2.setPrecio(100);
        pieza2.setDescripcion("Motor de 1.6 litros");
        Utils.save(pieza2);

        PiezasEntity pieza3 = new PiezasEntity();
        pieza3.setNombre("Frenos");
        pieza3.setPrecio(50.60);
        pieza3.setDescripcion("Frenos de disco");
        Utils.save(pieza3);

        PiezasEntity pieza4 = new PiezasEntity();
        pieza4.setNombre("Amortiguadores");
        pieza4.setPrecio(30.50);
        pieza4.setDescripcion("Amortiguadores de gas");
        Utils.save(pieza4);

        PiezasEntity pieza5 = new PiezasEntity();
        pieza5.setNombre("Cambio");
        pieza5.setPrecio(40);
        pieza5.setDescripcion("Cambio de 5 velocidades");
        Utils.save(pieza5);

        PiezasEntity pieza6 = new PiezasEntity();
        pieza6.setNombre("Llantas");
        pieza6.setPrecio(20);
        pieza6.setDescripcion("Llantas de 16 pulgadas");
        Utils.save(pieza6);

        PiezasEntity pieza7 = new PiezasEntity();
        pieza7.setNombre("Parachoques");
        pieza7.setPrecio(30);
        pieza7.setDescripcion("Parachoques delantero");
        Utils.save(pieza7);

        PiezasEntity pieza8 = new PiezasEntity();
        pieza8.setNombre("Retrovisores");
        pieza8.setPrecio(10);
        pieza8.setDescripcion("Retrovisores exteriores");
        Utils.save(pieza8);

        PiezasEntity pieza9 = new PiezasEntity();
        pieza9.setNombre("Volante");
        pieza9.setPrecio(15);
        pieza9.setDescripcion("Volante de cuero");
        Utils.save(pieza9);

        PiezasEntity pieza10 = new PiezasEntity();
        pieza10.setNombre("Asientos");
        pieza10.setPrecio(50);
        pieza10.setDescripcion("Asientos de cuero");
        Utils.save(pieza10);

    }

    public static void insertProyectos(){
        ProyectosEntity proyecto1 = new ProyectosEntity();
        proyecto1.setNombre("Proyecto 1");
        proyecto1.setCiudad("Madrid");
        Utils.save(proyecto1);

        ProyectosEntity proyecto2 = new ProyectosEntity();
        proyecto2.setNombre("Proyecto 2");
        proyecto2.setCiudad("Barcelona");
        Utils.save(proyecto2);

        ProyectosEntity proyecto3 = new ProyectosEntity();
        proyecto3.setNombre("Proyecto 3");
        proyecto3.setCiudad("Valencia");
        Utils.save(proyecto3);

        ProyectosEntity proyecto4 = new ProyectosEntity();
        proyecto4.setNombre("Proyecto 4");
        proyecto4.setCiudad("Sevilla");
        Utils.save(proyecto4);

        ProyectosEntity proyecto5 = new ProyectosEntity();
        proyecto5.setNombre("Proyecto 5");
        proyecto5.setCiudad("Zaragoza");
        Utils.save(proyecto5);

        ProyectosEntity proyecto6 = new ProyectosEntity();
        proyecto6.setNombre("Proyecto 6");
        proyecto6.setCiudad("Malaga");
        Utils.save(proyecto6);

        ProyectosEntity proyecto7 = new ProyectosEntity();
        proyecto7.setNombre("Proyecto 7");
        proyecto7.setCiudad("Murcia");
        Utils.save(proyecto7);

        ProyectosEntity proyecto8 = new ProyectosEntity();
        proyecto8.setNombre("Proyecto 8");
        proyecto8.setCiudad("Palma de Mallorca");
        Utils.save(proyecto8);

        ProyectosEntity proyecto9 = new ProyectosEntity();
        proyecto9.setNombre("Proyecto 9");
        proyecto9.setCiudad("Las Palmas de Gran Canaria");
        Utils.save(proyecto9);

        ProyectosEntity proyecto10 = new ProyectosEntity();
        proyecto10.setNombre("Proyecto 10");
        proyecto10.setCiudad("Bilbao");
        Utils.save(proyecto10);

    }

    public static void insertGestion(){
        GestionEntity gestion1 = new GestionEntity();
        PiezasEntity pieza1 = (PiezasEntity) Utils.get(PiezasEntity.class, 1);
        ProveedoresEntity proveedor1 = (ProveedoresEntity) Utils.get(ProveedoresEntity.class, 1);
        ProyectosEntity proyecto1 = (ProyectosEntity) Utils.get(ProyectosEntity.class, 1);
        gestion1.setIdpieza(pieza1);
        gestion1.setIdproveedor(proveedor1);
        gestion1.setIdproyecto(proyecto1);
        gestion1.setCantidad(10.0F);
        Utils.save(gestion1);

    }
}
