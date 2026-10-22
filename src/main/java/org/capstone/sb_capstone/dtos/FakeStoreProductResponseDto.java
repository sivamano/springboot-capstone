package org.capstone.sb_capstone.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;

}
