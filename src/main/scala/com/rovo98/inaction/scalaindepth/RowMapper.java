package com.rovo98.inaction.scalaindepth;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    Object mapRow(ResultSet rs, int rowNum) throws SQLException;
}
