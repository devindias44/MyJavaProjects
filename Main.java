import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Students> students = new ArrayList<>();
        
        // Add 10 student objects
        students.add(new Students(105, "John", "123 Main St"));
        students.add(new Students(102, "Alice", "456 Oak Ave"));
        students.add(new Students(109, "Bob", "789 Pine Rd"));
        students.add(new Students(101, "Eve", "321 Elm St"));
        students.add(new Students(107, "Mike", "654 Maple Dr"));
        students.add(new Students(103, "Sarah", "987 Cedar Ln"));
        students.add(new Students(106, "David", "135 Birch Way"));
        students.add(new Students(104, "Lisa", "246 Willow Ct"));
        students.add(new Students(110, "Tom", "864 Spruce Blvd"));
        students.add(new Students(108, "Karen", "579 Aspen Ave"));
        
        System.out.println("Before sorting:");
        printStudents(students);
        
        // Sort using merge sort
        MergeSort.sort(students, new RollNoComparator());
        
        System.out.println("\nAfter sorting by roll number:");
        printStudents(students);
    }
    
    private static void printStudents(ArrayList<Students> students) {
        for (Students student : students) {
            System.out.println(student);
        }
    }
}
