package com.fh.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test20161201 {
    public static void main(String[] args) {
        System.out.println(isContainChinese("China中国,您好"));
    }

    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}