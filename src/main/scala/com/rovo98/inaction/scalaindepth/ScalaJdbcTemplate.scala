package com.rovo98.inaction.scalaindepth

import java.sql.{Connection, PreparedStatement, ResultSet}

trait ScalaJdbcTemplate {
  def query[ResultItem](psc: Connection => PreparedStatement,
            rowMapper: (ResultSet, Int) => ResultItem): List[ResultItem]
}
