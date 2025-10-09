package edu.dam.sondas.persistance.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dam.sondas.persistance.entity.SalaDTO;
import edu.dam.sondas.persistance.entity.SondaDTO;
import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SondasDataAccess {
    private List<SondaDTO> sondas;
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<SondaDTO> getSondas(String fileName) {
        List<SondaDTO> sondas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length == 9) {
                    SondaDTO sonda = new SondaDTO(
                            Integer.parseInt(values[0]),
                            Double.parseDouble(values[1]),
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3])
                    );
                    sondas.add(sonda);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sondas;
    }

    public void toJson(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException();

        mapper.writeValue(file, sondas);
    }

    public void getFromJson(String fileName) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            mapper.writeValue(file, new ArrayList<>());
        }

        this.sondas = mapper.readValue(
                file,
                mapper.getTypeFactory().constructCollectionType(List.class, SalaDTO.class)
        );
    }


    public List<SondaDTO> getByDateRange(int from, int to) {
        List<SondaDTO> elements = this.sondas.stream().filter(elem ->
                elem.getData() >= from && elem.getData() <= to
        ).toList();
        return elements;
    }


    public List<SondaDTO> getByRoom(int numSala) {
        List<SondaDTO> elements = this.sondas.stream().filter(elem ->
                elem.getNumSala() == numSala
        ).toList();
        return elements;
    }


    public List<SondaDTO> minAndMax() {
        List<SondaDTO> elements = new ArrayList<>();
        for (SondaDTO item : sondas) {
            // nose me ocurrió como
        }
        return null;
    }


    public List<SondaDTO> getByTipoSala(char tipoSala, List<SalaDTO> salas) throws ExecutionControl.NotImplementedException {
        List<SondaDTO> sondas = new ArrayList<>();
        List<SalaDTO> salasDelTipo = salas.stream().filter(sala ->
                sala.getNome().charAt(0) == tipoSala
        ).toList();

        for (SalaDTO sala : salasDelTipo) {
            Collection<SondaDTO> aux = this.sondas.stream()
                    .filter(sonda -> sonda.getNumSala() == sala.getNumSala()).toList();
            sondas.addAll(aux);
        }
        return sondas;
    }
    public List<SondaDTO> getBySurpassedTemperature(List<SalaDTO> salas) {
        List<SondaDTO> sondas = new ArrayList<>();
        return;
    }


}
