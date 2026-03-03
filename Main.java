import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentManager manager=new StudentManager();  //creating object for Stu_man_class
        while(true){
            System.out.println("STUDENT MANEGEMENT SYATEM");
            System.out.println("1.Add Student");
            System.out.println("2.View All Student Details");
            System.out.println("3.Search Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Show Average Marks");
            System.out.println("6.Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            switch(choice){
                case 1:System.out.println("Enter Student ID:");
                       int id=sc.nextInt();
                       sc.nextLine();
                       System.out.println("Enter Student Name:");
                       String name=sc.next();
                       while(!name.matches("[a-zA-Z]+")){
                            System.out.println("Invalid name!Enter only letters.");
                            name=sc.next();
                       }
                       System.out.println("Enter Student Marks:");
                       double marks=sc.nextDouble();
                       while(marks<0)
                       {
                            System.out.println("Enter Valid Marks");
                            marks=sc.nextDouble();
                       }
                       manager.addStudent(new Student(id,name,marks));
                       break;
                case 2:manager.viewAllStudents();
                       break;
                case 3:System.out.println("Enter ID to Search:");
                       int search_id=sc.nextInt();
                       Student s=manager.searchStudent(search_id);
                       if(s!=null){
                        System.out.println(s);
                       }
                       else{
                        System.out.println("Student not found");
                       }
                       break;
                case 4:System.out.println("Enter ID to delete:");
                       int delete=sc.nextInt();
                       manager.deleteStudent(delete);
                       break;
                case 5:manager.showAverage();
                       break;
                case 6:System.out.println("Exiting....");
                       sc.close();
                       return;
                default:System.out.println("Invalid choice!");
            }
        }

    }
}