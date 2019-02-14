import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StringProcess {

    public static void main(String[] args) {

        //ввод строки
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слова, разделенные пробелом: ");

        //разбиение введенной строки на массив строк по пробелу
        String[] words = in.nextLine().split(" ");

        //получение Map из массива строк и группировка по первой букве
        Map<Character, List<String>> groupedMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word.charAt(0),
                        Collectors.toList()));

        //удаление entries, содержащих менее 2х значений листе
        groupedMap.entrySet()
                .removeIf(groupList -> groupList.getValue().size() < 2);

        //сортировка значений в List
        groupedMap.values()
                .forEach(value -> value.sort(Comparator
                        .comparing(String::length).reversed().thenComparing(String::compareTo)));

        //вывод отсортированной и отгруппированной Map в определенном заданием виде
        System.out.println(groupedMap.entrySet().stream()
                .map(Object::toString)
                .sorted()
                .collect(Collectors.joining(", ", "[", "]")));

        //закрытие Scanner
        in.close();
    }
}
