package me.demo.service;

import me.demo.dto.DemoAccount;
import me.demo.dto.DemoCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chrislin on 5/29/2014.
 */

@Service
public class DemoCustomerServiceImpl implements DemoCustomerService {
    @Override
    public List<DemoCustomer> listCustomers() {
        return DemoCustomerServiceMockData.mockCustomerList();
    }

    @Override
    public DemoCustomer getSimpleCustomer() {
        return DemoCustomerServiceMockData.mockSimpleCustomer();
    }

    @Override
    public DemoCustomer getFullCustomer() {
        return DemoCustomerServiceMockData.mockFullCustomer();
    }

    @Override
    public DemoAccount getCustomAccount() {
        return new DemoAccount("acount-id-z", "account-z-name", "kind of shady");
    }


}
