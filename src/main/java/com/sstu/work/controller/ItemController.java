package com.sstu.work.controller;

import com.sstu.work.model.Item;
import com.sstu.work.model.User;
import com.sstu.work.model.utils.CommentRequest;
import com.sstu.work.service.ItemService;
import com.sstu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public String getItem(@PathVariable String id) {
        return "item";
    }

    //todo роль
    @DeleteMapping("/{id}")
    public String deleteItem(@AuthenticationPrincipal User user, @PathVariable String id) {
        return null;
    }

    @PostMapping("/add")
    public String addItem(@RequestBody Item item) {
        return null;
    }

    @GetMapping("/all")
    public String getAllItem(@RequestParam(required = false) String user) {
        if (user != null) {
            //TODO получить продукты юзера(поставщика) иначе все вообще, еще сделать фильтр потом
        } else {

        }
        return null;
    }

    @PostMapping("/{id}/comment")
    public String addComment(@PathVariable String id, @RequestBody CommentRequest commentRequest) {
        return null;
    }

}
