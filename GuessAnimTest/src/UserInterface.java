import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int edges = Integer.parseInt(input.nextLine());
        List<Integer> parents = new ArrayList<>();
        List<Integer> children = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        int count = 0;
        while (count < edges) {
            String[] line = input.nextLine().split(" ");
            parents.add(Integer.parseInt(line[0]));
            children.add(Integer.parseInt(line[1]));
            count++;
        }

        for (int node : children) {
            if (!parents.contains(node)) {
                leaves.add(node);
            }
        }
        System.out.println(leaves.size());
        for (int leaf : leaves) {
            System.out.print(leaf + " ");
        }
    }
}
