package com.example.demo.review.repository;

import com.example.demo.review.entiry.ReviewEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReviewRepository {
    private static final Map<Integer, ReviewEntity> store = new HashMap<>();

    private Integer nextId() {
        return store.size();
    }

    public ReviewEntity save(ReviewEntity review) {
        if (review.getId() == null) review.setId(nextId());

        store.put(review.getId(), review);
        return review;
    }

    public Optional<ReviewEntity> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<ReviewEntity> findAll() {
        return store.values().stream().toList();
    }
}
