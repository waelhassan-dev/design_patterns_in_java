package singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonSingleton {

    private String[] LETTERS = {"a", "b", "c", "d", "e"};
    private List<String> data = Arrays.asList(LETTERS);

    public NonSingleton() {
        Collections.shuffle(data);
    }

    public void printData(){
        for (String item: data)
            System.out.printf("%s ", item);
        System.out.println();
    }
}
