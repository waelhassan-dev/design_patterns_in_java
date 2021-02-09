package singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadSafeSingleton {

    private String[] LETTERS = {"a", "b", "c", "d", "e"};
    private List<String> data = Arrays.asList(LETTERS);

    //volatile:: to avoid caching the object
    private static volatile ThreadSafeSingleton instance;
    private static boolean dalayMe = true;

    //solution (1)
    //synchronized:: only one thread per time, however this implementation in has negative impact to performance !
    /*
    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance == null) {
            if(dalayMe){
                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Exception Happened !");
                }
            }
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    */

    //solution (2)
    //better for performance
    public static ThreadSafeSingleton getInstance() {
        if(instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null) {
                    if(dalayMe){
                        Thread.currentThread();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println("Exception Happened !");
                        }
                    }
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }



    //constructor is private because we don't wanna use word (new) to init an instance
    private ThreadSafeSingleton() {
        Collections.shuffle(data);
    }

    public void printData(){
        for (String item: data)
            System.out.printf("%s ", item);
        System.out.println();
    }
}
