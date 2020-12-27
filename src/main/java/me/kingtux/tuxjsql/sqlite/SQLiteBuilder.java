package me.kingtux.tuxjsql.sqlite;

import me.kingtux.tuxjsql.basic.builders.BasicSQLBuilder;
import me.kingtux.tuxjsql.basic.sql.BasicDataTypes;
import me.kingtux.tuxjsql.basic.sql.select.BasicJoinStatement;
import me.kingtux.tuxjsql.core.Configuration;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.builders.ColumnBuilder;
import me.kingtux.tuxjsql.core.builders.TableBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionProvider;
import me.kingtux.tuxjsql.core.connection.ConnectionSettings;
import me.kingtux.tuxjsql.core.sql.*;
import me.kingtux.tuxjsql.core.sql.select.JoinStatement;
import me.kingtux.tuxjsql.core.sql.select.SelectStatement;
import me.kingtux.tuxjsql.core.sql.where.SubWhereStatement;
import me.kingtux.tuxjsql.core.sql.where.WhereStatement;

import java.io.File;
import java.util.Properties;

public final class SQLiteBuilder extends BasicSQLBuilder {
    public static final String URL = "jdbc:sqlite:%1$s";
    public static final String JDBC_CLASS = "org.sqlite.JDBC";
    @Override
    public TableBuilder createTable() {
        return new SQLiteTableBuilder(tuxJSQL);
    }

    @Override
    public ColumnBuilder createColumn() {
        return new SQLiteColumnBuilder(tuxJSQL);
    }

    @Override
    public WhereStatement createWhere() {
        return new SQLiteWhereStatement(tuxJSQL);
    }

    @Override
    public SubWhereStatement createSubWhereStatement() {
        return new SQLiteSubWhereStatement(tuxJSQL);
    }

    @Override
    public <T> WhereStatement<T> createWhere(T t) {
        return new SQLiteWhereStatement<>(t, tuxJSQL);
    }

    @Override
    public <T> SubWhereStatement<T> createSubWhereStatement(T t) {
        return new SQLiteSubWhereStatement<>(t, tuxJSQL);
    }

    @Override
    public SelectStatement createSelectStatement() {
        return new SQLiteSelectStatement(tuxJSQL);
    }

    @Override
    public JoinStatement createJoinStatement(SelectStatement basicSelectStatement) {
        return new BasicJoinStatement(basicSelectStatement);
    }


    @Override
    public UpdateStatement createUpdateStatement() {
        return new SQLiteUpdateStatement(tuxJSQL);
    }

    @Override
    public DeleteStatement createDeleteStatement() {
        return new SQLiteDeleteStatement(tuxJSQL);
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
    public SQLDataType convertDataType(BasicDataTypes dataType) {
        return dataType;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return new SQLiteInsertStatement(tuxJSQL);
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) throws Exception{
        String url;
        if (userProperties.getProperty("db.file").equalsIgnoreCase("memory")) {
            url = String.format(URL, ":memory:");
        } else {
            File file = new File(userProperties.getProperty("db.file"));
            url = String.format(URL, file.getAbsolutePath());
        }
        if (TuxJSQL.getLogger().isDebugEnabled())
            TuxJSQL.getLogger().debug(String.format("URL:%s", url));
        provider.setup(new ConnectionSettings(jdbcClass(), url), userProperties);
    }

    @Override
    public void configureConnectionProvider(Configuration configuration) throws Exception {

    }

    @Override
    public <T> ColumnBuilder<T> createColumn(T t) {
        return new SQLiteColumnBuilder<>(tuxJSQL,t);
    }
}
