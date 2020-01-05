package com.lw.answer.entity;


import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class OptionFormat {


    public void format(String str, List<String> list) {
        String [] strs = str.split("\\|");
        List<String> res = Arrays.asList(strs);
        for (String s:res) {
            list.add(s);
        }
    }
}
