package cn.imacoder.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Project:spring-boot-start-euraka
 * @ Package:cn.imacoder.start.common.model
 * @ Created By: QIUYANJUN
 * @ Description:TODO
 * @ Date:2019/10/11 14:28
 * @ Modify By: QIUYANJUN
 * @ Author:QIUYANJUN
 */
public class DemoRequest {

    private String id;

    private String name;

    private int age;

    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date birthday;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }

    public DemoRequest() {
        this.id ="001";
        this.name= "defaultName";
        this.age=23;
        this.birthday = new Date();
    }
    @Override
    public String toString() {
        return "DemoRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

}
