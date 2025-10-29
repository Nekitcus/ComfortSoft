package com.example.comfortsoft.service.impl;

import com.example.comfortsoft.exception.ApiException;
import com.example.comfortsoft.service.XlsxAnalyzerService;
import com.example.comfortsoft.util.ExcelReader;
import com.example.comfortsoft.util.QuickSelect;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XlsxAnalyzerServiceImpl implements XlsxAnalyzerService {

    private final ExcelReader excelReader;

    private final QuickSelect quickSelect;

    @Override
    public int findNthSmallestFromFile(String filePath, int n) {
        List<Integer> numbers = excelReader.readNumbers(filePath);

        if (numbers.isEmpty()) {
            throw new ApiException("File is empty or does not contain numbers");
        }
        if (n < 1 || n > numbers.size()) {
            throw new ApiException("Incorrect value of N: " + n);
        }

        return quickSelect.findNthSmallest(numbers, n);
    }
}
