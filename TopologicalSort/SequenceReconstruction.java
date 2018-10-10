package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by YANGSONG on 2018-10-09.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org.length == 0) {
            return true;
        }

        if (seqs.size() == 0) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> graph = constructGraph(seqs, org);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (Integer i : graph.keySet()) {
            ArrayList<Integer> res = new ArrayList<>();
            System.out.println(i);
            dfs(i, graph, visited);
            list.add(res);
        }
        System.out.println(list);
//        for (List<Integer> permutation : list) {
//            if (permutation.size() != org.length) {
//                continue;
//            }
//            for (int j = 0; j < permutation.size(); j++) {
//                if (permutation.get(j) != org[j]) {
//                    return false;
//                }
//            }
//        }
        return true;

    }

    private void dfs(int parent, HashMap<Integer, HashSet<Integer>> graph, HashMap<Integer, Boolean> visited) {
//        if (!graph.containsKey(parent)) {
//            return;
//        }
        visited.put(parent, true);
        for (Integer i : graph.get(parent)) {
            if (!visited.containsKey(i) || visited.get(i) == false) {
                System.out.println(i);
                dfs(i, graph, visited);
            }
        }
        visited.put(parent, false);
    }

    private HashMap<Integer, HashSet<Integer>> constructGraph(List<List<Integer>> seqs, int[] org) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i : org) {

        }
        for (List<Integer> seq : seqs) {
            if (graph.containsKey(seq.get(0))) {
                graph.get(seq.get(0)).add(seq.get(1));
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(seq.get(1));
                graph.put(seq.get(0), set);
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        SequenceReconstruction se = new SequenceReconstruction();
        int[] org = {1,2,3};
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);

        boolean b = se.sequenceReconstruction(org, list);
//        System.out.println(b);
    }

    /**
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org.length == 0) {
            return true;
        }

        if (seqs.size() == 0) {
            return false;
        }

        HashMap<Integer, HashSet<Integer>> graph = constructGraph(seqs);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (Integer i : graph.keySet()) {
            ArrayList<Integer> res = new ArrayList<>();
            // res.add(i);
            dfs(graph.get(i), i, graph, res);
            list.add(res);
        }
        System.out.println(list);
        for (List<Integer> permutation : list) {
            if (permutation.size() != org.length) {
                continue;
            }
            for (int j = 0; j < permutation.size(); j++) {
                if (permutation.get(j) != org[j]) {
                    return false;
                }
            }
        }
        return true;

    }

    private void dfs(HashSet<Integer> dep, int parent, HashMap<Integer, HashSet<Integer>> graph, List<Integer> res) {
        if (!graph.containsKey(parent)) {
            return;
        }

        res.add(parent);

        for (Integer i : dep) {
            dfs(graph.get(i), i, graph, res);
        }
        res.remove(res.size() - 1);



    }

    private HashMap<Integer, HashSet<Integer>> constructGraph(List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (graph.containsKey(seq.get(0))) {
                graph.get(seq.get(0)).add(seq.get(1));
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(seq.get(1));
                graph.put(seq.get(0), set);
            }
        }

        return graph;
    }
     */
}
