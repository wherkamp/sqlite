package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicSQLBuilder;
import dev.tuxjsql.basic.sql.BasicDataTypes;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.builders.TableBuilder;
import dev.tuxjsql.core.connection.ConnectionProvider;
import dev.tuxjsql.core.connection.ConnectionSettings;
import dev.tuxjsql.core.sql.*;
import dev.tuxjsql.core.sql.select.JoinStatement;
import dev.tuxjsql.core.sql.select.SelectStatement;
import dev.tuxjsql.core.sql.where.SubWhereStatement;
import dev.tuxjsql.core.sql.where.WhereStatement;

import java.io.File;
import java.util.Properties;

public final class SQLITEBuilder extends BasicSQLBuilder {
    public static final String URL = "jdbc:sqlite:%1$s";
    public static final String JDBC_CLASS = "org.sqlite.JDBC";
    public static final SQLAction[] SUPPORTED_ACTIONS = {SQLAction.SELECT, SQLAction.INSERT, SQLAction.UPDATE, SQLAction.DELETE};
    @Override
    public TableBuilder createTable() {
        return new SQLITETableBuilder(tuxJSQL);
    }

    @Override
    public ColumnBuilder createColumn() {
        return null;
    }

    @Override
    public WhereStatement createWhere() {
        return null;
    }

    @Override
    public SubWhereStatement createSubWhereStatement() {
        return null;
    }

    @Override
    public <T> WhereStatement<T> createWhere(T t) {
        return null;
    }

    @Override
    public <T> SubWhereStatement<T> createSubWhereStatement(T t) {
        return null;
    }

    @Override
    public SelectStatement createSelectStatement() {
        return null;
    }

    @Override
    public JoinStatement createJoinStatement(SelectStatement basicSelectStatement) {
        return null;
    }


    @Override
    public UpdateStatement createUpdateStatement() {
        return null;
    }

    @Override
    public DeleteStatement createDeleteStatement() {
        return null;
    }

    @Override
    public String name() {
        return "SQLITE";
    }

    @Override
    public String jdbcClass() {
        return JDBC_CLASS;
    }

    @Override
    public SQLAction[] supportedActions() {
        return SUPPORTED_ACTIONS;
    }

    @Override
    public SQLDataType convertDataType(BasicDataTypes dataType) {
        return dataType;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return null;
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) {
        String url;
        if (userProperties.getProperty("file").equalsIgnoreCase("memory")) {
            url = String.format(URL, ":memory:");
        } else {
            File file = new File(userProperties.getProperty("file"));
            url = String.format(URL, file.getAbsolutePath());
        }
        if (TuxJSQL.getLogger().isDebugEnabled())
            TuxJSQL.getLogger().debug(String.format("URL:%s", url));
        provider.setup(new ConnectionSettings(jdbcClass(), url), userProperties);
    }

    @Override
    public <T> ColumnBuilder<T> createColumn(T t) {
        return new SQLITEColumnBuilder<>(t);
    }
}
