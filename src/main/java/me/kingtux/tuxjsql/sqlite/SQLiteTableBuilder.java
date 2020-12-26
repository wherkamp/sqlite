package me.kingtux.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicTableBuilder;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.sql.SQLTable;

import java.util.stream.Collectors;

public class SQLiteTableBuilder extends BasicTableBuilder {
    public SQLiteTableBuilder(TuxJSQL jsql) {
        super(jsql);
    }

    @Override
    public SQLTable createTable() {
        SQLiteTable table = new SQLiteTable(getJsql(), getName(), getColumnBuilders().stream().map(ColumnBuilder::build).collect(Collectors.toList()));
        getJsql().getExecutor().execute(table::prepareTable);
        table.prepareTable();
        getJsql().addTable(table);
        return table;
    }
}
