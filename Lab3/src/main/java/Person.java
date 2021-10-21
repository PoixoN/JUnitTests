public class Person {
    String name, surname;
    double age;
    Provider provider;

    //----------
    Person() {
        name = "Lubomyr";
        surname = "Maevskiy";
        age = 37;
    }

    Person(String name, String surname, double age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getAge() {
        return age;
    }

    void setAge(int a) {
        this.age = a;
    }

    public void Person(Provider provider) {
        this.provider = provider;
    }

    public void setArgumentProvider(Provider provider) {
        this.provider = provider;
    }

    public String NameSurnameAge(int nameId, int surnameId, int ageId) throws IdNotFoundException {
        String name = this.provider.getArgS(nameId);
        String surname = this.provider.getArgS(surnameId);
        double age = this.provider.getArgD(ageId);
        String res = name.concat(surname).concat(Double.toString(age));
        System.out.println(res);
        if (name.equals(null) || surname.equals(null) || age == 0) {
            throw new IdNotFoundException("Id not found");
        }

        return res;
    }

    public String GetName(int nameId) throws IdNotFoundException {
        String name = this.provider.getArgS(nameId);

        System.out.println(name);
        if (name.equals(null)) {
            throw new IdNotFoundException("Id not found");
        }

        return name;
    }

    double newAge() {
        double age = provider.nextArgD();
        System.out.println(age);
        return age;
    }

    String NewName() {
        String name = provider.nextArgS();
        System.out.println(name);
        return name;
    }

    Boolean Name(String n) {
        return n.equals(name);
    }


}
