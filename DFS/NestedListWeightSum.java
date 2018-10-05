package DFS;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class NestedListWeightSum {
    int count = 0;
//    public int depthSum(List<NestedInteger> nestedList) {
//        if (nestedList.size() == 0) {
//            return 0;
//        }
//
//        helper(nestedList, 1);
//        return count;
//        // return count;
//    }

//     public void helper(List<NestedInteger> nestedList, int depth) {
//         if (nestedList.size() == 0) {
//             return;
//         }

//         int count = 0;
//         for (NestedInteger nested : nestedList) {
//             if (nested.isInteger()) {
//                 count += nested.getInteger() * depth;
//             } else {
//                 count += helper(nested.getList(), depth + 1);
//             }
//         }
//         return count;
//     }

//    public void helper(List<NestedInteger> nestedList, int depth) {
//        if (nestedList.size() == 0) {
//            return;
//        }
//
//        for (NestedInteger nested : nestedList) {
//            if (nested.isInteger()) {
//                count += nested.getInteger() * depth;
//            } else {
//                helper(nested.getList(), depth + 1);
//            }
//        }
//    }
}
