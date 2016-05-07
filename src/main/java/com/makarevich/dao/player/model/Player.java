package com.makarevich.dao.player.model;


import com.makarevich.dao.team.model.Team;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="PLAYER")

public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(name = "name", nullable = false)
        private String name;


        @Column(name = "surname", nullable = false)
        private String surname;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "team")
        private Team team;

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

        public String getSurname() {  return surname;  }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Team getTeam() {   return team;     }

        public void setTeam(Team team) {   this.team = team;     }

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