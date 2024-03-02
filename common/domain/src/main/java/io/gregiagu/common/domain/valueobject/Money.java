package io.gregiagu.common.domain.valueobject;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.google.common.base.Preconditions.*;
@Data
public class Money {
    private final BigDecimal amount;

    public Boolean isGraterThanZero() {
        return checkNotNull(amount)
                .compareTo(BigDecimal.ZERO) > 0
                ;
    }

    public Boolean isGreaterThan(Money money) {
        return checkNotNull(amount)
                .compareTo(money.getAmount()) > 0
                ;
    }

    public Money add(Money money) {
        return new Money(
                this.amount.add(money.getAmount())
        );
    }

    public Money subtract(Money money) {
        return new Money(
                setScale(
                        checkNotNull(amount)
                                .subtract(money.getAmount())
                )
        );
    }

    public Money multiply(Money money) {
        return new Money(
                setScale(
                        checkNotNull(amount)
                                .multiply(money.getAmount())
                )
        );
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
