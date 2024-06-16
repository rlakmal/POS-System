package com.springbootacedamyfirst.pointofproject.controller;

import com.springbootacedamyfirst.pointofproject.dto.request.RequestOrderSaveDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestSaveItemDTO;
import com.springbootacedamyfirst.pointofproject.service.OrderService;
import com.springbootacedamyfirst.pointofproject.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin



public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        String id = orderService.addOrder(requestOrderSaveDTO);
        System.out.println(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,2+"Success",2), HttpStatus.OK
        );
    }
}
