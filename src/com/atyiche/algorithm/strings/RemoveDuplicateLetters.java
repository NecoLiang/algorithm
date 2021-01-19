package com.atyiche.algorithm.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author liangyt
 * @create 2021-01-18 19:53
 */
public class RemoveDuplicateLetters {
    //方法一：暴力法，贪心策略递归
    public String removeDuplicateLetters1(String s){
        //递归的基本情形
        if (s.length()==0)
            return "";
        //希望找到当前最左侧的字母，位置记为position
        int position = 0;
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //只有当前的字母比已经找到的position位置的字母要小，才有资格继续判断
            if(s.charAt(i) < s.charAt(position)) {
                //定义一个布尔变量，表示当前i位置的字母是否可以替换position位置的字母
                boolean isReplaceable = true;
                //遍历i之前的所有字母，判断i后面是否重复出现
                for (int j = position; j < i; j++) {
                    //定义一个布尔变量，表示j位置的字母是否重复出现
                    boolean isDuplicated = false;
                    //遍历i后面的所有字母，看j位置的字母是否重复出现
                    for (int k = i + 1; k < s.length(); k++) {
                        if (s.charAt(j) == s.charAt(k)) {
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (!isDuplicated) {
                        isReplaceable = false;
                        break;
                    }
                }
                if (isReplaceable) {
                    position = i;
                }
            }
        }
        //遍历结束，position位置的字母就是结果中最左侧的元素
        return s.charAt(position) + removeDuplicateLetters1(s.substring(position+1).replaceAll(s.charAt(position) + "",""));
    }

    //方法二：贪心策略改进
    public String removeDuplicateLetters2(String s){
        //递归的基本情形
        if (s.length()==0)
            return "";
        //希望找到当前最左侧的字母，位置记为position
        int position = 0;
        //定义一个count数组，保存所有26个字母在字符串中出现的频次
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;//count[0]保存a的个数，count[1]保存b的个数
        }
        //遍历字符串，找到当前最左端字母
        for (int i = 0; i < s.length(); i++) {
            //把当前字符和position位置比较，如果更小就替换
            if (s.charAt(i) < s.charAt(position))
                position = i;
            //每遇到一个字符，count值就减1
            //如果遇到count减为0，就直接退出，以当前最小的字母作为最左端字符
            if (--count[s.charAt(i) - 'a'] == 0)
                break;
        }
        //遍历结束，position位置的字母就是结果中最左侧的元素
        return s.charAt(position) + removeDuplicateLetters2(s.substring(position + 1).replaceAll(s.charAt(position) + "",""));
    }

    //方法三：使用栈进行优化
    public String removeDuplicateLetters(String s){
        //定义一个字符栈，保存去重后的结果
        Stack<Character> stack = new Stack<>();

        //为了快速判断一个字符是否在栈中出现过，用一个set来保存元素是否出现过
        HashSet<Character> seenSet = new HashSet<>();

        //为了快速判断一个字符是否在某个位置重复出现，用hashmap来保存字母出现在字符串的最后位置
        HashMap<Character, Integer> lastrOccur = new HashMap<>();

        //遍历字符串，将最后一次出现的位置保存进map
        for (int i = 0; i < s.length(); i++) {
            lastrOccur.put(s.charAt(i),i);
        }
        //遍历字符串，判断每个字符是否需要入栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //在c不存在的情况下考虑入栈
            if (!lastrOccur.containsKey(c)){
                //c入栈之前，要判断之前的栈顶元素，是否会在后面重复出现，如果重复出现即可删除
                while (!stack.isEmpty() && c < stack.peek() && lastrOccur.get(stack.peek()) > i){
                    seenSet.remove(stack.pop());
                }
                stack.push(c);
                seenSet.add(c);
            }
        }
        //将栈中的元素保存为字符串输出
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack){
            stringBuilder.append(c.charValue());
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String str1 = "bcabc";
        String str2 = "cbacdcbc";
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(str1));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(str2));
    }
}
