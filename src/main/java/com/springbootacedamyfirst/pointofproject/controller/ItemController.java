package com.springbootacedamyfirst.pointofproject.controller;

import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;
import com.springbootacedamyfirst.pointofproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody RequestSaveItemDTO itemDTO){
        itemService.addItem(itemDTO);
        //System.out.println(customerDTO);
        return "saved";
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemDTO> getItemByName(@RequestParam(value = "name") String itemName){
        List<ItemDTO> itemDTOS = itemService.getItemByName(itemName);
        return itemDTOS;

    }
    @GetMapping(path = {"/get-all-items"})
    public List<ItemDTO> getAllItems(){
        List<ItemDTO>itemDTOS = itemService.getAllItems();
        return itemDTOS;
    }





}
