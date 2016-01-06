package tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<int[]> list = new ArrayList<int[]>();

        int[] a1 = {0,4};
        int[] a2 = {0,2};
        int[] a3 = {0,1};
        int[] a4 = {1,2};
        int[] a5 = {2,4};
        int[] a6 = {2,3};
        int[] a7 = {3,4};

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);

        Map<Integer,List<Integer>> map = getMap(list);
        TreeNode treeNode = getTreeNode(0,map);

        String result = treeNode.traverseTree(treeNode);
        System.out.println(result);

        List<Integer> l = getResult(result);

        System.out.println();

    }

    public static List<Integer> getResult(String result){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        String[] treeStr = result.split("\\n");
        for (String str : treeStr){
            String[] tree = str.split(",");
            List<Integer> treeLsit = new ArrayList<Integer>();
            for (String e : tree){
                treeLsit.add(Integer.valueOf(e));
            }
            list.add(treeLsit);
        }

        List<Integer> bestList = getBestResult(list);

        Collections.sort(bestList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer)o2;
            }
        });

        return bestList;
    }

    public static List<Integer> getBestResult(List<List<Integer>> list){
        List<Integer> scoreList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int score = 0;
            if(list.get(i).size() > 1){
                for (int j = 0; j < list.get(i).size() -1; j++) {
                    if(Math.abs(list.get(i).get(j) - list.get(i).get(j+1)) == 2)
                        score++;
                }
            }
            scoreList.add(score);
        }

        int max = 0;
        for (int i = 0; i < scoreList.size(); i++) {
            if(scoreList.get(i) > max)
                max = i;
        }

        return list.get(max);
    }

    public static TreeNode getTreeNode(Integer id,Map<Integer,List<Integer>> map){
        TreeNode treeNode = new TreeNode();
        treeNode.setId(id);
        if(map.keySet().contains(id)){
            for(Integer cid : map.get(id)){
                TreeNode cNode = getTreeNode(cid,map);
                cNode.setParentNode(treeNode);
                treeNode.getChildList().add(cNode);
            }
        }
        return treeNode;
    }

    public static Map<Integer,List<Integer>> getMap(List<int[]> list){
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int[] e : list){
            if(e[0] != e[1]){
                if(map.keySet().contains(e[0])){
                    map.get(e[0]).add(e[1]);
                }else {
                    List<Integer> tList = new ArrayList<Integer>();
                    tList.add(e[1]);
                    map.put(e[0],tList);
                }
            }
        }
        return map;
    }

}
