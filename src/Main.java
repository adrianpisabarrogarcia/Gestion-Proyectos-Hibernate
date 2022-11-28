
import controller.hibernate.InsertData;
import view.PantallaPrincipalView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Cargamos la primera vez los primeros datos de la base de datos
        /*InsertData.insertProveedores();
        InsertData.insertPiezas();
        InsertData.insertProyectos();
        InsertData.insertGestion();*/

        //Iniciamos con la pantalla principal
        PantallaPrincipalView pantallaPrincipalView = new PantallaPrincipalView();
        pantallaPrincipalView.setVisible(true);
        pantallaPrincipalView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}