package org.capstone.sb_capstone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends Base{
    private String name;
    @OneToMany
    private List<Product> topProducts;
    @OneToMany(mappedBy="category")
    private List<Product> allProducts;
    private String description;
}
