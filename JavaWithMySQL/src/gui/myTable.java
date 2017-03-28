package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/** Класс описывающий создание таблицы и  проведения расчета в ней просадки от собственного веса
 *  Данные будут получаться из БД*/

public class myTable extends JFrame {

    private myTableModel tm;

    private JPanel panel;

    private JTable myTable;
    private JScrollPane scrollPane;

    //  Конструктор
    public myTable() {

        super();

        setTitle("Prossadka");
        setLocationRelativeTo(null);
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bd = new BorderLayout();

        //GridBagLayout gb = new GridBagLayout();

        setLayout(bd);

        tm = new myTableModel();
        /*
        myTableModel.setColumnIdentifiers(tableHeaders); // Задание заголовков массивом
        myTableModel.addRow(tableData); // Добавление строки с данными
        */
        myTable = new JTable(tm);
        myTable.getTableHeader().setFont(new Font("Verdana", Font.ITALIC, 10));
        scrollPane = new JScrollPane(myTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }
}
