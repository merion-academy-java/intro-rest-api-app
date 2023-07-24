package com.example.demo.review.controller;

import com.example.demo.review.dto.request.CreateReviewRequest;
import com.example.demo.review.dto.response.CalcResponse;
import com.example.demo.review.entiry.ReviewEntity;
import com.example.demo.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ReviewApiController {
    private final ReviewRepository repository;

    @PostMapping("/api/v1/review")
    public ReviewEntity create(@RequestBody CreateReviewRequest request) {
        ReviewEntity review = ReviewEntity.builder()
                .rating(request.getRating())
                .review(request.getReview())
                .build();

        return repository.save(review);
    }

    @GetMapping("/api/v1/review")
    public List<ReviewEntity> all() {
        return repository.findAll();
    }

    @GetMapping("/api/v1/review/avg")
    public CalcResponse avg() {
        List<ReviewEntity> all = repository.findAll();

        CalcResponse calcResponse = new CalcResponse();
        calcResponse.setCount(all.size());
        calcResponse.setSum(all.stream().mapToInt(ReviewEntity::getRating).sum());
        calcResponse.setReviewAvg(Double.valueOf(calcResponse.getSum()) / Double.valueOf(calcResponse.getCount()));

        // Пример преобразования типов на примере округления
        Double needRound = calcResponse.getReviewAvg() * 100.;
        Integer intToSign = needRound.intValue();
        Double rounded = intToSign.doubleValue() / 100;
        calcResponse.setReviewAvg(rounded);

        return calcResponse;
    }
}
