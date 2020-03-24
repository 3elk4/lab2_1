import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    static private BinarySearch binarySearch;
    static private int[] shortSequence;
    static private int[] longSequence;
    static private int[] emptySequence;
    static private int[] decreasingSequence;
    static private int[] duplicateSequence;

    @BeforeAll
    static void init(){
        binarySearch = BinarySearch.create();
        shortSequence = new int[]{1};
        longSequence = new int[]{1, 2, 3, 4, 5};
        emptySequence = new int[]{};
        decreasingSequence = new int[]{5, 4, 3, 2, 1};
        duplicateSequence = new int[]{5, 5, 5, 5, 5};
    }

    @Test
    void shouldBeInSequence(){
        int key = 1;
        SearchResult result = binarySearch.search(key, shortSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound());
        MatcherAssert.assertThat("Key is 1", shortSequence[result.getPosition()] == key);
    }

    @Test
    void shouldBeNotInSequence(){
        int key = 2;
        SearchResult result = binarySearch.search(key, shortSequence);
        MatcherAssert.assertThat("Is not in sequence", !result.isFound());
        MatcherAssert.assertThat("Key is not 2", result.getPosition() == -1);
    }

    @Test
    void shouldBeFirstElementInSequence(){
        int key = 1;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound());
        MatcherAssert.assertThat("Key is first element", result.getPosition() == 0);
    }

    @Test
    void shouldBeLastElementInSequence(){
        int key = 5;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound());
        MatcherAssert.assertThat("Key is last element", result.getPosition() == longSequence.length-1);
    }

    @Test
    void shouldBeMidElementInSequence(){
        int key = 3;
        SearchResult result = binarySearch.search(key,longSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound());
        MatcherAssert.assertThat("Key is mid element", result.getPosition() == longSequence.length/2);
    }

    @Test
    void shouldBeNotInSequence2(){
        int key = 0;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is not in sequence", !result.isFound());
        MatcherAssert.assertThat("Key is not 2", result.getPosition() == -1);
    }

    @Test
    void shouldThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> binarySearch.search(5, emptySequence));
    }

}
