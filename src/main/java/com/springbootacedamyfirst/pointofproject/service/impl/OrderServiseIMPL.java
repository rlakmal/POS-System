package com.springbootacedamyfirst.pointofproject.service.impl;
import com.springbootacedamyfirst.pointofproject.dto.CustomerDTO;
import com.springbootacedamyfirst.pointofproject.dto.request.RequestOrderSaveDTO;
import com.springbootacedamyfirst.pointofproject.entity.Order;
import com.springbootacedamyfirst.pointofproject.entity.OrderDetail;
import com.springbootacedamyfirst.pointofproject.repo.CustomerRepo;
import com.springbootacedamyfirst.pointofproject.repo.ItemRepo;
import com.springbootacedamyfirst.pointofproject.repo.OrderDetailRepo;
import com.springbootacedamyfirst.pointofproject.repo.OrderRepo;
import com.springbootacedamyfirst.pointofproject.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiseIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getOrderDate(),
                requestOrderSaveDTO.getTotalAmount()
        );
        orderRepo.save(order);
        if(orderRepo.existsById(order.getOrderId())){
            List<OrderDetail> orderDetails =  modelMapper.
                    map(requestOrderSaveDTO.getOrderDetail(),new TypeToken<List<OrderDetail>>(){
                    }.getType());
            for(int i=0;i< orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getReferenceById(requestOrderSaveDTO.getOrderDetail().get(i).getItems()));

            }

            if(orderDetails.size()>0){
                orderDetailRepo.saveAll(orderDetails);

            }


        }

        return "null";
    }
}
