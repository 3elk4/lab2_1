import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class BinarySearchTest {
    static private BinarySearch binarySearch;
    static private int[] shortSequence;
    static private int[] longSequence;
    static private int[] emptySequence;

    @BeforeAll
    static void init(){
        binarySearch = BinarySearch.create();
        shortSequence = new int[]{1};
        longSequence = new int[]{1, 2, 3, 4, 5};
        emptySequence = new int[]{};
    }

    @Test
    void shouldBeInSequence(){
        SearchResult result = binarySearch.search(1, shortSequence);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(0, result.getPosition());
    }

    @Test
    void shouldBeNotInSequence(){
        SearchResult result = binarySearch.search(2, shortSequence);
        Assertions.assertFalse(result.isFound());
        Assertions.assertEquals(-1, result.getPosition());
    }

    @Test
    void shouldBeFirstElementInSequence(){
        SearchResult result = binarySearch.search(1, longSequence);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(0 , result.getPosition());
    }

    @Test
    void shouldBeLastElementInSequence(){
        SearchResult result = binarySearch.search(5, longSequence);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(4 , result.getPosition());
    }

    @Test
    void shouldBeMidElementInSequence(){
        SearchResult result = binarySearch.search(3,longSequence);
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(2 , result.getPosition());
    }

    @Test
    void shouldBeNotInSequence2(){
        SearchResult result = binarySearch.search(0, longSequence);
        Assertions.assertFalse(result.isFound());
        Assertions.assertEquals(-1, result.getPosition());
    }

    @Test
    void shouldThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> binarySearch.search(5, emptySequence));
    }



}
