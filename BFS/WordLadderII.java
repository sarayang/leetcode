package BFS;

import java.util.*;

/**
 * Created by YANGSONG on 2018-10-09.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) {
            return res;
        }

        if (beginWord.length() != endWord.length()) {
            return res;
        }

        if (endWord.equals(beginWord)) {
            List<String> result = new ArrayList<>();
            result.add(beginWord);
            // result.add(endWord);
            res.add(result);
            return res;
        }

        HashSet<String> set =  new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        set.add(beginWord);
//        set.add(endWord);
        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, List<String>> pi = new HashMap<>();

        bfs(beginWord, endWord, set, dist, pi);
        List<String> subResult = new ArrayList<>();
        dfs(subResult, res, beginWord, endWord, set, dist, pi);

        return res;

    }

    private void dfs(List<String> sub, List<List<String>> res, String start, String end,
                     HashSet<String> set, HashMap<String, Integer> dist, HashMap<String, List<String>> pi) {
        sub.add(end);
//        System.out.println(sub);
        if (end.equals(start)) {
            Collections.reverse(sub);
            res.add(new ArrayList<>(sub));
            Collections.reverse(sub);
        } else {
            for (String next : pi.get(end)) {
                if (dist.containsKey(next) && dist.get(end) == dist.get(next) + 1) {
                    dfs(sub, res, start, next, set, dist, pi);
                }
            }
        }
        System.out.println(sub);
        sub.remove(sub.size() - 1);


    }

    private void bfs(String start,
                     String end,
                     HashSet<String> set,
                     HashMap<String, Integer> dist,
                     HashMap<String, List<String>> pi) {

        for (String s : set) {
            pi.put(s, new ArrayList<String>());
            // dist.put(s, 0);
        }

        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        // set.remove(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            ArrayList<String> expansion = getExpansion(word, set);
            for (String next : expansion) {
                pi.get(next).add(word);
                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(word) + 1);
                    queue.add(next);

                }
            }
        }
    }

    private ArrayList<String> getExpansion(String word, HashSet<String> set) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chas = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chas[i] = c;
                String tmp = new String(chas);
                if (set.contains(tmp)) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "log";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
//        list.add("cog");

        WordLadderII w2 = new WordLadderII();
        System.out.println("--------");
        System.out.println(w2.findLadders(start, end, list));
    }
}
