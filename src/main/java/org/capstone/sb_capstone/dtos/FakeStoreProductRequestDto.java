package org.capstone.sb_capstone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
