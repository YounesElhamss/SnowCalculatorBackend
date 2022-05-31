package com.example.programmeringseksamen.domain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hold {

    //Variables/kolonner i db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hold_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hold", cascade = CascadeType.MERGE)
    @JsonBackReference(value = "cykelRyttere")
    private List<CykelRytter> cykelRyttere;


    //Getters og setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CykelRytter> getCykelRyttere() {
        return cykelRyttere;
    }

    public void setCykelRyttere(List<CykelRytter> cykelRytterId) {
        this.cykelRyttere = cykelRytterId;
    }
}