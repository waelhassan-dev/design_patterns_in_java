package singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LazySingleton {

    private String[] LETTERS = {"a", "b", "c", "d", "e"};
    private List<String> data = Arrays.asList(LETTERS);

    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if(instance == null)
            instance = new LazySingleton();
        return instance;
    }

    //constructor is private because we don't wanna use word (new) to init an instance
    private LazySingleton() {
        Collections.shuffle(data);
    }

    public void printData(){
        for (String item: data)
            System.out.printf("%s ", item);
        System.out.println();
    }
}
