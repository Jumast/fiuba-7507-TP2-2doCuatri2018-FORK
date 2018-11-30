package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.posicion.Posicion;
import modelo.unidades.Aldeano;
import modelo.posicion.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class JuegoController implements Initializable {

    @FXML
    private Label nombreJugador1;

    @FXML
    private Label nombreJugador2;


    @FXML
    private MapaController mapaController;

    @FXML
    private BorderPane contenedorPrincipal;

    @FXML
    private Label botonera;

    private Parent vistaAldeano;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {

    }

    public void setBotonera(String text){
        this.botonera.setText("");

        GridPane contenedorBotones = new GridPane();

        // CREO LOS BOTONES
        Button botonArriba = new Button("⬆");
        Button botonArribaIzq = new Button("↖");
        Button botonArribaDer = new Button("↗");

        Button botonAbajo = new Button("⬇");
        Button botonAbajoIzq = new Button("↙");
        Button botonAbajoDer = new Button("↘");

        Button botonIzquierda = new Button("⬅");
        Button botonDerecha = new Button("➡");

        // LOS POSICIONO
        contenedorBotones.add(botonArriba,1,0);
        contenedorBotones.add(botonArribaIzq,0,0);
        contenedorBotones.add(botonArribaDer,2,0);
        contenedorBotones.add(botonAbajoIzq,0,2);
        contenedorBotones.add(botonAbajoDer,2,2);
        contenedorBotones.add(botonIzquierda,0,1);
        contenedorBotones.add(botonDerecha,2,1);
        contenedorBotones.add(botonAbajo,1,2);

        // AGREGO LOS BOTONES AL CONTENEDOR
        this.contenedorPrincipal.setCenter(contenedorBotones);
    }



}
