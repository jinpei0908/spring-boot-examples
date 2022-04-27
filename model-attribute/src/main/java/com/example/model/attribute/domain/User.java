package com.example.model.attribute.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class User {

    private Long id;

    private String name;

    private /* @Pattern(regexp = "[A-z]+") これはエラーになる */ String[] favoriteMovies;

    private List<@Pattern(regexp = "[A-z]+") String> favoriteArtists;

    private List<@Range(min = 1, max = 100) Long> friendIds;
}
