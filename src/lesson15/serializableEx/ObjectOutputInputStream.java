package lesson15.serializableEx;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.Arrays;

public class ObjectOutputInputStream {
    public static void main(String[] args) {
        byte[] byteCat = null;
        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)){
            Cat catOut = new Cat("Barsik");
            objOut.writeObject(catOut);
            byteCat = barrOut.toByteArray();
            System.out.println("Cat before serializable: " + catOut);
            System.out.println("Cat serializabled: " + Arrays.toString(byteCat));
        }catch (IOException e){
            e.printStackTrace();
        }

        try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteCat); // byte-ovi patok
        ObjectInputStream objIn = new ObjectInputStream(barrIn)){
            Cat catIn = (Cat) objIn.readObject();
            System.out.println ("Cat deserializabled: " +catIn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
