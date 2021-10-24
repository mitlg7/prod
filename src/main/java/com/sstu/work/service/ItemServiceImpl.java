package com.sstu.work.service;

import com.sstu.work.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Override
    public Item getItemById(String id) {
        return null;
    }

    @Override
    public void createItem(Item item) {

    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public List<Item> getAllItemsByUserId(String userId) {
        return null;
    }
}
