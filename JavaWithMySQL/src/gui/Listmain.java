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

    JList myList;
    DefaultListModel dflm;

    private final String QUESTION = "SELECT* FROM between_table";
    private final String IS_NOT_EMPTY = "SELECT depth FROM between_table";

    ArrayList<Double> arrDouble;
   // ArrayList<String> arrString;


    public Listmain (){

        super();
        setPreferredSize(new Dimension( 100, 100));


        if  ( Conector.isEmptyDB(QUESTION) == true )    //  Таблица пуста, рисуем пустой JList
            {
                dflm = new DefaultListModel();
                myList = new JList(dflm);
                add(myList);
            }

        else    //  В таблице есть записи, рисуем JList из таблицы between_table
            {
                //  Считыываем данные с БД
                try
                {
                    Connection conn = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    conn = Conector.getconnDb();
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(IS_NOT_EMPTY);

                    //  Массив для хранения данных полученных с resultset
                    arrDouble = new ArrayList<Double>();

                    //  Заполняем массив данными о глубинах (depth) из БД
                    while (rs.next())
                        {
                        arrDouble.add(rs.getDouble("depth"));
                        }

                }
                catch (SQLException sql)  {  System.out.println("Не получается построить JList  из БД!!!");  }

                //  Сортируем массив
                Collections.sort(arrDouble);
/*
                //  Создаем массив String и преобразуем элементы массива arrDouble в String
                arrString = new ArrayList<String>();

                for(Double d : arrDouble)
                {
                    arrString.add(String.valueOf(d));
                }
*/

                dflm = new DefaultListModel();
                myList = new JList(dflm);

                for(Double d : arrDouble)
                {
                    addEl(String.valueOf(d));
                }

                add(myList);
            }

    }

    public void addEl(String str) {

        DefaultListModel d = (DefaultListModel)myList.getModel();
        d.addElement(str);

        //  TODO
        //  Сделать так чтобы JList динамически сортировался при добавлении нового элемента

    }

    public void removeEl(){
        //  TODO    Сделать метод удаления элемента из JList
    }

}
