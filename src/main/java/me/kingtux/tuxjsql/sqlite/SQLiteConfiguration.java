package me.kingtux.tuxjsql.sqlite;

import me.kingtux.tuxjsql.core.Configuration;
import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import me.kingtux.tuxjsql.core.connection.ConnectionSettings;
import me.kingtux.tuxjsql.core.tools.SimpleSupplier;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.Properties;

import static me.kingtux.tuxjsql.sqlite.SQLiteBuilder.JDBC_CLASS;
import static me.kingtux.tuxjsql.sqlite.SQLiteBuilder.URL;

public class SQLiteConfiguration implements Configuration<SQLiteConfiguration> {
    private String file;
    private Properties userProperties = new Properties();
    private int poolSize;

    @Override
    public Pair<ConnectionSettings, Properties> createConnection() {
        String url;
        if (file.equalsIgnoreCase("memory")) {
            url = String.format(URL, ":memory:");
        } else {
            File file = new File(userProperties.getProperty("db.file"));
            url = String.format(URL, file.getAbsolutePath());
        }
        if (TuxJSQL.getLogger().isDebugEnabled())
            TuxJSQL.getLogger().debug(String.format("URL:%s", url));
        return Pair.of(new ConnectionSettings(JDBC_CLASS, url), userProperties);
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
