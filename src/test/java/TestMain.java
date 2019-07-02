import dev.tuxjsql.basic.sql.BasicDataTypes;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.TuxJSQLBuilder;
import dev.tuxjsql.core.sql.SQLTable;
import org.junit.jupiter.api.Test;

import java.util.Properties;

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
    }
}
