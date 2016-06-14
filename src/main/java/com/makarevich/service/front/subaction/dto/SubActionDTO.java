package com.makarevich.service.front.subaction.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SubActionDTO {

        private Long id;

        @NotNull
        @Size(min= 1, max = 100)
        private String name;

        @NotNull
        @Size(min= 1, max = 100)
        private String code;

        private Long action;

        private String actionName;

        public SubActionDTO() {
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


