import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        int ans =  (int) Math.log10(200) + 1;
//        System.out.println(ans);
//        System.out.println("Hello world!");

//        TreeMap<String, Integer> map = new TreeMap<>();
//        map.put("Sarthak",1);
//        map.put("Preeti",3);
//        map.put("Gayatri",2);
//        map.put("Ashna",4);
//        System.out.println(map);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        list.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        list.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        list.add(l3);

        System.out.println(list);
    }
}