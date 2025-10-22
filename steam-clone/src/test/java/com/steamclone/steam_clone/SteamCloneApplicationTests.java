package com.steamclone.steam_clone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SteamCloneApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

    @Test
    void testDatabaseConnection() {
        assertThat(jdbcTemplate).isNotNull();
    }

}
