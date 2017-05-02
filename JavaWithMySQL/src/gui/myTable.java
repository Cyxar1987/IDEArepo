package gui;


import calculation.Prosadka;
import connDb.Conector;
import geol_data.MonolitData;
import geol_data.MonolitDataComparator;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


/** Класс описывающий создание таблицы и  проведения расчета в ней просадки от собственного веса
 *  Данные будут получаться из БД*/

public class myTable extends JFrame {

    private myTableModel mtm;

    JPanel panel;

    private JTable myTable;
    private JScrollPane scrollPane;

    //  SQL-запрос на получение всех данных из таблицы between_table
    private final String DATA = "SELECT * FROM between_table";

    //  Ссылка на класс для сортировки объектов MonolitData
    MonolitDataComparator comparator;

    // Массив с полями таблицы полученный из БД
    private ArrayList<MonolitData> arrTable;

    //  Конструктор
    public myTable() {

        super();

        setTitle("Prossadka");
        setLocationRelativeTo(null);
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bd = new BorderLayout();

        setLayout(bd);

        mtm = new myTableModel(getSortArrTable());

        myTable = new JTable(mtm);
        scrollPane = new JScrollPane(myTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Метод получения массива c монолитами (ArrayList<MonolitData>) из БД, отсортированный по глубине
     * с помощью класса MonolitDataComparator   */
    public ArrayList<MonolitData> getSortArrTable() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        comparator = new MonolitDataComparator();
        arrTable = new ArrayList<MonolitData>();

        try {
            conn = Conector.getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(DATA);
            //  Заполняем массив данными из БД
            while (rs.next()) {
                arrTable.add(new MonolitData(rs.getInt("ige"), rs.getDouble("depth"),
                   rs.getDouble("mochnost"), rs.getDouble("water"), rs.getDouble("density"),
                   new double[] {rs.getDouble("stage005"), rs.getDouble("stage010"), rs.getDouble("stage015"),
                   rs.getDouble("stage020"),rs.getDouble("stage025"), rs.getDouble("stage030")}, rs.getDouble("density4g")));
            }
        }
        catch (SQLException sql) {System.out.println("Не получается построить arrTable из БД!!!");}

        finally {
            try {
                if (conn != null) {conn.close();}
                if (stmt != null) {stmt.close();}
                if (rs != null) {rs.close();}
            }
            catch (SQLException exp) { System.out.println("Ошибка с закрытием conn, stmt, rs");}
        }

     //----------------Сортируем arrTable по возрастанию глубины------------------------
        Collections.sort(arrTable, comparator);

        Prosadka.SchetFirstPressure(arrTable);
        Prosadka.SchetPBit(arrTable);
        Prosadka.SchetOtnositProsad(arrTable);

        return arrTable;
    }
}