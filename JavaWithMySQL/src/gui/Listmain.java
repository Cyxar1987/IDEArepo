package gui;

import com.sun.security.auth.SolarisNumericUserPrincipal;
import connDb.Conector;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Listmain extends JPanel {

    JScrollPane scrollPane;
    JList myList;
    DefaultListModel dflm;

    private final String QUESTION = "SELECT* FROM between_table";
    private final String IF_NOT_EMPTY = "SELECT depth FROM between_table";

    ArrayList<Double> arr;


    public Listmain () {

        super();
        setPreferredSize(new Dimension(150, 150));


        if (Conector.isEmptyDB(QUESTION) == true)    //  Таблица пуста, рисуем пустой JList
        {
            dflm = new DefaultListModel();
            myList = new JList(dflm);
            myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane = new JScrollPane(myList);
            scrollPane.setPreferredSize(new Dimension(80,80));
            add(scrollPane);
        }
        else    //  В таблице есть записи, рисуем JList из таблицы between_table
          {
          arr = new ArrayList<Double>();
          arr = depthArr();

            //  Рисуем JList из БД
           dflm = new DefaultListModel();
           myList = new JList(dflm);
           myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

           scrollPane = new JScrollPane(myList);
           scrollPane.setPreferredSize(new Dimension(100,120));
           add(scrollPane);

            for (Double d : arr) {
                dflm.addElement(d);
            }

          }
    }


    public void addUppdateList()
    {
        arr = new ArrayList<Double>();
        arr = depthArr();

        DefaultListModel dlm = new DefaultListModel();
        dlm = (DefaultListModel)myList.getModel();
        dlm.clear();

        for (Double d : arr)
            { dlm.addElement(String.valueOf(d)); }
    }

    //  метод для получения из БД массива глубин (отсортированный)
    private ArrayList depthArr ()
    {
        //  Считыываем данные с БД
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conector.getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(IF_NOT_EMPTY);

            //  Массив для хранения данных полученных с resultset
            arr = new ArrayList<Double>();

            //  Заполняем массив данными о глубинах (depth) из БД
            while (rs.next()) {
                arr.add(rs.getDouble("depth"));
            }
        }
        catch (SQLException sql) {System.out.println("Не получается построить JList  из БД!!!");}

        finally {
            try {
                if (conn != null) {conn.close();}
                if (stmt != null) {stmt.close();}
                if (rs != null) {rs.close();}
            }
            catch (SQLException exp) { System.out.println("Ошибка с закрытием conn, stmt, rs");}
        }

        //  Сортируем массив
        Collections.sort(arr);

        return arr;
    }
}
