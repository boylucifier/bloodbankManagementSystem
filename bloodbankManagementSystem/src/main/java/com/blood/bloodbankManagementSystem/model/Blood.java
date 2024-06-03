package com.blood.bloodbankManagementSystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Embeddable
public class Blood {
    private BloodGroups bloodGroup;
    private long rbc;
    private long wbc;
}
