package com.example.netflix;

import com.example.netflix.Actor.ActorRepository;
import com.example.netflix.Category.CategoryRepository;
import com.example.netflix.Director.DirectorRepository;
import com.example.netflix.Title.TitleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration //hace que se ejecute al iniciar la aplicacion
class LoadData {


    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(ActorRepository actorRepository, DirectorRepository directorRepository, CategoryRepository categoryRepository, TitleRepository titleRepository) {

        return args -> {
            log.info("Preload complete");
        };
    }
}
