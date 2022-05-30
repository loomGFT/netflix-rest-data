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

    @NotEmpty(message = "title cannot be empty")
    private String name;

    private String date_added;

    @Range(min = 1, max = 2022, message = "Release must be between [1, 2022]")
    private String release_year;

    private String rating;

    private String duration;

    private String description;

    private int num_ratings;

    private float user_rating;

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
    private List<Director> directors;

    public Title() {

    }

    public Title(String name, String date_added, String release_year, String rating, String duration, String description, int num_ratings, float user_rating) {
        this.name = name;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.num_ratings = num_ratings;
        this.user_rating = user_rating;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", num_ratings=" + num_ratings +
                ", user_rating=" + user_rating +
                ", cast=" + cast +
                ", listed_in=" + listed_in +
                ", directors=" + directors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return id == title.id && num_ratings == title.num_ratings && Float.compare(title.user_rating, user_rating) == 0 && Objects.equals(name, title.name) && Objects.equals(date_added, title.date_added) && Objects.equals(release_year, title.release_year) && Objects.equals(rating, title.rating) && Objects.equals(duration, title.duration) && Objects.equals(description, title.description) && Objects.equals(cast, title.cast) && Objects.equals(listed_in, title.listed_in) && Objects.equals(directors, title.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date_added, release_year, rating, duration, description, num_ratings, user_rating, cast, listed_in, directors);
    }
}
