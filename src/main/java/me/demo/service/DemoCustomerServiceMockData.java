package me.demo.service;

import me.demo.dto.DemoAccount;
import me.demo.dto.DemoCustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrislin on 6/2/2014.
 */
public class DemoCustomerServiceMockData {

    public static DemoCustomer mockFullCustomer() {
        DemoCustomer c = new DemoCustomer(111, "customer-name-111", "customer-nick-111");

        List<DemoAccount> ats = new ArrayList<DemoAccount>();
        ats.add(new DemoAccount("acount-id-x", "account-x-name", "bankrupted"));
        ats.add(new DemoAccount("acount-id-y", "account-y-name", "good standing"));

        c.setAccounts(ats);
        return c;

    }

    public static DemoCustomer mockSimpleCustomer() {
        DemoCustomer c = new DemoCustomer(222, "customer-name-222", null);
        return c;

    }


    public static List<DemoCustomer> mockCustomerList() {
        ArrayList<DemoCustomer> l = new ArrayList<DemoCustomer>();
        l.add(mockFullCustomer());
        l.add(mockSimpleCustomer());
        return l;

    }

    public static List<DemoCustomer> mockCustomerList2() {
        ArrayList<DemoCustomer> l = new ArrayList<DemoCustomer>();
        DemoCustomer c = new DemoCustomer(9999, "customer-name-99999999", null);
        l.add(c);
        return l;

    }

}
