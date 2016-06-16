package com.makarevich.service.front.match.dto;


import java.util.ArrayList;
import java.util.List;

public class SetDTO {

    private Long id;
    private List<RallyDTO> rallies = new ArrayList<RallyDTO>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RallyDTO> getRallies() {
        return rallies;
    }

    public void setRallies(List<RallyDTO> rallies) {
        this.rallies = rallies;
    }
}
