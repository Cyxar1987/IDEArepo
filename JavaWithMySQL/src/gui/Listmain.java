package gui;


import connDb.Conector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Listmain extends JPanel {

    JScrollPane scrollPane;
    JList myList;
    DefaultListModel dflm;

    private final String QUESTION = "SELECT* FROM between_table";
    private final String IF_NOT_EMPTY = "SELECT depth FROM between_table";

    ArrayList<Double> arr;

    // конструктор класса
    public Listmain () {

        super();
        setPreferredSize(new Dimension(150, 150));


        if (Conector.isEmptyDB(QUESTION) == true)    //  Таблица пуста, рисуем пустой JList
        {
            dflm = new DefaultListModel();
            myList = new JList(dflm);
            myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane = new JScrollPane(myList);
            scrollPane.setPreferredSize(new Dimension(100,130));
            add(scrollPane);

        }
        else    //  В таблице есть записи, рисуем JList из таблицы between_table
          {
          arr = new ArrayList<Double>();
          arr = getDepthArr();

            //  Рисуем JList из БД
           dflm = new DefaultListModel();
           myList = new JList(dflm);
           myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

           scrollPane = new JScrollPane(myList);
           scrollPane.setPreferredSize(new Dimension(100,140));
           add(scrollPane);

            for (Double d : arr) {
                dflm.addElement(d);
            }
          }

          /**   Отображение всех данных монолита по щелчку выбранной глубины в JList    */
          myList.addListSelectionListener(new ListSelectionListener() {        //   Слушатель событий для JList
              @Override
              public void valueChanged(ListSelectionEvent e) {
                  if (!e.getValueIsAdjusting()) {
                      int index = myList.getSelectedIndex();

                      if ( index != -1)
                        {
                            String VIEW_SELECTION_INDEX = "SELECT * FROM between_table " +
                                    "WHERE depth = " + arr.get(index);
                          System.out.println(arr.get(index));

                            //  Считыываем данные с БД
                            Connection conn = null;
                            Statement stmt = null;
                            ResultSet rs = null;

                            try {
                                conn = Conector.getconnDb();
                                stmt = conn.createStatement();
                                rs = stmt.executeQuery(VIEW_SELECTION_INDEX);
                                    while (rs.next()) {
                                        Window.igeJtf.setText(String.valueOf(rs.getInt("ige")));
                                        Window.depthJtf.setText(String.valueOf(rs.getDouble("depth")));
                                        Window.mJtf.setText(String.valueOf(rs.getDouble("mochnost")));
                                        Window.waterJtf.setText(String.valueOf(rs.getDouble("water")));
                                        Window.densityJtf.setText(String.valueOf(rs.getDouble("density")));
                                        Window.density4gJtf.setText(String.valueOf(rs.getDouble("density4g")));
                                        Window.jtf_005.setText(String.valueOf(rs.getDouble("stage005")));
                                        Window.jtf_010.setText(String.valueOf(rs.getDouble("stage010")));
                                        Window.jtf_015.setText(String.valueOf(rs.getDouble("stage015")));
                                        Window.jtf_020.setText(String.valueOf(rs.getDouble("stage020")));
                                        Window.jtf_025.setText(String.valueOf(rs.getDouble("stage025")));
                                        Window.jtf_030.setText(String.valueOf(rs.getDouble("stage030")));

                                        //  Cохраняем ID записи в статическую пременную
                                        Window.IdSelectDepth = rs.getInt("ID");
                                        System.out.println(Window.IdSelectDepth);
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
                        }
                  }
              }
          });
    }

    // Добавление элемента в JList
    public void addUppdateList()
    {
        arr = new ArrayList<Double>();
        arr = getDepthArr();

        DefaultListModel dlm = new DefaultListModel();
        dlm = (DefaultListModel)myList.getModel();
        dlm.clear();

        for (Double d : arr)
            { dlm.addElement(d); }
    }

    //  Получения из БД массива глубин (отсортированный)
    private ArrayList getDepthArr ()
    {
        //  Считыываем данные с БД
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList arrDepth = null;
        try {
            conn = Conector.getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(IF_NOT_EMPTY);

            //  Массив для хранения данных полученных с resultset
            arrDepth = new ArrayList<Double>();

            //  Заполняем массив данными о глубинах (depth) из БД
            while (rs.next()) {
                arrDepth.add(rs.getDouble("depth"));
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
        Collections.sort(arrDepth);

        return arrDepth;
    }

}
