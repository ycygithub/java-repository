package topn;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class TreeSetTopN {

    private TreeSet<Student> topN = new TreeSet<Student>();//Student必须实现Comparable接口
    private List<Student> studentList = new ArrayList<Student>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeSetTopN m = new TreeSetTopN();
        m.initList();//随机初始化学生分数
        m.topN(10);//获取前10个最高分
        m.printTopN();

    }

    /**
     * 打印TreeSet
     */
    public void printTopN() {

        System.out.println("--------------------topN result----------------");
        int index = 0;
        for (Student student : topN) {
            index++;
            System.out.println("No:" + index + ",name=" + student.getName() + ",score=" + student.getScore());
        }

    }

    /**
     * 随机产生100个学生的分数，并初始化到studentList中
     */
    public void initList() {

        System.out.println("-------------------- init ----------------------");
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            Student student = new Student("student" + i, rand.nextInt(100));
            studentList.add(student);
            //System.out.println("name = "+student.getName()+",score="+student.getScore());
        }

    }

    /**
     * 计算前N个最大的值
     * @param N 返回前N个最大的值
     */
    public void topN(int N) {

        int minScore = 110;
        for (Student student : studentList) {
            if (minScore > 100) {//第一次运行
                minScore = student.getScore();
            }
            if (topN.size() < N) {//首先填满topN
                topN.add(student);
                if (student.getScore() < minScore) {
                    minScore = student.getScore();//更新最低分
                }
            } else if (student.getScore() > minScore) {//topN已经填满，并且该学生的分数比最低分高
                topN.remove(topN.last());//先删除topN中的最低分
                topN.add(student);
                minScore = topN.last().getScore();//更新最低分
            }
        }

    }

}

