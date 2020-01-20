package org.bomb.duapp.demo.protocol;

import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {
        Model a = new Model();
        a.setId(1L);

        Model b = new Model();
        b.setId(2L);

        a.setModel(b);
        b.setModel(a);

        String str = JSONObject.toJSONString(a);
        System.out.println(str);

        Model c = (Model) JSONObject.parse(str);
        System.out.println(c.getId());
    }
}
