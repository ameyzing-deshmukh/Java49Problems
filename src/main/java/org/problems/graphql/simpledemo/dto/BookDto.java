package org.problems.graphql.simpledemo.dto;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Integer cost;
    private String author;
}
