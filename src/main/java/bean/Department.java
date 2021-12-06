package bean;

public class Department {
    private int id;
    private int userNumbers;
    private String name;

    public Department(int id, int userNumbers, String name) {
        this.id = id;
        this.userNumbers = userNumbers;
        this.name = name;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", userNumbers=" + userNumbers +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(int userNumbers) {
        this.userNumbers = userNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
