package me.kingtux.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.BasicSQLTable;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.SQLColumn;

import java.util.List;

public class SQLiteTable extends BasicSQLTable {
    public SQLiteTable(TuxJSQL tuxJSQL, String name, List<SQLColumn> sqlColumns) {
        super(tuxJSQL, name, sqlColumns);
    }

    @Override
    public void prepareTable() {
        createTableIfNotExists();
    }


    public void createTableIfNotExists() {
        StringBuilder columns = new StringBuilder();
        int i = 0;
        for (SQLColumn column : sqlColumns) {
            if (i != 0) {
                columns.append(",");
            }
            columns.append(column.build());

            columns.append(" ");
            i++;
        }
        for (SQLColumn c : sqlColumns) {
            if (c.isForeignKey()) {
                columns.append(",");
                columns.append(c.foreignBuild());
                columns.append(" ");
            }
        }

        String query = String.format(Queries.CREATE_TABLE_IF_NOT_EXISTS.getString(), name, columns.toString());
        executeStatement(query);
    }
}
