package com.makarevich.dao.match.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SET")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="id", fetch = FetchType.LAZY)
    private List<Rally> rallies = new ArrayList<Rally>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Rally> getRallies() {
        return rallies;
    }

    public void setRallies(List<Rally> rallies) {
        this.rallies = rallies;
    }
}
