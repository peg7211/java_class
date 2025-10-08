class Student {
    private String id;
    private String name;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return "학번: " + id + ", 이름: " + name;
    }
}

class HighSchoolStudent extends Student {
    HighSchoolStudent(String id, String name) {
        super(id, name);
    }

    void printInfo() {
        System.out.println("고등학생 - " + getInfo());
    }
}

class UniversityStudent extends Student {
    UniversityStudent(String id, String name) {
        super(id, name);
    }

    void printInfo() {
        System.out.println("대학생 - " + getInfo());
    }
}

public class Pro_4 {
    public static void main(String[] args) {
        HighSchoolStudent hs = new HighSchoolStudent("HS001", "인하");
        UniversityStudent univ = new UniversityStudent("UN001", "비룡");

        hs.printInfo();
        univ.printInfo();
    }
}

