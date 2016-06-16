package com.makarevich.dao.match.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="RALLY")
public class Rally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="id")
    private List<RallyItem> items = new ArrayList<RallyItem>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RallyItem> getItems() {
        return items;
    }

    public void setItems(List<RallyItem> items) {
        this.items = items;
    }
}
