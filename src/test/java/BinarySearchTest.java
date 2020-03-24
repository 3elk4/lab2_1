import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class BinarySearchTest {
    static private BinarySearch binarySearch;
    static private int[] shortSequence;
    static private int[] longSequence;
    static private int[] emptySequence;
    static private int[] decreasingSequence;
    static private int[] duplicateSequence;
    static private int[] negativeSequence;

    @BeforeAll
    static void init(){
        binarySearch = BinarySearch.create();
        shortSequence = new int[]{1};
        longSequence = new int[]{1, 2, 3, 4, 5};
        emptySequence = new int[]{};
        decreasingSequence = new int[]{5, 4, 3, 2, 1};
        duplicateSequence = new int[]{5, 5, 5, 5, 5};
        negativeSequence = new int[]{-5, -4, -3, -2, -1};
    }

    @Test
    void shouldBeInSequence(){
        int key = 1;
        SearchResult result = binarySearch.search(key, shortSequence);
        MatcherAssert.assertThat("Is not in sequence", result.isFound(), is(true));
        MatcherAssert.assertThat("Key is not 1", shortSequence[result.getPosition()], is(key));
    }

    @Test
    void shouldBeNotInSequence(){
        int key = 2;
        SearchResult result = binarySearch.search(key, shortSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound(), is(false));
        MatcherAssert.assertThat("Key is 2", result.getPosition(), is(-1));
    }

    @Test
    void shouldBeFirstElementInSequence(){
        int key = 1;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is not in sequence", result.isFound(), is(true));
        MatcherAssert.assertThat("Key is not first element", result.getPosition(), is(0));
    }

    @Test
    void shouldBeLastElementInSequence(){
        int key = 5;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is not in sequence", result.isFound(), is(true));
        MatcherAssert.assertThat("Key is not last element", result.getPosition(), is(longSequence.length-1));
    }

    @Test
    void shouldBeMidElementInSequence(){
        int key = 3;
        SearchResult result = binarySearch.search(key,longSequence);
        MatcherAssert.assertThat("Is not in sequence", result.isFound(), is(true));
        MatcherAssert.assertThat("Key is not mid element", result.getPosition(), is(longSequence.length/2));
    }

    @Test
    void shouldBeNotInSequence2(){
        int key = 0;
        SearchResult result = binarySearch.search(key, longSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound(), is(false));
        MatcherAssert.assertThat("Key is 0", result.getPosition(), is(-1));
    }

    @Test
    void shouldThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> binarySearch.search(5, emptySequence));
    }

    @Test
    void shouldBeNotInSequence3(){
        int key = 2;
        SearchResult result = binarySearch.search(key, duplicateSequence);
        MatcherAssert.assertThat("Is in sequence", result.isFound(), is(false));
        MatcherAssert.assertThat("Key is 2", result.getPosition(), is(-1));
    }

    @Test
    void shouldBeInSequence2(){
        int key = -1;
        SearchResult result = binarySearch.search(key, negativeSequence);
        MatcherAssert.assertThat("Is not in sequence", result.isFound(), is(true));
        MatcherAssert.assertThat("Key is not -1", negativeSequence[result.getPosition()], is(key));
    }



}
