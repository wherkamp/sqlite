import dev.tuxjsql.basic.sql.BasicDataTypes;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.TuxJSQLBuilder;
import dev.tuxjsql.core.response.DBAction;
import dev.tuxjsql.core.response.DBInsert;
import dev.tuxjsql.core.response.DBRow;
import dev.tuxjsql.core.response.DBSelect;
import dev.tuxjsql.core.sql.SQLTable;
import dev.tuxjsql.core.sql.select.SelectStatement;
import dev.tuxjsql.core.sql.where.WhereStatement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMain {
    @Test
    public void main() {

        Properties properties = new Properties();
        properties.setProperty("db.file", "db.db");
        properties.setProperty("db.type", "dev.tuxjsql.sqlite.SQLITEBuilder");

        TuxJSQL tuxJSQL = TuxJSQLBuilder.create(properties);
        SQLTable table = tuxJSQL.createTable().setName("test").addColumn().primaryKey().autoIncrement().name("id").setDataType(BasicDataTypes.INTEGER).and().
                addColumn(cb -> {
                    cb.setDataType(BasicDataTypes.TEXT).name("name");
                }).createTable();
        SQLTable tabletwo = tuxJSQL.createTable().setName("two").addColumn().primaryKey().autoIncrement().name("id").setDataType(BasicDataTypes.INTEGER).and().addColumn(cb -> {
            cb.setDataType(BasicDataTypes.TEXT).name("name");
        }).addColumn().name("tableone").setDataType(BasicDataTypes.INTEGER).foreignColumn(table.getColumn("id")).and().createTable();
        System.out.println(table.getName());
        DBAction<DBInsert> dbInsert = table.insert().value("name", "bobby").execute();
        //DBInsert dbInsert1  = dbInsert.complete();
        //System.out.println(dbInsert1.primaryKey());
        dbInsert.queue(dbInsert1 -> assertTrue(((int) dbInsert1.primaryKey()) != 0));

        DBSelect select = table.select().column("id").column("name").where().start("id", "=", 1).and().execute().complete();
        System.out.println(select.numberOfRows());
        System.out.println(select.first().getRow("name").getAsString());
        System.out.println("Done");


    }

    @Test
    public void whereAndSubWhere() {
        Properties properties = new Properties();
        properties.setProperty("db.file", "db.db");
        properties.setProperty("db.type", "dev.tuxjsql.sqlite.SQLITEBuilder");

        TuxJSQL tuxJSQL = TuxJSQLBuilder.create(properties);
        WhereStatement whereStatement = (WhereStatement) tuxJSQL.createWhere().start("bob", "=", "32").AND().start("x", "=", 2).OR("y", "=", "x").and();
        System.out.println(whereStatement.getQuery());
        Arrays.stream(whereStatement.getValues()).forEach(System.out::println);
    }
}
