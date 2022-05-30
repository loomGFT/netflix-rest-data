package com.example.netflix.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "director", path = "director")
public interface DirectorRepository extends JpaRepository<Director, Integer> {
}