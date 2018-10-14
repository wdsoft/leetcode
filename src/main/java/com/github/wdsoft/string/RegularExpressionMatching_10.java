package com.github.wdsoft.string;

/**
 * - 若p为空，若s也为空，返回true，反之返回false
 *
 * - 若p的长度为1，若s长度也为1，且相同或是p为'.'则返回true，反之返回false
 *
 * - 若p的第二个字符不为*，若此时s为空返回false，否则判断首字符是否匹配，且从各自的第二个字符开始调用递归函数匹配
 *
 * - 若p的第二个字符为*，若s不为空且字符匹配，调用递归函数匹配s和去掉前两个字符的p，若匹配返回true，否则s去掉首字母
 *
 * - 返回调用递归函数匹配s和去掉前两个字符的p的结果
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1) {
            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))  {
                return true;
            } else {
                return false;
            }
        }

        if (p.charAt(1) != '*') {
            if (!s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) ||p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
}
