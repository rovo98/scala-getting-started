package com.rovo98.inaction.scalaindepth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCreator {
    PreparedStatement createPreparedStatement(Connection con) throws SQLException;
}
