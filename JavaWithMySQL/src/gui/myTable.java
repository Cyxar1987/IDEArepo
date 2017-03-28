package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/** Класс описывающий создание таблицы и  проведения расчета в ней просадки от собственного веса
 *  Данные будут получаться из БД*/

public class myTable extends JFrame {

    private final String [] tableHeaders = {"Number ige", "Depth monolit", "Work load 0.05", "Work load 0.10",
                                            "Work load 0.15", "Work load 0.20","Work load 0.25", "Work load 0.30",
                                            "Starting pressure", "Mochnost pros sloia", "Density SG", "Density real",
                                            "Density 0.8", "Litology pressure", "Otnosit prossadka", "Prosadka"};
    private final String [] tableData = {"1", "1", "0.003", "0.004", "0.006", "0.008","0.010", "0.011",
                                        "0.25", "1", "1.29", "1.64", "1.88", "0.0254", "0.00548", "0"};
    private DefaultTableModel myTableModel;

    JPanel panel;

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

        myTableModel = new DefaultTableModel();
        myTableModel.setColumnIdentifiers(tableHeaders); // Задание заголовков массивом
        myTableModel.addRow(tableData); // Добавление строки с данными

        myTable = new JTable(myTableModel);
        scrollPane = new JScrollPane(myTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }
}
