package edu.dam.sondas.app;

import edu.dam.sondas.persistance.entity.SalaDTO;
import edu.dam.sondas.persistance.impl.SalasDataAccess;
import edu.dam.sondas.persistance.impl.SondasDataAccess;

import java.util.List;

public class App {
    public static void main(String[] args) {
        final String jsonFileName = "medicions.json";
        try {
            SondasDataAccess sondas = new SondasDataAccess(SondasDataAccess.getSondas("medicions.csv"));
            List<SalaDTO> salas = SalasDataAccess.getSalas("salas.json");
            sondas.toJson(jsonFileName);



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
