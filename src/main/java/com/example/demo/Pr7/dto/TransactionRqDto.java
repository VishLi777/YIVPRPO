package com.example.demo.Pr7.dto;

import lombok.Data;

@Data
public class TransactionRqDto {

    private CardDto fromCard;
    private CardDto toCard;
    private Long sum;

}
