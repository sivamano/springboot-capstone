package org.capstone.sb_capstone.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;
}
