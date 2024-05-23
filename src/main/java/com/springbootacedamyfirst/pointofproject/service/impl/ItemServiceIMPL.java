package com.springbootacedamyfirst.pointofproject.service.impl;
import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;
import com.springbootacedamyfirst.pointofproject.entity.Item;
import com.springbootacedamyfirst.pointofproject.repo.ItemRepo;
import com.springbootacedamyfirst.pointofproject.service.ItemService;
import com.springbootacedamyfirst.pointofproject.util.mapper.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public void addItem(RequestSaveItemDTO itemDTO) {
//        Item item = modelMapper.map(itemDTO,Item.class);

        Item item = itemMapper.requestDTOToEntity(itemDTO);
        item.setActiveState(false);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
        }
    }
    @Override
    public List<ItemDTO> getItemByName(String itemName) {
        List<Item>items = itemRepo.findAllByItemNameIs(itemName);
//        List<ItemDTO>itemDTOS = itemMapper.entityListToDtoList(items);
        List<ItemDTO>itemDTOS = itemMapper.entityListToDTOList(items);
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> item = itemRepo.findAll();
        List<ItemDTO>itemDTOS = itemMapper.entityListToDTOList(item);
        return itemDTOS;
    }
}
