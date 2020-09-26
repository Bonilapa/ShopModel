/*
 * Class of Customer entity with its behavior
 * that extends behavior of class Person
 */
public class Customer extends Person{

    /*
     * Class constructor with only name initiation
     */
    public Customer(String name) {
        super(name);
    }

    /*
     * Class constructor with full initialization
     */
    public Customer(String name, int age, int gender) {
        super(name, age, gender);
    }
}