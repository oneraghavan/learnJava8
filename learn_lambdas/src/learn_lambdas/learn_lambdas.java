package learn_lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static org.junit.Assert.assertEquals;
public class learn_lambdas {

    @Test
    public void streamCollectFromList() throws Exception {
        List<Integer> integerList = Arrays.asList(1,2,3);

        List<Object> collectIntegerList = integerList.stream().collect(Collectors.toList());

        assertEquals(integerList,collectIntegerList);

    }

    @Test
    public void streamFromList() throws Exception {

        List<Object> collectedList = Stream.of("a", "b", "c").collect(Collectors.toList());

        assertEquals(Arrays.asList("a","b","c"),collectedList);

    }

    @Test
    public void StreamMapList() throws Exception {

        List<String> collectList = Stream.of("a", "b", "hello").map(string -> string.toUpperCase()).collect(Collectors.toList());

        assertEquals(Arrays.asList("A","B","HELLO"),collectList);
    }


    @Test
    public void streamFilterList() throws Exception {

        List<String> stringList = Arrays.asList("a","1abc","abc1");

        List<String> filteredByNumberByStart = stringList.stream().filter(value -> isDigit(value.charAt(0))).collect(Collectors.toList());

        assertEquals(Arrays.asList("a","1abc","abc1"),stringList);
        assertEquals(Arrays.asList("1abc"),filteredByNumberByStart);
    }

    @Test
    public void streamFlatMapList() throws Exception {
        List<String> stringFlatList = Stream.of(Arrays.asList("a", "b"), Arrays.asList("c", "d")).flatMap(value -> value.stream()).collect(Collectors.toList());

        assertEquals(Arrays.asList("a","b","c","d"),stringFlatList);

    }

    @Test
    public void streamMinMaxInList() throws Exception {

        List<String> stringList = Arrays.asList("fire", "air", "earth");

        Function<? super String,? extends Integer> lengthExtractor = String::length;
        String maxString = stringList.stream().max(Comparator.comparing(lengthExtractor)).get();

        String minString = stringList.stream().min(Comparator.comparing(lengthExtractor)).get();

        assertEquals("earth",maxString);
        assertEquals("air",minString);

    }

    @Test
    public void streamCountFilteredList() throws Exception {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> oddIntegers = integerList.stream().filter(value -> value % 2 != 0).collect(Collectors.toList());

        assertEquals(Arrays.asList(1,3,5),oddIntegers);
    }

    @Test
    public void streamAddIntegers() throws Exception {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        BinaryOperator<Integer> accumulator = (acc, value) -> acc + value;
        Integer summedInteger = integerList.stream().reduce(0, accumulator);

        assertEquals(new Integer(45),summedInteger);

    }

    @FunctionalInterface
    public interface ITrade {
        public Integer check(Integer a,Integer b,Integer c);
    }

    @Test
    public void test(){
        ITrade iTrade = (a,b,c) -> {return a + b+ c;};

        System.out.println( iTrade.check(3,3,3));

    }

}
