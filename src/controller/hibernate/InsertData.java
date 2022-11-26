package controller.hibernate;

import model.ProveedoresEntity;

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


}
