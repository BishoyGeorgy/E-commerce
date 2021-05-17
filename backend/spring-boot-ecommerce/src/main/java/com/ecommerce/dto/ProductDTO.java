package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
@Data
@AllArgsConstructor
public class ProductDTO {

    private long id;
    private String name;
    private String description;
    private double unitPrice;
    private String imageUrl;
}
