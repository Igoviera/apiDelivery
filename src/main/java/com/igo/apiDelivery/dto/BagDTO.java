package com.igo.apiDelivery.dto;

import com.igo.apiDelivery.enums.PaymentMethod;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Embeddable
public record BagDTO (
        Long client,
        BigDecimal Total,
        boolean closed,
        PaymentMethod paymentMethod,
        LocalDate createdAt,
        String clientName,
        List<ItemDTO> items
) {}
