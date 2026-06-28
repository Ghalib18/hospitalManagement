package com.ghalib.hospitalManagement.dto;

import com.ghalib.hospitalManagement.entity.type.BloodGroup;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BloodGroupCountEntity {

    private BloodGroup bloodGroup;
    private long count;
}
