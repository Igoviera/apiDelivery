package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.enums.OrderStatus;
import com.igo.apiDelivery.enums.PaymentMethod;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Embeddable
public record BagDTO (
        Long client,
        BigDecimal Total,
        boolean closed,
        PaymentMethod paymentMethod,
        LocalDateTime createdAt,
        String clientName,
        OrderStatus status,
        List<ItemDTO> items
) {}
