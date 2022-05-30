package com.example.netflix.Title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "title", path = "title")
public interface TitleRepository extends JpaRepository<Title, Integer> {
}
