package com.makarevich.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="PLAYER")

public class Player {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Size(min=3, max=150)
        @Column(name = "name", nullable = false)
        private String name;

        @Size(min=3, max=150)
        @Column(name = "surname", nullable = false)
        private String surname;

        // @Size(min=0, max=250)
        @Column(name = "team", nullable = false)
        private int team;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {  return surname;  }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getTeam() {   return team;     }

        public void setTeam(int team) {   this.team = team;     }



        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof Player))
                return false;
            Player other = (Player) obj;
            if (id != other.id)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Player [id=" + id + ", name=" + name + ", surname="
                    + surname + ", team=" + team +"]";
        }
    }
