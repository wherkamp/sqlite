package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.where.BasicSubWhereStatement;
import dev.tuxjsql.basic.sql.where.BasicWhereResponse;
import dev.tuxjsql.basic.sql.where.WhereSeperator;
import dev.tuxjsql.basic.sql.where.WhereUtils;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.where.SubWhereStatement;
import dev.tuxjsql.core.sql.where.Where;

import java.util.*;

public class SQLITESubWhereStatement<T> extends BasicSubWhereStatement<T> {
    private BasicWhereResponse response;
    public SQLITESubWhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public SQLITESubWhereStatement(TuxJSQL core) {
        super(core);
    }

    @Override
    public String getQuery() {
        if(response==null){
            response = WhereUtils.doubleBuild(whereObjects.toArray(),table);
        }
        return response.getQuery();
    }

    @Override
    public Object[] getValues() {
        if(response==null){
            response = WhereUtils.doubleBuild(whereObjects.toArray(),table);
        }
        return response.getValues();
    }

}
