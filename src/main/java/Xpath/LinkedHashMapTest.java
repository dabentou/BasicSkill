package Xpath;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/12/7.
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {

        LinkedHashMap linkedHashMap = new LinkedHashMap();


        linkedHashMap.put("Xpath","dongsheng");
        linkedHashMap.put("xiao","xiangyoupin");

        System.out.println(linkedHashMap.get("Xpath"));
        System.out.println(linkedHashMap.get("xiao"));


    }
}
