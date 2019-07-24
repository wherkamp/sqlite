package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicColumnBuilder;
import dev.tuxjsql.core.sql.SQLColumn;

public class SQLiteColumnBuilder<T> extends BasicColumnBuilder<T> {
    public SQLiteColumnBuilder(T andValue) {
        super(andValue);
    }

    public SQLiteColumnBuilder() {
        super(null);
    }

    @Override
    public SQLColumn build() {
        return new SQLiteColumn(getName(), getDefaultValue(), getDataTypeRules(), isNotNull(), isUnique(), isAutoIncrement(), isPrimaryKey(), getForeignColumn(), getTable(), getType());
    }
}
