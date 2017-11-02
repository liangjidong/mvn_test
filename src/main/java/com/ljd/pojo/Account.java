package com.ljd.pojo;

/**
 * Created by author on 17-11-2.
 * account实体类
 */
public class Account {
    private Integer id;
    private String name;
    private Long money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
