package com.app;

import com.app.bean.ZipRange;
import com.app.comparator.ZipRangeComparator;
import com.app.controller.MinZipRangeGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        MinZipRangeGenerator minZipRangeGenerator = new MinZipRangeGenerator();
        List<ZipRange> validZipRangeList = minZipRangeGenerator.validateZipRangeString(s);
        if(validZipRangeList == null || validZipRangeList.size() == 0) {
            System.out.println("Please enter valid Zip Range(s).");
        } else {
            System.out.println(minZipRangeGenerator.generateMinZipRange(validZipRangeList));
        }
    }
}
