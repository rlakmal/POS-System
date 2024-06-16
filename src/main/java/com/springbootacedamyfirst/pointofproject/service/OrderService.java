package com.springbootacedamyfirst.pointofproject.service;

import com.springbootacedamyfirst.pointofproject.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
