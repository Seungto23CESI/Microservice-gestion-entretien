package com.inscription.entretien.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disponibilite_TBL")
public class Disponibilite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date_disponibilite;
    private String debut_disponibilite;
    private String fin_disponibilite;

}
