package fr.lacombe.account;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void should_have_a_balance_of_0_when_i_make_a_deposit_of_0() {
        final Account account = Account.of(0L);

        final long balance = account.deposit(0L);

        assertThat(balance).isEqualTo(0L);
    }

    @Test
    public void should_have_a_balance_of_1_when_i_make_a_deposit_of_1() {
        final Account account = Account.of(0L);

        final long balance = account.deposit(1L);

        assertThat(balance).isEqualTo(1L);
    }

    @Test
    public void should_have_a_balance_of_2_when_i_make_a_deposit_of_2() {
        final Account account = Account.of(0L);

        final long balance = account.deposit(2L);

        assertThat(balance).isEqualTo(2L);
    }

    @Test
    public void should_have_a_balance_of_3_when_i_make_a_deposit_of_3() {
        final Account account = Account.of(0L);

        final long balance = account.deposit(3L);

        assertThat(balance).isEqualTo(3L);
    }
}
