
import controller.hibernate.InsertData;
import view.PantallaPrincipal;

public class Main {
    public static void main(String[] args) {

        //Cargamos la primera vez los primeros datos de la base de datos
        //InsertData.insertProveedores();

        //Iniciamos con la pantalla principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        pantallaPrincipal.setVisible(true);

    }
}