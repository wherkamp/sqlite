package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.where.BasicWhereResponse;
import dev.tuxjsql.basic.sql.where.BasicWhereStatement;
import dev.tuxjsql.basic.sql.where.WhereUtils;
import dev.tuxjsql.core.TuxJSQL;

public class SQLiteWhereStatement<T> extends BasicWhereStatement<T> {
    private BasicWhereResponse response;

    public SQLiteWhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public SQLiteWhereStatement(TuxJSQL core) {
        super(core);
    }

    @Override
    public String getQuery() {
        if (response == null) {
            response = WhereUtils.doubleBuild(whereObjects.toArray(), table);
        }
        return response.getQuery();
    }

    @Override
    public Object[] getValues() {
        if (response == null) {
            response = WhereUtils.doubleBuild(whereObjects.toArray(), table);
        }
        return response.getValues();
    }
}
