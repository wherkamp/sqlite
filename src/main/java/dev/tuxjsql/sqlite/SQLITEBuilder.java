package dev.tuxjsql.sqlite;

import dev.tuxjsql.basic.builders.BasicSQLBuilder;
import dev.tuxjsql.basic.sql.BasicDataTypes;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.builders.TableBuilder;
import dev.tuxjsql.core.connection.ConnectionProvider;
import dev.tuxjsql.core.connection.ConnectionSettings;
import dev.tuxjsql.core.sql.*;
import dev.tuxjsql.core.sql.select.JoinStatement;
import dev.tuxjsql.core.sql.select.SelectStatement;
import dev.tuxjsql.core.sql.where.SubWhereStatement;
import dev.tuxjsql.core.sql.where.WhereStatement;

import java.util.Properties;

public class SQLITEBuilder extends BasicSQLBuilder {
    public static final String URL = "";
    public static final String JDBC_CLASS = "";
    public static final SQLAction[] SUPPORTED_ACTIONS = {};

    @Override
    public TableBuilder createTable() {
        return null;
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
    public String key() {
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
        return null;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return null;
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) {
        provider.setup(new ConnectionSettings(jdbcClass(), String.format(URL, userProperties.getProperty("file"))), userProperties);
    }

    @Override
    public <T> ColumnBuilder<T> createColumn(T t) {
        return null;
    }
}
