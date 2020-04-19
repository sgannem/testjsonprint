package com.xyz;

import java.util.*;

public class ParenthesisMatching {
    public static void main(String[] args) {
        String input = "((a)()()";
//        System.out.println(isBalanced("(s)()))"));
        System.out.println(removeInvalidParenthesis(input));
    }

    private static List<String> removeInvalidParenthesis(String input) {
        Map<String, Boolean> vis = new HashMap<>();
        vis.put(input, Boolean.FALSE);
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(input);
        boolean found = false;
//        node.setVisited(Boolean.TRUE);
        while (!q.isEmpty()) {
            String ele = q.remove();
            if (vis.get(ele)) continue;
            vis.put(ele, Boolean.TRUE);
            if (isBalanced(ele)) {
                found = Boolean.TRUE;
                ans.add(ele);
            }
            if (found) continue;
            for (int i = 0; i < ele.length(); i++) {
                if (ele.charAt(i) == '(' || ele.charAt(i) == ')') {
                    String v = ele.substring(0, i) + ele.substring(i + 1, ele.length());
                    q.add(v);
                    vis.put(v, Boolean.FALSE);
                }
            }
        }
        return ans;
    }

    private static boolean isBalanced(String input) {
        char[] s = input.toCharArray();
        int counter = 0;
        for (char t : s) {
            if (t == '(')
                counter++;
            else if (t == ')')
                counter--;
        }
        return counter == 0;
    }
}
