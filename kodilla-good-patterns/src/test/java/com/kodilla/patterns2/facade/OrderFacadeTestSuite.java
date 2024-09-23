package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.ItemDto;
import com.kodilla.patterns2.facade.api.OrderDto;
import com.kodilla.patterns2.facade.api.OrderFacade;
import com.kodilla.patterns2.facade.api.OrderProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderFacadeTestSuite {

    @Autowired
    private OrderFacade orderFacade;

    @Test
    public void testProcessOrderLogging() throws OrderProcessingException {
        // Given
        OrderDto order = new OrderDto();

        order.getItems().add(new ItemDto(1L, 2));

        Long userId = 123L;

        // When
        orderFacade.processOrder(order, userId);

    }
}
