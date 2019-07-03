package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.sql.where.BasicSubWhereStatement;
import dev.tuxjsql.basic.sql.where.WhereSeperator;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.where.SubWhereStatement;
import dev.tuxjsql.core.sql.where.Where;

import java.util.*;

public class SQLITESubWhereStatement<T> extends BasicSubWhereStatement<T> {

    public SQLITESubWhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public SQLITESubWhereStatement(TuxJSQL core) {
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
    public Map.Entry<String, Object[]> doubleBuild() {
        List<Object> values = new ArrayList<>();
        StringBuilder builder = new StringBuilder("(");
        for (Object object : whereObjects) {
            if (object instanceof WhereSeperator) {
                builder.append(((WhereSeperator) object).name()).append(" ");
            } else if (object instanceof Where) {
                values.add(((Where) object).getValue());
                builder.append("`").append(((Where) object).getKey()).append("`").append(((Where) object).getComparator()).append("?").append(" ");
            } else if (object instanceof SubWhereStatement) {
                values.addAll(Arrays.asList(((SubWhereStatement) object).getValues()));
                builder.append(((SubWhereStatement) object).getQuery()).append(" ");
            }
        }
        builder.append(")");
        return new AbstractMap.SimpleEntry<>(builder.toString(), values.toArray());
    }
}
