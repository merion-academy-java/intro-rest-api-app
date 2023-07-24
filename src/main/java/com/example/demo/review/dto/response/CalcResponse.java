package com.example.demo.review.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalcResponse {
    private Double reviewAvg;
    private Integer sum;
    private Integer count;
}
