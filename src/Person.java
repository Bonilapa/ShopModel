/*
 * Base class for all human-being entities.
 * Base class for Customer and Consumer classes.
 *
 * Name != null
 *
 * 0 > age > 190
 */
public class Person {

    protected String name;
    protected int age;
    protected int gender;

    /*
     * Disabled default constroctor.
     * In order to prevent name NULL initialization
     */
    private Person(){

    }

    /*
     * Class constructor with check name argument on NULL
     */
    public Person(String name) {

        if(nameIsNull(name)){

            return;
        }

        this.name = name;

    }

    /*
     * Class constructor with full initizlization and
     * checks on restrictions on name and age
     */
    public Person(String name, int age, int gender) {

        if(nameIsNull(name) || !ageIsCorrect(age)){

            return;
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /*
     * Person name getter
     */
    public String getName() {

        return name;
    }

    /*
     * Person name setter
     */
    public void setName(String name) {

        if(nameIsNull(name)){

            return;
        }

        this.name = name;
    }

    /*
     * Person age getter
     */
    public int getAge() {

        return age;
    }

    /*
     * person age setter with restrictions check
     */
    public void setAge(int age) {

        if(ageIsCorrect(age)) {
            this.age = age;
        }
    }

    /*
     * Person gender getter
     */
    public int getGender() {

        return gender;
    }

    /*
     * Person gender setter
     */
    public void setGender(int gender) {

        this.gender = gender;
    }

    /*
     * Method checks restriction on name != null
     *
     * true .. null
     * false .. not null
     */
    private boolean nameIsNull(String name){

        if(name == null){

            System.out.println("Attempt to set a NULL name. Name can not be NULL.");
            return true;
        }
        else {
            return false;
        }
    }

    /*
     * Method checks restriction on  0 > age > 190
     *
     * true .. correct
     * false .. incorrect
     */
    private boolean ageIsCorrect(int age){

        if(age > 190 || age < 0){

            System.out.println("Attempt to set an incorrect age. Age can not be < 0 and > 190.");

            return false;
        }else{

            return true;
        }
    }
}