package singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EagerSingleton {

    private String[] LETTERS = {"a", "b", "c", "d", "e"};
    private List<String> data = Arrays.asList(LETTERS);

    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }

    //constructor is private because we don't wanna use word (new) to init an instance
    private EagerSingleton() {
        Collections.shuffle(data);
    }

    public void printData(){
        for (String item: data)
            System.out.printf("%s ", item);
        System.out.println();
    }
}
