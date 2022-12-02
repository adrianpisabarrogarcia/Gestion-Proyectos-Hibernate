
import controller.hibernate.InsertData;
import view.PantallaPrincipalView;

import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

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