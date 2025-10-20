package pj4_5_Inhertance;
class main{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Hieu");
        s1.setClasses("10C2");
        System.out.println(s1.getName());
        System.out.println(s1.getClasses());

    }
}
public class Student {
    private String name = "joni";
    private String classes = "C02";

    public Student(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
