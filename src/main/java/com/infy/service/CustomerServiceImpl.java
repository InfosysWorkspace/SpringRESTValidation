package com.infy.service;


import com.infy.dto.AddressDTO;
import com.infy.dto.CustomerDTO;
import com.infy.entity.Address;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Integer addCustomer(CustomerDTO customerDTO) throws InfyBankException {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());

        Address address = new Address();
        address.setStreet(address.getStreet());
        address.setCity(address.getCity());

        customer.setAddress(address);
        customerRepository.save(customer);

        return customer.getCustomerId();
    }

    @Override
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(customer.getAddress().getAddressId());
        addressDTO.setStreet(customer.getAddress().getStreet());
        addressDTO.setCity(customer.getAddress().getCity());

        customerDTO.setAddressDTO(addressDTO);

        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws InfyBankException {

        Iterable<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers.forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTO.setEmailId(customer.getEmailId());

            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setAddressId(customer.getAddress().getAddressId());
            addressDTO.setStreet(customer.getAddress().getStreet());
            addressDTO.setCity(customer.getAddress().getCity());

            customerDTO.setAddressDTO(addressDTO);
            customerDTOS.add(customerDTO);
        });
        if (customerDTOS.isEmpty())
            throw new  InfyBankException("Service.CUSTOMERS_NOT_FOUND");

        return customerDTOS;
    }

    @Override
    public void updateCustomer(Integer customerId, String emailId) throws InfyBankException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer cust = customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        cust.setEmailId(emailId);
    }

    @Override
    public void deleteCustomer(Integer customerId) throws InfyBankException {

        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        customerRepository.deleteById(customerId);

    }



}
