package com.example.netflix.Director;

import com.example.netflix.Title.Title;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Valid
@Table(name="director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id cannot be null")
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<Title> titles;

    public Director(String name) {
        this.name = name;
    }

    public Director() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director actor = (Director) o;
        return id == actor.id && name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
