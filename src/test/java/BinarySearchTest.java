import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BinarySearchTest {
    private BinarySearch binarySearch = BinarySearch.create();

    @Test
    void shouldBeInSequence(){
        SearchResult result = binarySearch.search(1, new int[]{1});
        Assertions.assertTrue(result.isFound());
        Assertions.assertEquals(0, result.getPosition());
    }



}
