package com.example.demo.review.dto.request;

import lombok.Getter;

@Getter
public class CreateReviewRequest {
    private Integer rating;
    private String review;
}
