package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.BasicSQLTable;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.SQLColumn;

import java.util.List;

public class SQLITETable extends BasicSQLTable {
    public SQLITETable(TuxJSQL tuxJSQL, String name, List<SQLColumn> sqlColumns) {
        super(tuxJSQL, name, sqlColumns);
    }

    @Override
    public void prepareTable() {

    }


}
