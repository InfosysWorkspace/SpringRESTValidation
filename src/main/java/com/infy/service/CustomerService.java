package com.infy.service;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;

import java.util.List;

public interface CustomerService {
    public Integer addCustomer(CustomerDTO customerDTO) throws InfyBankException;
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
    public void updateCustomer(Integer customerId, String emailId) throws InfyBankException;
    public void deleteCustomer(Integer customerId) throws InfyBankException;
    public List<CustomerDTO> getAllCustomers() throws InfyBankException;
}
