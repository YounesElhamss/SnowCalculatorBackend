package com.example.programmeringseksamen.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CykelRytter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cykel_rytter_id")
    private Long id;

    private String name;

    @Column(name = "hold_id", insertable = false, updatable = false)
    private Long holdId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hold_id")
    private Hold hold;
}