import java.util.*;

public class Knapsackalgo {
    public static double knapSackfind(int profit[], int weight[], int sack) {
        double res = 0;
        HashMap<Double, List<Integer>> hm = new HashMap<Double, List<Integer>>();
        for (int i = 0; i < profit.length; i++) {
            List<Integer> li = new ArrayList<>();
            li.add(profit[i]);
            li.add(weight[i]);
            double prof = profit[i];
            double wei = weight[i];
            hm.put(prof / wei, li);
        }
        TreeMap<Double, List<Integer>> tm = new TreeMap<Double, List<Integer>>(Collections.reverseOrder());
        tm.putAll(hm);
        for (Map.Entry<Double, List<Integer>> m : tm.entrySet()) {
            if (m.getValue().get(1) < sack) {
                res += m.getValue().get(0);
                sack -= m.getValue().get(1);
            } else {
                res += sack * m.getKey();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int Sack = 20;
        int profit[] = { 120, 100, 60 };
        int weight[] = { 17, 13, 8 };

        System.out.println(knapSackfind(profit, weight, Sack));
    }
}
