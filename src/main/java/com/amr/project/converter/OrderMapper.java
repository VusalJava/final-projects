package com.amr.project.converter;

import ch.qos.logback.core.status.StatusManager;
import com.amr.project.model.dto.OrderDto;
import com.amr.project.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ItemMapper.class, AddressMapper.class, StatusManager.class})
public interface OrderMapper extends MapperInterface<OrderDto, Order> {
    @Mapping(target = "userId", source = "user.id")
    @Override
    OrderDto toDto(Order entity);
}