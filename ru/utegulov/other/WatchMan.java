package ru.utegulov.other;

interface Visitor{
    boolean visit(Student student);
    boolean visit(Teacher teacher);
    boolean visit(Human human);

}

abstract class Human{
    public abstract boolean accept(Visitor visitor);
}
final class Student extends Human{
    private String name;
    private Integer number;

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

final class Teacher extends Human{
    private String name;
    private Integer num;
    private String job;

    public Teacher(String name, Integer num, String job) {
        this.name = name;
        this.num = num;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public Integer getNum() {
        return num;
    }

    public String getJob() {
        return job;
    }
    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

}

public class WatchMan implements Visitor{

    @Override
    public boolean visit(Student student) {
        if(student.getName().isEmpty()||student.getNumber()==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean visit(Teacher teacher) {
        if(!(teacher.getName().isEmpty()) || ((teacher.getNum()!=null) || teacher.getJob()!=null)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean visit(Human human) {
        return false;
    }



}
