package edu.dam.sondas.persistance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalaDTO {
    @JsonProperty
    private int numSala;
    @JsonProperty
    private double limiteTemperatura;
    @JsonProperty
    private int orientacion;
    @JsonProperty
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SalaDTO salaDTO = (SalaDTO) o;
        return getNumSala() == salaDTO.getNumSala();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumSala());
    }
}
