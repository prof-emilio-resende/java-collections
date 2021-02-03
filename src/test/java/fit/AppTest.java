package fit;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import fit.core.ListUtils;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * validate if class can sort an regular array
     */
    @Test
    public void shouldSortList()
    {
        // arrange
        List<String> names = new ArrayList<>() {{ 
            add("Emilio");
            add("Maria");
            add("José");
        }};

        List<String> expectedResult = new ArrayList<>() {{
            add("Emilio");
            add("José");
            add("Maria");
        }};

        // comparator
        Comparator<String> comp = (String one, String another) -> {
            if (one == null) return -1;
            return (one.compareTo(another));
        };

        // act
        List<String> actualResult = ListUtils.<String>sort(names, comp);

        //assert
        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }
}
