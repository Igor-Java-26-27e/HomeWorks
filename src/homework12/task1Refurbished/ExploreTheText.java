package homework12.task1Refurbished;

import java.util.*;

public class ExploreTheText {

    static String text = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
            "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
            "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, " +
            "looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, " +
            "and going through the cites of the word in classical literature, discovered the undoubtable source.";

    public static void main(String[] args) {
        String[]words =text.toLowerCase().split("\\W"); // "\\W" = Reguliarnoe virojenie
        Set<String> setWords = new HashSet<>(Arrays.asList(words)); // "Arrays.asList()" transforma Masivul in lista
        System.out.println(setWords);

        Map<String, Integer> mapWords = new HashMap<>();
        for (String word : words){
            Integer count = mapWords.getOrDefault(word, 0);
            mapWords.put(word, count+1);
        }
        System.out.println(mapWords);
    }

}
// Метод getOrDefault(Object key, V defaultValue) интерфейса Map ,
// реализованный классом HashMap , используется для получения значения,
// сопоставленного с указанным ключом. Если значение не сопоставлено с
// предоставленным ключом, возвращается значение по умолчанию.

/*
Параметры: этот метод принимает два параметра:
ключ: это ключ элемента, значение которого необходимо получить.
defaultValue: это значение по умолчанию , которое должно быть возвращено,
если никакое значение не сопоставлено с указанным ключом.
Возвращаемое значение: этот метод возвращает значение, сопоставленное с указанным ключом,
в противном случае возвращается значение по умолчанию .
*/
