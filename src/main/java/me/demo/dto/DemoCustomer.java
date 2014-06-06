package me.demo.dto;

import java.util.List;

/**
 * Created by chrislin on 5/29/2014.
 */
public class DemoCustomer {
    private int id;
    private String name;
    private String nickName;

    private List<DemoAccount> accounts;

    // ----------------------------------------------------------------------------
    //     generated CONSTRUCTORS
    // ----------------------------------------------------------------------------
    public DemoCustomer() {
    }

    public DemoCustomer(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    // ----------------------------------------------------------------------------
    //     generated GETTERS/SETTERS
    // ----------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<DemoAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<DemoAccount> accounts) {
        this.accounts = accounts;
    }
}
