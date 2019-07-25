package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicColumnBuilder;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.SQLColumn;

public class SQLiteColumnBuilder<T> extends BasicColumnBuilder<T> {
    public SQLiteColumnBuilder(TuxJSQL tuxJSQL, T andValue) {
        super(tuxJSQL,andValue);
    }

    public SQLiteColumnBuilder(TuxJSQL tuxJSQL) {
        this(tuxJSQL,null);
    }



    @Override
    public SQLColumn build() {
        return new SQLiteColumn(getName(), getDefaultValue(), getDataTypeRules(), isNotNull(), isUnique(), isAutoIncrement(), isPrimaryKey(), getForeignColumn(), getTable(), getType(),tuxJSQL);
    }
}
