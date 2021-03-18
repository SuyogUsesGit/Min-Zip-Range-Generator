package com.app.bean;

public class ZipRange {

    private int lowerBound;
    private int upperBound;

    public ZipRange() {

    }

    public ZipRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        return "[" + this.lowerBound + "," + this.upperBound + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipRange zipRange = (ZipRange) obj;
        return this.lowerBound == zipRange.lowerBound && this.upperBound == zipRange.upperBound;
    }

}
