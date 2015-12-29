package com.alleyz.ui.RecyclerView;

/**
 * Created by Mr on 2015/12/22.
 */
public class MetaData {

    private String name;
    private String sex;
    private String age;

    public MetaData(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }
}
