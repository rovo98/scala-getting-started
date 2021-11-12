package com.rovo98.inaction.scalaindepth;

import java.util.List;

// from springboot
public interface JdbcTemplate {
    List query(PreparedStatementCreator psc, RowMapper rowMapper);
}
