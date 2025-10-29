package com.example.comfortsoft.util;

import com.example.comfortsoft.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ExcelReader {

    private static final int MAX_NUMBERS = 1000000;

    public List<Integer> readNumbers(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new ApiException("File not found: " + filePath);
        }

        List<Integer> numbers = new ArrayList<>();


        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (numbers.size() >= MAX_NUMBERS) {
                    throw new ApiException("Too much numbers in file (max: " + MAX_NUMBERS + ")");
                }
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }

        } catch (Exception e) {
            log.error("Error reading XLSX-file: {}", e.getMessage());
            throw new ApiException("Error reading file: " + e.getMessage());
        }

        return numbers;
    }

}
