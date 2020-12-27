package me.kingtux.tuxjsql.sqlite;

import me.kingtux.tuxjsql.basic.builders.BasicTableBuilder;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.sql.SQLTable;

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
