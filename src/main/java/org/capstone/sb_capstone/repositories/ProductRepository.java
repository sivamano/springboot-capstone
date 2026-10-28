package org.capstone.sb_capstone.repositories;

import org.capstone.sb_capstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //not mandatory
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Save() -> Create                **[If PK (Id) is not present in DB]
    // Save() -> also used for update. **[If PK (Id) is present in DB    ]
    @Override
    Product save(Product p);
}
