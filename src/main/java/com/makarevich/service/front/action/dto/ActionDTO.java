package com.makarevich.service.front.action.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by j on 13.6.16.
 */
public class ActionDTO {

    private Long id;

    @NotNull
    @Size(min= 1, max = 100)
    private String name;

    @NotNull
    @Size(min= 1, max = 100)
    private String code;

    public ActionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
