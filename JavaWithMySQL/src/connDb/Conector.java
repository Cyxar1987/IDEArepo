package connDb;

import java.sql.*;

public class Conector {

    private static final String url = "jdbc:mysql://localhost:3306/prosadka";
    private static final String user = "root";
    private static final String password = "root";


    //  Создание подключения к БД
    public static Connection getconnDb ()
    {
            Connection conn = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                System.out.println("Не найден JDBC драйвер!!!");
                e.getMessage();
            }

            try {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
                }
            catch (SQLException sql) {
                System.out.println("Ошибка подключения к БД");
            }
            return conn;
        }

    //  Создание SQL-запроса
    public static void myQuery(String sql)
    {
        Connection conn = null;
        Statement stmt = null;

        try
        {
            conn = getconnDb();
            stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e) {  System.out.println("Проблема в подготовке SQL-запроса!!!");
            e.printStackTrace(); }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) { System.out.println("Проблема с закрытием conn или stmt!!!"); }
        }

    }

    //  Удаление всех записей из таблицы
    public static void delAll (String sql)
    {
        Connection conn = null;
        Statement stmt = null;

        try
        {
            conn = getconnDb();
            stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (SQLException e) {  System.out.println("Проблема в подготовке SQL-запроса!!!");
            e.printStackTrace(); }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) { System.out.println("Проблема с закрытием conn или stmt!!!"); }
        }

    }

    //  Проверка на наличие записей в таблице
    //  true - таблица пуста
    //  false - в таблице есть записи
    public static boolean isEmptyDB(String sql)  {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        boolean isEmpty = false;

        try
            {

            conn = getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.last();
            if ( rs.getRow() <=0 )
                { isEmpty = true; }
            else
                { isEmpty = false; }
            }
        catch (SQLException exp)    { System.out.println("Чето не то в методе isEmptyDB !!!"); }

        finally
        {
            try
            {
                if (conn != null)
                    { conn.close(); }

                if (stmt != null)
                    { stmt.close(); }

                if (rs != null)
                    { rs.close(); }
            }
            catch (SQLException e) { System.out.println("Проблема с закрытием conn или stmt!!!"); }
        }

        return isEmpty;


    }

    //   Пока не использую!
    public static void myResult (String sql)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int x = rs.getMetaData().getColumnCount();

            while (rs.next()){
                for (int i = 1; i <= x; i++)
                {
                    System.out.println(rs.getString(i));
                    System.out.println();
                }
            }

        }
        catch (Exception e) {
            System.out.println("Проблема в подготовке SQL-запроса!!!");
            e.printStackTrace();
        }

        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException e) { System.out.println("Проблема с закрытием conn или stmt!!!"); }
        }

    }


}
