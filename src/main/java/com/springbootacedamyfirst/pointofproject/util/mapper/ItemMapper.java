package com.springbootacedamyfirst.pointofproject.util.mapper;

import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;
import com.springbootacedamyfirst.pointofproject.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDTOToEntity(RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListToDTOList(List<Item>items);
    List<ItemDTO> pageToList(Page<Item>items);
}
