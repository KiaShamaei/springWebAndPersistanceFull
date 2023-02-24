package com.webMvc.service.model;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto {
    @NotBlank(message = "in bayad por bashe")
    private String name ;
    @NotNull(message = "product.description")
    private String description;
    private Long price;
}
