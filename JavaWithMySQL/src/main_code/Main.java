package main_code;

import connDb.Conector;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        //   Переменная str - SQL-запрос
        String sql1 = "CREATE TABLE IF NOT EXISTS my_table " +
                "(number_id INT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(20)," +
                " family VARCHAR(35)," +
                " phone VARCHAR(12)," +
                "PRIMARY KEY (number_id))";
        String sql2 = "INSERT INTO my_table (name, family, phone)" +
                      "VALUES" +
                      "('Роман', 'Овсянников','+79058569220')";

        String sql3 = "DROP TABLE my_table";

        String sql4 = "CREATE TABLE IF NOT EXISTS my_table " +
                "(number_id INT," +
                " name VARCHAR(20)," +
                " family VARCHAR(35)," +
                " phone VARCHAR(12))";

        String sql5 = "SELECT* FROM my_table";


        try {
            //Conector.myQuery(sql2);
            Conector.myResult(sql5);
        }
        catch (SQLException e)  {}


    }
}
