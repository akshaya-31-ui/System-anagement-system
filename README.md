## Student Management System

A Java console application built with Core Java, OOP principles, 
and Collections Framework featuring full CRUD operations, 
file-based data persistence, sorting, and statistics.

## Features

- addStudent() — with ID, name, and marks validation
- viewAllStudents() — formatted table with grades
- searchStudent() — instant lookup by ID
- deleteStudent()— with confirmation
- updateMarks() — immutable object replacement pattern
- sortbyName() — alphabetical order using Bubble Sort
- SortbyMarks() — rank-wise descending order
- Show Average() — calculated fresh from data
- Top & LowestPerformer() — instant identification
- Statistics() — total, average, highest, lowest, pass/fail count
- filePersistence() — data saved to `students.txt` across sessions
- **Exception Handling** — handles invalid inputs gracefully

## 🛠️ Tech Stack

| Technology | Usage |
| Java | Core language |
| Collections Framework | LinkedHashMap for ordered storage |
| File I/O | BufferedWriter / BufferedReader |
| OOP | Encapsulation, Immutability |
| Exception Handling | InputMismatchException, IOException |

## 📁 Project Structure

src/
└── com/
└── studentmanager/
├── main/
│   └── Main.java          # Entry point, menu, user input
├── model/
│   └── Student.java       # Immutable Student entity with grade logic
└── service/
└── StudentManager.java    # Business logic, CRUD, sorting, statistics

## ▶️ How to Run

**Prerequisites:** Java JDK 8 or above

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/student-management-system.git

# Navigate to project
cd student-management-system

# Create output folder
mkdir out

# Compile
javac -d out src/com/studentmanager/model/Student.java src/com/studentmanager/service/StudentManager.java src/com/studentmanager/main/Main.java

# Run
java -cp out com.studentmanager.main.Main

## 📸 Sample Output

No saved data found, Staring fresh.
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
1
Enter Student ID:
1
Enter Student Name:
Akshaya
Enter Student Marks (0-100):
99
Student added Successfully
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
1
Enter Student ID:
2
Enter Student Name:
supriya
Enter Student Marks (0-100):
88
Student added Successfully
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
1
Enter Student ID:
3
Enter Student Name:
ashok
Enter Student Marks (0-100):
89
Student added Successfully
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
1
Enter Student ID:
4
Enter Student Name:
yashmi
Enter Student Marks (0-100):
68
Student added Successfully
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
1
Enter Student ID:
5
Enter Student Name:
Arjun 
Enter Student Marks (0-100):
100
Student added Successfully
STUDENT MANAGEMENT SYSTEM
1.Add Student
2.View All Student Details
3.Search Student
4.Delete Student
5.Show Average Marks
6.Sort by Names
7.(Want to know ranks?) Sort by marks
8.Update the marks
9.Save Data
10.Top Performer
11.Lowest Performer
12.Show Statistics
13.Exit
Enter your choice:
2
 ID: 1     | Name: Akshaya              | Marks:  99.00 | Grade: A+ Outstanding
 ID: 2     | Name: supriya              | Marks:  88.00 | Grade: A  Excellent
 ID: 3     | Name: ashok                | Marks:  89.00 | Grade: A  Excellent
 ID: 4     | Name: yashmi               | Marks:  68.00 | Grade: C Good
 ID: 5     | Name: Arjun                | Marks: 100.00 | Grade: A+ Outstanding

## Key Concepts Demonstrated

- Immutability — `Student` class is `final` with all `private final` fields
- Encapsulation — data hidden behind getters, no public fields
- Collections — `LinkedHashMap` preserves insertion order
- File I/O — persistent storage across program sessions
- Exception Handling — program never crashes on bad input
- Bubble Sort — implemented from scratch without Comparator
- Package Structure — MVC-style separation of concerns

## Author

**Balabhadra Sri Naga Vasavi Lakshmi Akshaya**
B.Tech CSE — Vignan's Institute of Engineering for Women -- 2027 
mail - akshayabalabhadra@gmail.com  
Linkedin - (https://www.linkedin.com/in/srinagab/)
