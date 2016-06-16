package com.makarevich.service.front.match.dto;


import java.util.ArrayList;
import java.util.List;

public class RallyDTO {

    private Long id;
    private List<RallyItemDTO> rallyItems = new ArrayList<RallyItemDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RallyItemDTO> getRallyItems() {
        return rallyItems;
    }

    public void setRallyItems(List<RallyItemDTO> rallyItems) {
        this.rallyItems = rallyItems;
    }
}
