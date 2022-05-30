package com.example.netflix.Recommend;

import com.example.netflix.Title.Title;
import com.example.netflix.Title.TitleRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@NoArgsConstructor
@RequestMapping("/api/recommend")
public class Recommend {
    @Autowired
    private TitleRepository titleRepository;

    @GetMapping("/best")
    List<Title> bestTitles(@RequestParam(value = "top", defaultValue = "10") int qtt) {
        return titleRepository.findAllByRating(qtt);
    }


}
