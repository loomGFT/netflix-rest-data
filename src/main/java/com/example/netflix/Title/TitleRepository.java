package com.example.netflix.Title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends JpaRepository<Title, Integer> {
    @Query(value = "SELECT * FROM title ORDER BT user_rating DESC, num_ratings DESC LIMIT ?1 ", nativeQuery = true)
    List<Title> findAllByRating(int topLimit);
}
