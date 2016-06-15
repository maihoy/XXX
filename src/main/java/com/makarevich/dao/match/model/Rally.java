package com.makarevich.dao.match.model;


import com.makarevich.dao.player.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Rally {

    private Long id;
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
