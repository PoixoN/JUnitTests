public class Person {
    String name, surname;
    int age;
    Person()
    {
        name = "Jack";
        surname = null;
        age = 18;
    }
    void displayInfo(){
        System.out.printf("Name: %s \t Surname: %s \tAge: %d\n", name,surname, age);
    }

    void newAge(){
        age = 22;
    }

    void setAge(int a)
    {
        this.age = a;
    }
    Boolean Name(String n)
    {
        if(n.equals(name))
        {return true;}
        else{
            return false;}
    }
    String NewName(){
        name = "Robin";
        return name;
    }
    String NameSurname (String n, String s)
    {
        return  n.concat(s);
    }
}
