package com.example.comfortsoft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class XlsxResponse {

    private int nth;

    private int value;

    private String file;
}
