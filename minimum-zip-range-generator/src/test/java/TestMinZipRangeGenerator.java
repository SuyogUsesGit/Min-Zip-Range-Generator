import static org.junit.Assert.*;

import com.app.bean.ZipRange;
import com.app.controller.MinZipRangeGenerator;
import org.junit.Test;
import java.util.List;

public class TestMinZipRangeGenerator {

    private MinZipRangeGenerator minZipRangeGenerator = new MinZipRangeGenerator();

    @Test
    public void testMinZipRangeGeneratorForDuplicates() {
        String sample = "[94133,94133] [94200,94299] [94600,94699] [94600,94699]";
        List<ZipRange> zipRangeList = minZipRangeGenerator.validateZipRangeString(sample);
        List<ZipRange> outputList = minZipRangeGenerator.removeDuplicates(zipRangeList);
        assertEquals(3,outputList.size());
    }

    @Test
    public void testMinZipRangeGeneratorForInvalidString() {
        String sample = "[94133,94133] [94200,94299] [94600,94699] [94600,94699] abc";
        List<ZipRange> zipRangeList = minZipRangeGenerator.validateZipRangeString(sample);
        assertNull(zipRangeList);
    }

    @Test
    public void testMinZipRangeGeneratorSample1() {
        String sample = "[94133,94133] [94200,94299] [94600,94699]";
        List<ZipRange> zipRangeList = minZipRangeGenerator.validateZipRangeString(sample);
        List<ZipRange> outputList = minZipRangeGenerator.generateMinZipRange(zipRangeList);
        assertEquals(3,outputList.size());
    }

    @Test
    public void testMinZipRangeGeneratorSample2() {
        String sample = "[94133,94133] [94200,94299] [94226,94399]";
        List<ZipRange> zipRangeList = minZipRangeGenerator.validateZipRangeString(sample);
        List<ZipRange> outputList = minZipRangeGenerator.generateMinZipRange(zipRangeList);
        assertEquals(2,outputList.size());
    }

    @Test
    public void testMinZipRangeGeneratorSample3() {
        String sample = "[94133,94133] [94226,94399] [94200,94299]";
        List<ZipRange> zipRangeList = minZipRangeGenerator.validateZipRangeString(sample);
        List<ZipRange> outputList = minZipRangeGenerator.generateMinZipRange(zipRangeList);
        assertEquals(2,outputList.size());
    }

}
