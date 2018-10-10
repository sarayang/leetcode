package TopologicalSort;

import java.util.*;

/**
 * Created by YANGSONG on 2018-10-09.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }

        HashMap<Character, HashSet<Character>> graph = constructGraph(words);
        return topologicalSort(graph);
    }

    private HashMap<Character, HashSet<Character>> constructGraph(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        // 1. fetch all keys to hashmap
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                graph.put(word.charAt(i), new HashSet<Character>());
            }
        }

        // 2.construct the graph
        for (int j = 0; j < words.length - 1; j++) {
            String cur = words[j];
            String next = words[j + 1];
            int minLen = Math.min(cur.length(), next.length());
            for (int m = 0; m < minLen; m++) {
                if (cur.charAt(m) != next.charAt(m)) {
                    System.out.println(cur.charAt(m) + "," + next.charAt(m));
                    graph.get(cur.charAt(m)).add(next.charAt(m));
                    // well i need to write some note here to remind myself why we have to break here...
                    // {"za","zb","ca","cb"} will fail if no break
                    // so what we want to capture is a ->b, z->c and a->b again..
                    // without break, b->a will be captured also.
                    // 总结： 只要第一个不一样 就记录第一个 永远只记录 第一对不一样的character。well this is from the alien dic definition....
                    break;
                }
            }
        }
        return graph;
    }

    private String topologicalSort(HashMap<Character, HashSet<Character>> graph) {
        HashMap<Character, Integer> indegree = getIndegree(graph);
        System.out.println(graph);
        Deque<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            sb.append(cur);
            for (Character dep : graph.get(cur)) {
                int degree = indegree.get(dep);
                indegree.put(dep, degree - 1);
                if (indegree.get(dep) == 0) {
                    queue.offer(dep);
                }
            }
        }
        if (sb.length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }

    private HashMap<Character, Integer> getIndegree(HashMap<Character, HashSet<Character>> graph) {
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (Character c : graph.keySet()) {
            indegree.put(c, 0);
        }

        for (Character cha : graph.keySet()) {
            for (Character dep : graph.get(cha)) {
                if (indegree.containsKey(dep)) {

                    indegree.put(dep, indegree.get(dep) + 1);
                } else {
                    indegree.put(dep, 1);
                }
            }
        }

        return indegree;
    }

    public static void main(String[] args) {
        String[] input = {"za","zb","ca","cb"};
        AlienDictionary ad = new AlienDictionary();
        String out = ad.alienOrder(input);
        System.out.println(out);

        int[] i = {1,2,3,4,5,6};
    }
}
