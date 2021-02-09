package observer;

public class Exec {

    public static void main(String[] args) {
        //instance of the product
        Product phone = new Product("OnePlus Phone");

        //person observable
        Person ahmed = new Person("Ahmed");
        Person mohammed = new Person("Mohammed");
        Person ali = new Person("Ali");

        //add the observers
        phone.addObserver(ahmed);
        phone.addObserver(mohammed);
        phone.addObserver(ali);


        for(int i = 0; i < 5; i++) {
            //example of removing observer
            if (i == 2) {
                phone.removeObserver(ahmed);
            }

            //set availability based on the i value (just for demo)
            boolean available = i % 2 == 0;
            phone.setAvailability(available);

            //simple delay for printing out the data.
            try { Thread.sleep(1000); } catch (InterruptedException ie){}

            System.out.println("--------------------------------");
        }
    }
}
