package com.app.controller;

import com.app.bean.ZipRange;
import com.app.comparator.ZipRangeComparator;

import java.util.*;

public class MinZipRangeGenerator {


    public List<ZipRange> generateMinZipRange(List<ZipRange> inputList) {
        // Step 1) Remove duplicate ranges from the input of Zip Ranges
        inputList = removeDuplicates(inputList);
        // Step 2) Sort list in asccending order
        inputList.sort(new ZipRangeComparator());
        // Step 3) Create an empty list of Zip Ranges for output
        List<ZipRange> outputList = new ArrayList<>();
        for(ZipRange inputZipRange: inputList) {
            // Step 4) Add elements one by one from input list to output list
            outputList.add(inputZipRange);
            boolean removeNextElementAfterSet = false;
            ListIterator<ZipRange> outputListIterator = outputList.listIterator();
            while (outputListIterator.hasNext()) {
                ZipRange outputZipRange = outputListIterator.next();
                int inputLowerBound = inputZipRange.getLowerBound();
                int inputUpperBound = inputZipRange.getUpperBound();
                int outputLowerBound = outputZipRange.getLowerBound();
                int outputUpperBound = outputZipRange.getUpperBound();
                // Step 5) Compare the lowerbounds and upperbounds of each Zip Range from output list with the input list
                // Modify the current Zip Range from output list if the condition is satisfied
                if(inputLowerBound > outputLowerBound && inputLowerBound < outputUpperBound && outputUpperBound < inputUpperBound) {
                    outputZipRange.setLowerBound(outputLowerBound);
                    outputZipRange.setUpperBound(inputUpperBound);
                    outputListIterator.set(outputZipRange);
                    removeNextElementAfterSet = true;
                    continue;
                }
                // Step 6) Remove the next element from output list of Zip Range if the Zip Range was modified in Step 4
                if(removeNextElementAfterSet) {
                    outputListIterator.remove();
                    removeNextElementAfterSet = false;
                }

            }

        }
        return outputList;
    }


    public List<ZipRange> validateZipRangeString(String inputList) {
        // Helper method to validateZipRangeString
        // Converts String input to com.app.bean.ZipRange objects
        // Returns null if invalid input is passed
        List<ZipRange> outputList = new ArrayList<>();
        String[] zipRangeArray = inputList.split(" ");
        if(zipRangeArray.length == 0) {
            return null;
        }
        for(String zipRange: zipRangeArray) {
            if(zipRange.length() == 13) {
                StringBuilder lowerBound = new StringBuilder();
                StringBuilder upperBound = new StringBuilder();
                for(int i=1; i<6; i++) {
                    lowerBound.append(zipRange.charAt(i));
                }
                for(int i=7; i<12; i++) {
                    upperBound.append(zipRange.charAt(i));
                }
                if(lowerBound.toString().matches("[0-9]+") && upperBound.toString().matches("[0-9]+")) {
                    ZipRange theZipRange = new ZipRange(Integer.parseInt(lowerBound.toString()), Integer.parseInt(upperBound.toString()));
                    outputList.add(theZipRange);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return outputList;
    }

    public List<ZipRange> removeDuplicates(List<ZipRange> inputList) {
        // Helper method to remove duplicate com.app.bean.ZipRange objects
        List<ZipRange> outputList = new ArrayList<>();
        for(ZipRange zipRange: inputList) {
            if(!outputList.contains(zipRange)) {
                outputList.add(zipRange);
            }
        }
        return outputList;
    }


}
