package com.makarevich.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="COMMENT")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Size(min=3, max=500)
        @Column(name = "text", nullable = false)
        private String text;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof Comment))
                return false;
            Comment other = (Comment) obj;
            if (id != other.id)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Comment [id=" + id + ", text=" + text + "]";
        }

}
