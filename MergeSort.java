import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    public static void sort(ArrayList<Students> students, Comparator<Students> comparator) {
        if (students.size() > 1) {
            int mid = students.size() / 2;
            
            ArrayList<Students> left = new ArrayList<>(students.subList(0, mid));
            ArrayList<Students> right = new ArrayList<>(students.subList(mid, students.size()));
            
            sort(left, comparator);
            sort(right, comparator);
            
            merge(students, left, right, comparator);
        }
    }

    private static void merge(ArrayList<Students> students, 
                            ArrayList<Students> left, 
                            ArrayList<Students> right, 
                            Comparator<Students> comparator) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }
        
        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }
        
        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }
}
