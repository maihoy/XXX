package com.makarevich.dao.match.model;

import java.util.ArrayList;
import java.util.List;

public class Set {

    private Long id;
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
