package homework12.task1;

/**
 * Java Pro. Homework #12
 * @author Igor Cijov
 * @version 31 Jul 2022
 */

import java.util.*;

public class Homework12 {
    public static void main(String[] args) {
        String str = "no yes maybe later soon never call apple maybe long using web variations repeat humour words no original from maybe";
        String[] arrays = str.split(" ");
        Set<String> uniqueWords = new HashSet<String>(Arrays.asList(arrays));
        System.out.println("The list of unique words is:");
        System.out.println(uniqueWords);
        System.out.println("---------------------------------------------");
        System.out.println("Sorted list ist:");
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
        System.out.println("---------------------------------------------");
        System.out.println("Count how many times appears each word:");
        Map<String, Integer> wordCounter = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i].equals(arrays[j]))
                {
                    counter++;
                }
            }
            i += counter;
            wordCounter.put(arrays[i],counter+1);
            //System.out.println((counter==0)? arrays[i] + ":" + " appears " + (counter+1) + " time" : arrays[i] + ":" + " appears " + (counter+1) + " times");
            counter = 0;
        }
        System.out.println(wordCounter);
    }
}
