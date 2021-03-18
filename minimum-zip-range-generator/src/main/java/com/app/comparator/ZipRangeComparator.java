package com.app.comparator;

import com.app.bean.ZipRange;

import java.util.Comparator;

public class ZipRangeComparator implements Comparator<ZipRange> {
    @Override
    public int compare(ZipRange o1, ZipRange o2) {
        if(o1.getLowerBound() > o2.getLowerBound()) {
            return 1;
        } else {
            return -1;
        }
    }
}
