package com.makarevich.dao.match.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SET")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="idRally", fetch = FetchType.LAZY)
    private List<Rally> rallies = new ArrayList<Rally>();

    public Long getId() {
        return idSet;
    }

    public void setId(Long idSet) {
        this.idSet = idSet;
    }

    public List<Rally> getRallies() {
        return rallies;
    }

    public void setRallies(List<Rally> rallies) {
        this.rallies = rallies;
    }
}
