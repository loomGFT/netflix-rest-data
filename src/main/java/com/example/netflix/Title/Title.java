package com.example.netflix.Title;

import com.example.netflix.Actor.Actor;
import com.example.netflix.Category.Category;
import com.example.netflix.Director.Director;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Valid
@Table(name = "title")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id cannot be null")
    private int id;


    @NotEmpty(message = "show_id cannot be empty")
    private String show_id;

    @NotEmpty(message = "type cannot be empty")
    private String type;

    @NotEmpty(message = "title cannot be empty")
    private String title;

    private String country;

    private Date date_added;

    @Range(min = 1, max = 2022, message = "release_year must be lower or equal to 2022")
    private int release_year;

    private String rating;

    private String duration;

    private String description;

    @ManyToMany
    @JoinTable(name = "title_actor",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Actor> cast;

    @ManyToMany
    @JoinTable(name = "title_category",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Category> listed_in;

    @ManyToMany
    @JoinTable(name = "title_director",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "director_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Director> directores;

    public Title() {

    }

    public Title(int id, String show_id, String type, String title, String country, Date date_added, int release_year, String rating, String duration, String description) {
        this.id = id;
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", show_id='" + show_id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", date_added=" + date_added +
                ", release_year=" + release_year +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return id == title1.id && release_year == title1.release_year && show_id.equals(title1.show_id) && type.equals(title1.type) && title.equals(title1.title) && Objects.equals(country, title1.country) && Objects.equals(date_added, title1.date_added) && Objects.equals(rating, title1.rating) && Objects.equals(duration, title1.duration) && Objects.equals(description, title1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, show_id, type, title, country, date_added, release_year, rating, duration, description);
    }
}
