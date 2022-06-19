package HomeWork3.StringVsStringBuilder;
/**
 * Java Pro. Homework #3
 * @author Igor Cijov
 * @version 19 Jun 2022
 */

public class StringVsStringBuilder {
    public static void main(String[] args) {
        final long COUNT = 512_000;

        //using String
        long startTime = System.currentTimeMillis();
        String str="";
        for (int i = 0; i < COUNT; i++) {
            str+="x";
        }
        System.out.println("String: " + (System.currentTimeMillis()- startTime));

        //using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            builder.append("x");
        }
        System.out.println("StringBuilder: " +(System.currentTimeMillis() - startTime));

        //using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer buffer= new StringBuffer();
        for (int i = 0; i < COUNT; i++) {
            buffer.append("x");
        }
        System.out.println("StringBuffer: " +(System.currentTimeMillis() - startTime));
    }
}
