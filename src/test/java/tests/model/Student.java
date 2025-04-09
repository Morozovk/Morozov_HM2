package tests.model;

import java.util.Collections;
import java.util.List;

public class Student {

    private String name;
    private String age;
    private String isStudent;
    private List<String> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = isStudent;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public StudentAddress getAddress() {
        return address;
    }

    public void setAddress(StudentAddress address) {
        this.address = address;
    }

    private StudentAddress address;
}
