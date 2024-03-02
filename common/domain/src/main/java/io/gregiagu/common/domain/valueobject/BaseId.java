package io.gregiagu.common.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class BaseId<T> {
    private final T value;
}
