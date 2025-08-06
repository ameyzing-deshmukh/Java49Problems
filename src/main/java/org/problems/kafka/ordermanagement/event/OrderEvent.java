package org.problems.kafka.ordermanagement.event;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private Integer orderNumber;
    private Integer orderValue;
    private String customerName;
}
