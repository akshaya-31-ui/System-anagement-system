package com.studentmanager.model;
public final class Student{
    private final int id;
    private final String name;
    private final double marks;
    public Student(int id,String name,double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    public String getGrade()
    {
        if(marks>=90)
            return "A+ Outstanding";
        else if(marks>=80)
            return "A  Excellent";
        else if(marks>=75)
            return "B Very Good";
        else if(marks>=60)
            return "C Good";
        else if(marks>=50)
            return "D Average";
        else if(marks>=35)
            return "E Pass";
        else 
            return "F Fail";
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }
    public boolean isPassed() {
        return marks >= 35;
    }
    @Override
    public String toString(){
        return String.format(
            " ID: %-5d | Name: %-20s | Marks: %6.2f | Grade: %s",
            id,name,marks,getGrade()
        );
    }
}