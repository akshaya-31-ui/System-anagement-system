import java.util.*;
public class StudentManager{
    private Map<Integer,Student> map=new LinkedHashMap<>();
    double marks=0;
    public void addStudent(Student student){
        if(!map.containsKey(student.getId()))
        {
             map.put(student.getId(),student);
             System.out.println("Student added Successfully");
             marks+=student.getMarks();
             return;
        }
        System.out.println("Student already exists");
    }
    public void viewAllStudents(){
        if(map.isEmpty())
        {
            System.out.println("No Students found");
            return;
        }
        for(Student s:map.values())
        {
            System.out.println(s);
        }
    }
    public Student searchStudent(int id){
        return map.get(id);
    }
    public void deleteStudent(int id){
        Student s=map.get(id);
        if(s!=null)
        {
            marks-=s.getMarks();
             map.remove(id);
             System.out.println("Deleted Successfully");
             return;
        }
        System.out.println("Student Not Found");
    }
    public void showAverage(){
        if(map.isEmpty())
        {
            System.out.println("No Student Found");
            return;
        }
        System.out.println("Average Marks:" + (marks/map.size()));
    }
}