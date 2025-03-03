package com.jd.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class PageUtils {
    public static Page<Object> getPage(int pageNum,int pageSize){
        return PageHelper.startPage(pageNum,pageSize);
    }
}
