package me.demo.dto;

/**
 * Created by chrislin on 5/29/2014.
 */
public class DemoAccount {
    private String id;
    private String name;
    private String status;


    // ----------------------------------------------------------------------------
    //     generated CONSTRUCTORS
    // ----------------------------------------------------------------------------
    public DemoAccount() {
    }

    public DemoAccount(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // ----------------------------------------------------------------------------
    //     generated GETTERS/SETTERS
    // ----------------------------------------------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
