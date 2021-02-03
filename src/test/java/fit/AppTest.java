package fit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import fit.core.AttendanceHelper;
import fit.core.ListUtils;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * validate if class can sort an regular array
     */
    @Test
    public void shouldSortList() {
        // arrange
        List<String> names = new ArrayList<>() {
            {
                add("Emilio");
                add("Maria");
                add("José");
            }
        };

        List<String> expectedResult = new ArrayList<>() {
            {
                add("Emilio");
                add("José");
                add("Maria");
            }
        };

        // comparator
        Comparator<String> comp = (String one, String another) -> {
            if (one == null)
                return -1;
            return (one.compareTo(another));
        };

        // act
        List<String> actualResult = ListUtils.<String>sort(names, comp);

        // assert
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

    @Test
    public void shouldGenerateRandomAttendanceList() {
        //arrange
        Map<String, Boolean> attendanceListExpected = new HashMap<>() {{
            put("test one", true);
            put("test two", false);
        }};
        

        //act
        Map<String, Boolean> attendanceListResult = AttendanceHelper.random(2, 50);

        //assert

        //same size (due to parameters sent to random method)
        assertEquals(attendanceListResult.size(), attendanceListResult.size());

        //same percentile of 'true' values due to parameters sent to random method
        assertEquals(
            countTrueInList(attendanceListExpected.values()),
            countTrueInList(attendanceListResult.values()));
    }

    private int countTrueInList(Collection<Boolean> items) {
        return Math.toIntExact(items.stream().filter(x -> x).count());
    }
}
