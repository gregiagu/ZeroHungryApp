package io.gregiagu.zha.common.domain;

import io.gregiagu.common.domain.entity.AggregateRoot;
import io.gregiagu.common.domain.entity.BaseEntity;
import io.gregiagu.common.domain.valueobject.BaseId;
import io.gregiagu.common.domain.valueobject.Money;
import io.gregiagu.common.domain.valueobject.OrderId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonDomainTest {

    @Test
    void baseEntityTest() {
        class Entity extends BaseEntity<UUID> {
        }

        Entity e = new Entity();
        e.set_id(new UUID(325465L, 3254684787897976846L));

        assertThat(e.get_id())
                .isNotNull()
                .isInstanceOf(UUID.class)
        ;
    }

    @Test
    void aggregateRootTest() {
        class Aggregate extends AggregateRoot<Long> {}

        Aggregate aggregate = new Aggregate();
        aggregate.set_id(8555532L);

        assertThat(aggregate.get_id())
                .isNotNull()
                .isInstanceOf(Long.class)
        ;
    }

    @Test
    void baseIdTest() {

        class Basic extends BaseId<Long> {
            Basic(Long value) {
                super(value);
            }
        }

        Basic basic = new Basic(5223L);

        assertThat(basic.getValue())
                .isNotNull()
                .isInstanceOf(Long.class)
                ;

        Basic newBasic = new Basic(478967859L);

        assertThat(basic)
                .isNotEqualTo(newBasic)
                ;
    }

    @Test
    void testingOrderId() {
        OrderId orderId = new OrderId(UUID.randomUUID());
        assertThat(orderId)
                .isNotNull()
                .isInstanceOf(OrderId.class)
                .isInstanceOf(BaseId.class)
                ;
    }

    @Test
    void testingMoneyLogic() {
        Money money = new Money(new BigDecimal(1000));

        assertThat(money.isGraterThanZero())
                .isTrue()
                ;

        assertThat(money.isGreaterThan(money))
                .isFalse()
                ;

        Money add = money.add(new Money(new BigDecimal(2000)));

        assertThat(add.getAmount())
                .isNotNull()
                .isInstanceOf(BigDecimal.class)
                .isEqualTo(new BigDecimal(3000))
                ;

        Money sub = money.add(new Money(new BigDecimal(500)));

        assertThat(sub.getAmount())
                .isNotNull()
                .isInstanceOf(BigDecimal.class)
                .isEqualTo(new BigDecimal(1500))
                ;
    }
}
