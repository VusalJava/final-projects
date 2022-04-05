package com.amr.project.model.dto;

import com.amr.project.model.enums.Status;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
@ToString
public class OrderDto {
    private Long id;
    private List<Long> itemsId;
    private Calendar date;
    private Status status;
    private Long address;
    private BigDecimal total;
    private Long userId;
    private String buyerName;
    private String buyerPhone;
}