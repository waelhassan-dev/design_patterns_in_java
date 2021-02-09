package singleton;

public class Driver {

    public static void main(String[] args) {

        //TEST NOT SINGLETON (@NonSingleton)
        testNonSingleton();

        //TEST LAZY SINGLETON (@LazySingleton)
        testLazySingleton();

        //TEST EAGER SINGLETON (@EagerSingleton)
        testEagerSingleton();

        //TEST THREAD-SAFE SINGLETON (@ThreadSafeSingleton)
        testThreadSafeSingleton();
    }


    private static void testNonSingleton() {

        NonSingleton inst1 = new NonSingleton();
        NonSingleton inst2 = new NonSingleton();

        System.out.println(inst1.hashCode());
        inst1.printData();
        System.out.println(inst2.hashCode());
        inst2.printData();
    }

    private static void testLazySingleton() {

        LazySingleton inst1 = LazySingleton.getInstance();
        LazySingleton inst2 = LazySingleton.getInstance();

        System.out.println(inst1.hashCode());
        inst1.printData();
        System.out.println(inst2.hashCode());
        inst2.printData();

    }

    private static void testEagerSingleton() {

        LazySingleton inst1 = LazySingleton.getInstance();
        LazySingleton inst2 = LazySingleton.getInstance();

        System.out.println(inst1.hashCode());
        inst1.printData();
        System.out.println(inst2.hashCode());
        inst2.printData();
    }

    private static void testThreadSafeSingleton() {
        new DataPrinter().start();

        new DataPrinter().start();

    }

}


/**
 * Dummy Thread that calls the getInstance and printData method
 */
class DataPrinter extends Thread {

    @Override
    public void run() {
        ThreadSafeSingleton.getInstance().printData();
    }
}
