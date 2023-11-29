package com.example.kicktheworld_test.Cart.Service;

import com.example.kicktheworld_test.Cart.Dto.OrderDto;
import com.example.kicktheworld_test.Cart.Dto.OrderHistDto;
import com.example.kicktheworld_test.Cart.Dto.OrderItemDto;
import com.example.kicktheworld_test.Cart.Entity.Order;
import com.example.kicktheworld_test.Cart.Entity.OrderItem;
import com.example.kicktheworld_test.Cart.Repository.OrderRepository;
import com.example.kicktheworld_test.Security.entity.Member;
import com.example.kicktheworld_test.Security.repository.MemberRepository;
import com.example.kicktheworld_test.Stay.Entity.Stay;
import com.example.kicktheworld_test.Stay.Repository.StayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final StayRepository stayRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;


    public Long order(OrderDto orderDto, String memId) {

        Stay stay = stayRepository.findById(orderDto.getStay_id())
                .orElseThrow(EntityNotFoundException::new);

        Member member = memberRepository.findByMemId(memId);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(stay, orderDto.getCount());
        orderItemList.add(orderItem);
        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }
    @Transactional
    public Page<OrderHistDto> getOrderList(String memId, Pageable pageable) {

        List<Order> orders = orderRepository.findOrders(memId, pageable);
        Long totalCount = orderRepository.countOrder(memId);

        List<OrderHistDto> orderHistDtos = new ArrayList<>();

        for (Order order : orders) {
            OrderHistDto orderHistDto = new OrderHistDto(order);
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
//                ItemImg itemImg = itemImgRepository.findByItemIdAndRepimgYn
//                        (orderItem.getItem().getId(), "Y");
                OrderItemDto orderItemDto =
                        new OrderItemDto(orderItem);
                orderHistDto.addOrderItemDto(orderItemDto);
            }

            orderHistDtos.add(orderHistDto);
        }

        return new PageImpl<OrderHistDto>(orderHistDtos, pageable, totalCount);
    }

}
