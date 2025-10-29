package com.example.comfortsoft.controller;

import com.example.comfortsoft.dto.XlsxResponse;
import com.example.comfortsoft.service.XlsxAnalyzerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/xlsx")
@RequiredArgsConstructor
public class XlsxController {

    private final XlsxAnalyzerService xlsxAnalyzerService;

    @GetMapping("/nth-min")
    public XlsxResponse getNthMin(@RequestParam String path, @RequestParam int n) {
        log.info("Received request: path='{}', n={}", path, n);
        int result = xlsxAnalyzerService.findNthSmallestFromFile(path, n);
        log.info("Returning N-th smallest value: {}", result);
        return new XlsxResponse(n, result, path);
    }
}
