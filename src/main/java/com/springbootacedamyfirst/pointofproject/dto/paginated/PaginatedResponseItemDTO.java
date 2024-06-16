package com.springbootacedamyfirst.pointofproject.dto.paginated;

import com.springbootacedamyfirst.pointofproject.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long dataCount;



}
