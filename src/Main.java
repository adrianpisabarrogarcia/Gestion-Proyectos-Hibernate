
import view.PantallaPrincipalView;

public class Main {
    public static void main(String[] args) {

        //Cargamos la primera vez los primeros datos de la base de datos
        //InsertData.insertProveedores();

        //Iniciamos con la pantalla principal
        PantallaPrincipalView pantallaPrincipalView = new PantallaPrincipalView();
        pantallaPrincipalView.setVisible(true);

    }
}