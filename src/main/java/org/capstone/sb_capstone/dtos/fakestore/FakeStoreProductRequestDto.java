package org.capstone.sb_capstone.dtos.fakestore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
