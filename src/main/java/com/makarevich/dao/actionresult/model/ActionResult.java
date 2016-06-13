package com.makarevich.dao.actionresult.model;

import com.makarevich.dao.action.model.Action;

import javax.persistence.*;

@Entity
@Table(name="ACTIONRESULT")
public class ActionResult {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "code", nullable = false)
        private String code;

        @Column(name = "status", nullable = true)
        private Byte status;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "action")
        private Action action;

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

        public  String getCode(){return code;}

        public  void setCode(String code){this.code= code;}

        public  Byte getStatus(){return status;}

        public  void setStatus(Byte status){this.status= status;}

        public Action getAction() {   return  action;     }

        public void setAction(Action action) {   this.action = action;     }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof ActionResult))
                return false;
            ActionResult other = (ActionResult) obj;
            if (id != other.id)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Comment [id=" + id + ", name=" + name + ", code="+code+"]";
        }



}
