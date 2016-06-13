package com.makarevich.dao.action.model;

import javax.persistence.*;

@Entity
@Table(name="ACTION")
public class Action {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "code", nullable = false)
        private String code;

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

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof Action))
                return false;
            Action other = (Action) obj;
            if (id != other.id)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Comment [id=" + id + ", name=" + name + ", code="+code+"]";
        }


}
