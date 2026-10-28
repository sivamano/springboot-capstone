package org.capstone.sb_capstone.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Base {
    @Id
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
    private boolean isDeleted;


}
