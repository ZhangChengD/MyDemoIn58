package com.zc.testList;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static listBean KEY;

    public static void main(String[] args){
        KEY = new listBean();
        KEY.id = "test50";
        KEY = null;
//        search(initList());
        initList().remove(KEY);
        searchall(initList());
    }

    public static List<listBean> initList(){
        List<listBean> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            listBean b = new listBean();
            b.id = "test"+i;
            list.add(b);
        }
        return list;
    }

    public static void search(List<listBean> list){
        int index=0;
        long l = System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            for (int j=0;j<list.size();j++){
                if(KEY.equals(list.get(j))){
                     index+=j;
                    break;
                }
            }
        }
        System.out.println(System.currentTimeMillis()-l+"--search--one--by--one--"+index);
    }

    public static void searchall(List<listBean> list){
        int index = 0;
        long l = System.currentTimeMillis();
        for (int i=0;i<1000;i++){
            index+=list.indexOf(KEY);
        }
        System.out.println(System.currentTimeMillis()-l+"--search--searchall--"+index);
    }

}
