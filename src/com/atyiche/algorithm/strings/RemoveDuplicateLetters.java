package com.atyiche.algorithm.strings;

/**
 * @author liangyt
 * @create 2021-01-18 19:53
 */
public class RemoveDuplicateLetters {
    //方法一：暴力法，贪心策略递归
    public String removeDuplicateLetters(String s){
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
        return s.charAt(position) + removeDuplicateLetters(s.substring(position+1).replaceAll(s.charAt(position) + "",""));
    }

    public static void main(String[] args) {
        String str1 = "bcabc";
        String str2 = "cbacdcbc";
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(str1));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(str2));
    }
}
