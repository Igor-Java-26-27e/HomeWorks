package lesson15;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class SequenceInputStreamExample {
    public static void main(String[] args) {
        List<InputStream> al = new ArrayList<>();
        try (FileInputStream in1 = new FileInputStream("1.txt");
             FileInputStream in2 = new FileInputStream("2.txt");
             FileOutputStream out = new FileOutputStream("3.txt")){
            al.add(in1);
            al.add(in2);
            Enumeration<InputStream> list = Collections.enumeration(al);
            SequenceInputStream seq = new SequenceInputStream(list); //instead (in1, in2);
            int rb = seq.read();
            while (rb != -1){
                out.write(rb);
                rb = seq.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
