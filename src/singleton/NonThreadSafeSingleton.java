package singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonThreadSafeSingleton {

    private String[] LETTERS = {"a", "b", "c", "d", "e"};
    private List<String> data = Arrays.asList(LETTERS);

    private static NonThreadSafeSingleton instance;
    private static boolean dalayMe = true;

    public static NonThreadSafeSingleton getInstance() {
        if(instance == null) {
            if(dalayMe){
                dalayMe = false;
                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Exception Happened !");
                }
            }
            instance = new NonThreadSafeSingleton();
        }
        return instance;
    }

    //constructor is private because we don't wanna use word (new) to init an instance
    private NonThreadSafeSingleton() {
        Collections.shuffle(data);
    }

    public void printData(){
        for (String item: data)
            System.out.printf("%s ", item);
        System.out.println();
    }
}
