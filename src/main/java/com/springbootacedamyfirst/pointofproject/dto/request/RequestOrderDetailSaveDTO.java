package com.springbootacedamyfirst.pointofproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RequestOrderDetailSaveDTO {

    private String itemName;
    private double qty;
    private double amount;
    private int items;

}
