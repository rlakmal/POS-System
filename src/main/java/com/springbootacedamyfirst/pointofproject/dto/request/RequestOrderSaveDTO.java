package com.springbootacedamyfirst.pointofproject.dto.request;

import com.springbootacedamyfirst.pointofproject.entity.Customer;
import com.springbootacedamyfirst.pointofproject.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestOrderSaveDTO {

    private int customer;
    private Date orderDate;
    private double totalAmount;
    private List<RequestOrderDetailSaveDTO> orderDetail;
}
