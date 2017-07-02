package com.lenovo.lic.interview.Endpoint;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenovo.lic.interview.Endpoint.model.Account;
import com.lenovo.lic.interview.Endpoint.repository.AccountRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testeAccountRepository() throws Exception {
        this.entityManager.persist(new Account("novo", "novo"));
        Account account = accountRepository.findByUsername("novo");
        assertThat(account.getUsername()).isEqualTo("novo");
        assertThat(account.getPassword()).isEqualTo("novo");
    }
}
