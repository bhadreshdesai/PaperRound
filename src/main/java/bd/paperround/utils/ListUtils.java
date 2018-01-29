package bd.paperround.utils;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Bhadresh Desai
 */
public class ListUtils {

    private ListUtils() {

    }

    public static List<Integer> getEvenNumbers(List<Integer> list) {
        List<Integer> evenNumbers;
        evenNumbers = list.stream()
                .filter((Integer item) -> (item % 2 == 0))
                .collect(Collectors.toList());
        return evenNumbers;
    }

    public static List<Integer> getOddNumbers(List<Integer> list) {
        List<Integer> oddNumbers;
        oddNumbers = list.stream()
                .filter((Integer item) -> (item % 2 == 1))
                .collect(Collectors.toList());
        return oddNumbers;
    }

    public static boolean isOrderedList(List<Integer> list) {
        return list.equals(list.stream().sorted().collect(Collectors.toList()));
    }

    public static boolean isUnique(List<Integer> list) {
        return (list.size() == new HashSet<>(list).size());
    }
}
