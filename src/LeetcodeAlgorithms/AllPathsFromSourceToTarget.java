package LeetcodeAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

        List<List<Integer>> ans = allPathsSourceTarget(graph);
        System.out.println(ans);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        //curr.add(0);
        dfs(graph, curr, res, 0, graph.length -1);
        return res;
    }

    private static void dfs(int[][] graph, List<Integer> curr, List<List<Integer>> res, int src, int des) {

        if (src == des) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int a : graph[src]) {
            curr.add(a);
            dfs(graph, curr, res, a, des);
            curr.remove(curr.size() - 1);
        }
    }
}
