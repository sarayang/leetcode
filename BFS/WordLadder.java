package BFS;

import java.util.*;

/**
 * Created by YANGSONG on 2018-10-08.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return -1;
        }

        if (beginWord.length() != endWord.length()) {
            return -1;
        }

        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Deque<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        while (!q.isEmpty()) {
            String word = q.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                char[] chas = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    chas[i] = j;
                    String tmp = new String(chas);
                    if (set.contains(tmp)) {
                        if (tmp.equals(endWord)) {
                            return level + 1;
                        }
                        nextNum++;
                        q.offer(tmp);
                        set.remove(tmp);


                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        //"hot","dot","dog","lot","log","cog"
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        WordLadder w = new WordLadder();
        int i = w.ladderLength("hit", "hot", list);
        System.out.println(i);

    }
}
