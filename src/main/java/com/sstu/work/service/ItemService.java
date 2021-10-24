package com.sstu.work.service;

import com.sstu.work.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    Item getItemById(String id);

    void createItem(Item item);

    void deleteItem(String itemId);

    List<Item> getAllItems();

    List<Item> getAllItemsByUserId(String userId);
}

