package me.demo.service;

import me.demo.dto.DemoAccount;
import me.demo.dto.DemoCustomer;

import java.util.List;

/**
 * Created by chrislin on 5/29/2014.
 */
public interface DemoCustomerService {

    List<DemoCustomer> listCustomers();

    DemoCustomer getSimpleCustomer();

    DemoCustomer getFullCustomer();

    DemoAccount getCustomAccount();
}
