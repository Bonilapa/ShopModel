public class Person {
    protected String name;
    protected int age;
    protected int gender;

    private Person(){

    }

    public Person(String name) {

        if(nameIsNull(name)){

            return;
        }

        this.name = name;

    }
    public Person(String name, int age, int gender) {

        if(nameIsNull(name) || !ageIsCorrect(age)){

            return;
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        if(nameIsNull(name)){

            return;
        }

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        if(ageIsCorrect(age)) {
            this.age = age;
        }
    }

    public int getGender() {

        return gender;
    }

    public void setGender(int gender) {

        this.gender = gender;
    }

    private boolean nameIsNull(String name){

        if(name == null){

            System.out.println("Attempt to set a NULL name. Name can not be NULL.");
            return true;
        }
        else {
            return false;
        }
    }

    private boolean ageIsCorrect(int age){

        if(age > 190 || age < 0){

            System.out.println("Attempt to set an incorrect age. Age can not be < 0 and > 190.");

            return false;
        }else{

            return true;
        }
    }
}
