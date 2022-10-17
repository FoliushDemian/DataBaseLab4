package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {
    private Integer id;
    private String name;
    private String price;
    private String expirationDate;
    private Integer customerId;
}
