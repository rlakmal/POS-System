package com.springbootacedamyfirst.pointofproject.controller;

import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;
import com.springbootacedamyfirst.pointofproject.service.ItemService;
import com.springbootacedamyfirst.pointofproject.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemDTO>itemDTOS = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",itemDTOS), HttpStatus.OK
        );
    }


    @GetMapping(
            path = {"/get-all-items-active"},
            params = {"page","size","activeState"}
    )
    public ResponseEntity<StandardResponse> getAllItemsActive(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState") boolean activeState
    ){
        PaginatedResponseItemDTO paginatedResponseItemDTO  = itemService.getAllItemsActive(page,size,activeState);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",paginatedResponseItemDTO), HttpStatus.OK
        );
    }



}
