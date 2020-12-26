package me.kingtux.tuxjsql.sqlite;

import dev.tuxjsql.core.Configuration;
import dev.tuxjsql.core.builders.SQLBuilder;
import dev.tuxjsql.core.connection.ConnectionSettings;
import dev.tuxjsql.core.tools.SimpleSupplier;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Properties;

public class SQLiteConfiguration implements Configuration<SQLiteConfiguration> {
    private String file;
    private Properties userProperties = new Properties();
    private int poolSize;

    @Override
    public Pair<ConnectionSettings, Properties> createConnection() {
        return null;
    }

    public String getFile() {
        return file;
    }

    public SQLiteConfiguration setFile(String file) {
        this.file = file;
        return this;
    }

    @Override
    public Properties getUserProperties() {
        return userProperties;
    }

    @Override
    public SQLiteConfiguration setUserProperties(Properties properties) {
        this.userProperties = properties;
        return this;
    }

    @Override
    public SQLiteConfiguration loadFromProperties(Properties properties) {
        file = properties.getProperty("db.file");
        this.userProperties = properties;
        return this;
    }

    @Override
    public SQLiteConfiguration setThreadPoolSize(int i) {
        poolSize = i;
        return this;
    }

    @Override
    public SimpleSupplier<SQLBuilder> getSQLBuilder() {
        return SQLiteBuilder::new;
    }

    @Override
    public int getThreadPoolSize() {
        return poolSize;
    }
}
