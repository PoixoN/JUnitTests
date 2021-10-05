public class Program {
    public static void main(String[] args) {

        Person tom = new Person();
        tom.displayInfo();

        tom.name = "Tom";
        tom.age = 34;
        tom.displayInfo();
    }
}
