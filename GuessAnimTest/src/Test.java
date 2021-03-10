
import java.util.*;

class Utilities {

    int[] tree;
    Map<Integer, Integer> nodes = new HashMap<>();

    public Utilities(int[] tree) {
        this.tree = tree;
    }

    public int getHeight(int node) {
        int node2=node;
        if(nodes.containsKey(node)){
            return nodes.get(node);
        }else {
            if (node == -1) {
                return 1;
            } else {
                node = tree[node];
                nodes.put(node2,1+getHeight(node));
                return 1 + getHeight(node);
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nodes = Integer.parseInt(input.nextLine());
        int[] tree = new int[nodes];
        int count = 0;
        String[] array = input.nextLine().split(" ");
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.parseInt(array[i]);
        }
        Utilities util = new Utilities(tree);
        for (int node : tree) {
            int temp = util.getHeight(node);
            if (temp > count) {
                count = temp;
            }
        }
        System.out.println(count);
    }
}
