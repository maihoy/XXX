package com.makarevich.dao.match.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="RALLY")
public class Rally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRally;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="idRItems")
    private List<RallyItem> items = new ArrayList<RallyItem>();

    public Long getId() {
        return idRally;
    }

    public void setId(Long idRally) {
        this.idRally = idRally;
    }

    public List<RallyItem> getItems() {
        return items;
    }

    public void setItems(List<RallyItem> items) {
        this.items = items;
    }
}
