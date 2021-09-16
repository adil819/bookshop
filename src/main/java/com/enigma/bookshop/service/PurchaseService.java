package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Purchase;

public interface PurchaseService {
    Purchase transaction(Purchase purchase);
}
