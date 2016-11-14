package main_code;

import connDb.Conector;
import geol_data.MonolitData;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        MonolitData m1 = new MonolitData(1,1,1, 2.1, 0.152);

        System.out.println(m1.getDensity_sg());






























/*
        //   Переменная str - SQL-запрос
        String sql1 = "CREATE TABLE IF NOT EXISTS my_table " +
                "(number_id INT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(20)," +
                " family VARCHAR(35)," +
                " phone VARCHAR(12)," +
                "PRIMARY KEY (number_id))";
        String sql2 = "INSERT INTO my_table (name, family, phone)" +
                      "VALUES" +
                      "('Roman', 'Ovsiannikov','+79058569220')";

        String sql3 = "DROP TABLE my_table";

        String sql4 = "CREATE TABLE IF NOT EXISTS my_table " +
                "(number_id INT," +
                " name VARCHAR(20)," +
                " family VARCHAR(35)," +
                " phone VARCHAR(12))";

        String sql5 = "SELECT* FROM my_table";

        String sql6 = "DELETE FROM my_table";


            //Conector.myResult(sql5);
            //Conector.myQuery(sql2);
            //Conector.delAll(sql6);


*/
    }
}
