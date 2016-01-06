package topn;

public class Student implements Comparable<Student> {

    private String name;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub  
        if(o.getScore()>this.score){
            return 1;
        }else if(o.getScore()<this.score){
            return -1;
        }
        return 0;
    }
}  