package com.springbootacedamyfirst.pointofproject.service;


import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;

import java.util.List;

public interface ItemService {
    void addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getItemByName(String itemName);

    List<ItemDTO> getAllItems();
}
