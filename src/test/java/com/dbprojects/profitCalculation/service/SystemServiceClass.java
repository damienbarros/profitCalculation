package com.dbprojects.profitCalculation.service;

import com.dbprojects.profitCalculation.entity.Customer;
import com.dbprojects.profitCalculation.entity.ServiceProvision;
import com.dbprojects.profitCalculation.entity.Shipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SystemServiceClass {

    @InjectMocks
    private SystemService systemService;

    @Mock
    private Shipment mockShipment;

    @Mock
    private Customer mockCustomer1;

    @Mock
    private Customer mockCustomer2;

    @Mock
    private ServiceProvision mockService1;

    @Mock
    private ServiceProvision mockService2;

    @BeforeEach
    void setUp() {
        // This runs before each test method
    }

    // Tests for calculateTotalIncome (FR1)

    @Test
    void calculateTotalIncome_WithMultipleCustomers_ShouldReturnCorrectSum() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(100.0);
        when(mockCustomer2.getPaymentAmount()).thenReturn(150.0);
        List<Customer> customers = Arrays.asList(mockCustomer1, mockCustomer2);
        when(mockShipment.getCustomers()).thenReturn(customers);

        // Act
        double result = systemService.calculateTotalIncome(mockShipment);

        // Assert
        assertEquals(250.0, result, 0.001);
        verify(mockShipment).getCustomers();
        verify(mockCustomer1).getPaymentAmount();
        verify(mockCustomer2).getPaymentAmount();
    }

    @Test
    void calculateTotalIncome_WithNoCustomers_ShouldReturnZero() {
        // Arrange
        when(mockShipment.getCustomers()).thenReturn(Collections.emptyList());

        // Act
        double result = systemService.calculateTotalIncome(mockShipment);

        // Assert
        assertEquals(0.0, result, 0.001);
        verify(mockShipment).getCustomers();
    }

    @Test
    void calculateTotalIncome_WithSingleCustomer_ShouldReturnCustomerAmount() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(75.50);
        List<Customer> customers = Collections.singletonList(mockCustomer1);
        when(mockShipment.getCustomers()).thenReturn(customers);

        // Act
        double result = systemService.calculateTotalIncome(mockShipment);

        // Assert
        assertEquals(75.50, result, 0.001);
        verify(mockShipment).getCustomers();
        verify(mockCustomer1).getPaymentAmount();
    }

    // Tests for calculateTotalCosts (FR2)

    @Test
    void calculateTotalCosts_WithMultipleServices_ShouldReturnCorrectSum() {
        // Arrange
        when(mockService1.getCostAmount()).thenReturn(50.0);
        when(mockService2.getCostAmount()).thenReturn(30.0);
        List<ServiceProvision> services = Arrays.asList(mockService1, mockService2);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        double result = systemService.calculateTotalCosts(mockShipment);

        // Assert
        assertEquals(80.0, result, 0.001);
        verify(mockShipment).getServiceProv();
        verify(mockService1).getCostAmount();
        verify(mockService2).getCostAmount();
    }

    @Test
    void calculateTotalCosts_WithNoServices_ShouldReturnZero() {
        // Arrange
        when(mockShipment.getServiceProv()).thenReturn(Collections.emptyList());

        // Act
        double result = systemService.calculateTotalCosts(mockShipment);

        // Assert
        assertEquals(0.0, result, 0.001);
        verify(mockShipment).getServiceProv();
    }

    @Test
    void calculateTotalCosts_WithSingleService_ShouldReturnServiceAmount() {
        // Arrange
        when(mockService1.getCostAmount()).thenReturn(125.75);
        List<ServiceProvision> services = Collections.singletonList(mockService1);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        double result = systemService.calculateTotalCosts(mockShipment);

        // Assert
        assertEquals(125.75, result, 0.001);
        verify(mockShipment).getServiceProv();
        verify(mockService1).getCostAmount();
    }

    // Tests for calculateProfitOrLoss (FR3)

    @Test
    void calculateProfitOrLoss_WithProfit_ShouldReturnPositiveValue() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(200.0);
        when(mockCustomer2.getPaymentAmount()).thenReturn(100.0);
        List<Customer> customers = Arrays.asList(mockCustomer1, mockCustomer2);
        when(mockShipment.getCustomers()).thenReturn(customers);

        when(mockService1.getCostAmount()).thenReturn(50.0);
        when(mockService2.getCostAmount()).thenReturn(100.0);
        List<ServiceProvision> services = Arrays.asList(mockService1, mockService2);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        double result = systemService.calculateProfitOrLoss(mockShipment);

        // Assert
        assertEquals(150.0, result, 0.001);
        verify(mockShipment).setProfitOrLoss(150.0);
    }

    @Test
    void calculateProfitOrLoss_WithLoss_ShouldReturnNegativeValue() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(100.0);
        List<Customer> customers = Collections.singletonList(mockCustomer1);
        when(mockShipment.getCustomers()).thenReturn(customers);

        when(mockService1.getCostAmount()).thenReturn(200.0);
        List<ServiceProvision> services = Collections.singletonList(mockService1);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        double result = systemService.calculateProfitOrLoss(mockShipment);

        // Assert
        assertEquals(-100.0, result, 0.001);
        verify(mockShipment).setProfitOrLoss(-100.0);
    }

    @Test
    void calculateProfitOrLoss_WithBreakEven_ShouldReturnZero() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(150.0);
        List<Customer> customers = Collections.singletonList(mockCustomer1);
        when(mockShipment.getCustomers()).thenReturn(customers);

        when(mockService1.getCostAmount()).thenReturn(150.0);
        List<ServiceProvision> services = Collections.singletonList(mockService1);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        double result = systemService.calculateProfitOrLoss(mockShipment);

        // Assert
        assertEquals(0.0, result, 0.001);
        verify(mockShipment).setProfitOrLoss(0.0);
    }

    @Test
    void calculateProfitOrLoss_ShouldSetProfitOrLossOnShipment() {
        // Arrange
        when(mockCustomer1.getPaymentAmount()).thenReturn(500.0);
        List<Customer> customers = Collections.singletonList(mockCustomer1);
        when(mockShipment.getCustomers()).thenReturn(customers);

        when(mockService1.getCostAmount()).thenReturn(300.0);
        List<ServiceProvision> services = Collections.singletonList(mockService1);
        when(mockShipment.getServiceProv()).thenReturn(services);

        // Act
        systemService.calculateProfitOrLoss(mockShipment);

        // Assert
        verify(mockShipment).setProfitOrLoss(200.0);
    }

}
