package edu.dam.sondas.persistance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SondaDTO {
    @JsonProperty
    private int idSonda;
    @JsonProperty
    private double temperatura;
    @JsonProperty
    private int data;
    @JsonProperty
    private int numSala;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SondaDTO sonda = (SondaDTO) o;
        return Objects.equals(getIdSonda(), sonda.getIdSonda());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdSonda());
    }
}
