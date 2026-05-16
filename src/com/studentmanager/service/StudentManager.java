package com.studentmanager.service;
import com.studentmanager.model.Student;
import java.io.*;
import java.util.*; 
public class StudentManager{
    private final Map<Integer,Student> map=new LinkedHashMap<>();
    private static final String FILE_NAME = "students.txt";
    public void addStudent(Student student){
        if(!map.containsKey(student.getId()))
        {
             map.put(student.getId(),student);
             System.out.println("Student added Successfully");
        }
    }
    public boolean studentExists(int id)
    {
        return map.containsKey(id);
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
        int marks=0;
        for(Student i:map.values())
        {
            marks+=i.getMarks();
        }
        System.out.println("Average Marks:" + (marks/map.size()));
    }
    public void sortByName()
    {
        if(map.isEmpty())
        {
            System.out.println("No Students Found.");
            return;
        }
        List<Student> li=new ArrayList<>(map.values());
        int n=li.size();
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                String a=li.get(j).getName().toLowerCase();
                String b=li.get(j+1).getName().toLowerCase();
                if(a.compareTo(b)>0)
                {
                    Student temp=li.get(j);
                    li.set(j,li.get(j+1));
                    li.set(j+1,temp);
                }
            }
        }
        System.out.println("\n-- Students sorted by name(A-Z) --");
        for(Student s:li)
        {
            System.out.println(s);
        }
    }
    public void sortByMarks()
    {
        if(map.isEmpty())
        {
            System.out.println("No Students Found");
            return;
        }
        List<Student> li=new ArrayList<>(map.values());
        int n=li.size();
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(li.get(j).getMarks()<li.get(j+1).getMarks())
                {
                    Student temp=li.get(j);
                    li.set(j,li.get(j+1));
                    li.set(j+1,temp);
                }
            }
        }
        int rank=1;
        for(Student s:li)
        {
            System.out.println("Rank " + rank++ + " | " + s);
        }
    }
    public void updateStudent(int id,double newMarks)
    {
        if(!map.containsKey(id))
        {
             System.out.println("Student not found");
             return;
        }
        Student old=map.get(id);
        Student update=new Student(id,old.getName(),newMarks);
        map.put(id,update);
        System.out.println("Marks updated successfully!");
        System.out.println("Updated Record:" + update);
    }
    public void saveToFile()
    {
        try{
            FileWriter fw=new FileWriter(FILE_NAME);
            BufferedWriter bw=new BufferedWriter(fw);
            for(Student s:map.values())
            {
                bw.write(s.getId() + "," +s.getName() + "," + s.getMarks());
                bw.newLine();
            }
            bw.close();
            System.out.println("Data saved successfully to " + FILE_NAME);
        }
        catch(IOException e)
        {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    public void loadFromFile()
    {
        File file=new File(FILE_NAME);
        if(!file.exists())
        {
            System.out.println("No saved data found, Staring fresh.");
            return;
        }
        try{
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            int count=0;
            while((line=br.readLine())!=null)
            {
                line=line.trim();
                if(line.isEmpty())  continue;
                String[] parts=line.split(",");
                if(parts.length<3)   continue;
                int id=Integer.parseInt(parts[0].trim());
                String name=parts[1].trim();
                if (map.containsKey(id)) {
                    System.out.println("Skipping duplicate ID: " + id);
                    continue;
                }
                double marks=Double.parseDouble(parts[2].trim());
                map.put(id,new Student(id,name,marks));
                count++;
            }
            br.close();
            System.out.println(count + " student(s) loaded from " + FILE_NAME);
        }
        catch(IOException e){
            System.out.println("Error saving file: " + e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Corrupted data found in file.");
        }
    }
    public void getTopPerformer() 
    {
         if (map.isEmpty()) {
             System.out.println("No students found.");
            return;
        }
        Student top = null;
        for (Student s : map.values()) {
             if (top == null || s.getMarks() > top.getMarks()) {
                    top = s;
               }
        }
        System.out.println("\n--- Top Performer ---");
        System.out.println(top);
    }
    public void getLowestPerformer() 
    {
        if (map.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        Student lowest = null;
        for (Student s : map.values()) 
        {
            if (lowest == null || s.getMarks() < lowest.getMarks()) 
            {
                   lowest = s;
            }
        }
        System.out.println("\n--- Lowest Performer ---");
        System.out.println(lowest);
   }
   public void showStatistics() {
        if (map.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        double total    = 0;
        double highest  = 0;
        double lowest   = 100;
        int passCount   = 0;
        int failCount   = 0;
        String topName    = "";
        String lowestName = "";
        for (Student s : map.values()) 
        {
            double marks = s.getMarks();
            total += marks;
            if(marks>highest)
            {
                highest = marks;
                topName = s.getName();
            }
            if (marks<lowest) 
            {
                lowest = marks;
                lowestName = s.getName();
            }
            if (s.isPassed()) {
                passCount++;
            } 
             else
            {
                failCount++;
            }
        }
        double average = total / map.size();
        System.out.println("\n======== STATISTICS =========");
        System.out.println("Total Students  : " + map.size());
        System.out.println("Average Marks   : " + String.format("%.2f", average));
        System.out.println("Highest Marks   : " + highest + " (" + topName + ")");
        System.out.println("Lowest Marks    : " + lowest  + " (" + lowestName + ")");
        System.out.println("Passed Students : " + passCount);
        System.out.println("Failed Students : " + failCount);
        System.out.println("Pass Percentage : " + String.format("%.2f", (passCount * 100.0 / map.size())) + "%");
        System.out.println("==============================");
    }
}