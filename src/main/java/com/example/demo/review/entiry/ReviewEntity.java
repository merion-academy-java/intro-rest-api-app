package com.example.demo.review.entiry;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewEntity {
    private Integer id;
    private Integer rating;
    private String review;
}
