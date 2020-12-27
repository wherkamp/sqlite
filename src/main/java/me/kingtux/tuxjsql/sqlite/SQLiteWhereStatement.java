package me.kingtux.tuxjsql.sqlite;

import me.kingtux.tuxjsql.basic.sql.where.BasicWhereResponse;
import me.kingtux.tuxjsql.basic.sql.where.BasicWhereStatement;
import me.kingtux.tuxjsql.basic.sql.where.WhereUtils;
import me.kingtux.tuxjsql.core.TuxJSQL;

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
