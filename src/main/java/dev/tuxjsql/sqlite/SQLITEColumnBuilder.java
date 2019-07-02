package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicColumnBuilder;
import dev.tuxjsql.core.sql.SQLColumn;

public class SQLITEColumnBuilder<T> extends BasicColumnBuilder<T> {
    public SQLITEColumnBuilder(T andValue) {
        super(andValue);
    }

    public SQLITEColumnBuilder() {
        super(null);
    }

    @Override
    public SQLColumn build() {
        return new SQLITEColumn(getName(), getDefaultValue(), getDataTypeRules(), isNotNull(), isUnique(), isAutoIncrement(), isPrimaryKey(), getForeignColumn(), getTable(), getType());
    }
}
