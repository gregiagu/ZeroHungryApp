package io.gregiagu.common.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseEntity<ID> {
    private ID _id;
}
