package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private String name;
    private long id;
}
