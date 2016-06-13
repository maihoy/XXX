package com.makarevich.service.front.actionresult.dto;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActionResultDTO {

    private Long id;

    @NotNull
    @Size(min= 1, max = 100)
    private String name;

    @NotNull
    @Size(min= 1, max = 100)
    private String code;

    @Size(max = 1)
    private Byte status;

    private Long action;

    private String actionName;

    public ActionResultDTO() {
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

    public String getCode() {        return code;    }

    public void setCode(String code) {        this.code = code;    }

    public Byte getStatus() { return status;}

    public void setStatus(Byte status) { this.status = status; }

    public Long getAction() {
        return action;
    }

    public void setAction(Long action) {
        this.action = action;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }


}
