import java.util.Comparator;

public class RollNoComparator implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
