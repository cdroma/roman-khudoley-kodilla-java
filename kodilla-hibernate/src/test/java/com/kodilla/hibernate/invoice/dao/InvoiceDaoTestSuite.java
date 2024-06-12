package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    @DisplayName("Saving the invoice")
    void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Fish & Chips");
        Product product2 = new Product("PlayStation 5");
        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(product2, new BigDecimal(50), 4, new BigDecimal(200));

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Invoice invoice = new Invoice("INV/2024/06/12/001");
        invoice.setItems(items);

        // Setting bi-directional relation
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        // Then
        assertNotNull(id);

        // Clean-Up
        invoiceDao.deleteById(id);
        productDao.deleteAll();
    }
}
