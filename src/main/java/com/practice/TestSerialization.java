package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialization {

    public static void main(String[] args) {

        Demo original = new Demo();
        System.out.println("Before Serialization: " + original);

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("demo.ser"))) {
            out.writeObject(original);
            System.out.println("Object serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Change static value to see effect
        Demo.a = 999;

        // Deserialize
        Demo deserialized = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("demo.ser"))) {
            deserialized = (Demo) in.readObject();
            System.out.println("Object deserialized");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("After Deserialization: " + deserialized);
    }
}
