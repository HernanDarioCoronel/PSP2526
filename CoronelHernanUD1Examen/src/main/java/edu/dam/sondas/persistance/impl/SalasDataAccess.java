package edu.dam.sondas.persistance.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dam.sondas.persistance.entity.SalaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SalasDataAccess {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<SalaDTO> getSalas(String fileName) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            mapper.writeValue(file, new ArrayList<>());
        }

        return mapper.readValue(
                file,
                mapper.getTypeFactory().constructCollectionType(List.class, SalaDTO.class)
        );
    }
}
