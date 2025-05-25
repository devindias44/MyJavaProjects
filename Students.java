public class Students {
    private int rollno;
    private String name;
    private String address;

    public Students(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() {
        return rollno;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name + ", Address: " + address;
    }
}
