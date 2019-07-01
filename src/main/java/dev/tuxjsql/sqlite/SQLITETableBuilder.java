package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicTableBuilder;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.sql.SQLTable;

import java.util.stream.Collectors;

public class SQLITETableBuilder extends BasicTableBuilder {
    public SQLITETableBuilder(TuxJSQL jsql) {
        super(jsql);
    }

    @Override
    public SQLTable createTable() {
        return new SQLITETable(getJsql(), getName(), getColumnBuilders().stream().map(ColumnBuilder::build).collect(Collectors.toList()));
    }
}
