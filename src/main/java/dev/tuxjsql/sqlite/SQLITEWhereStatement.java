package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.where.BasicWhereStatement;
import dev.tuxjsql.core.TuxJSQL;

public class SQLITEWhereStatement<T> extends BasicWhereStatement<T> {

    public SQLITEWhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public SQLITEWhereStatement(TuxJSQL core) {
        super(core);
    }

    @Override
    public String getQuery() {
        return doubleBuild().getKey();
    }

    @Override
    public Object[] getValues() {
        return doubleBuild().getValue();
    }
}
