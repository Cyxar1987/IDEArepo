package gui;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Класс описывающий создание таблицы и  проведения расчета в ней просадки от собственного веса
 *  Данные будут получаться из БД*/

public class ResultTable extends JFrame {

    private final String NUMBER_MINE = "Number ige";
    private final String DEPTH_MONOLIT = "Depth monolit";
    private final String NUMBER_IGE = "Number ige";
    private final String WORK_LOAD = "WorkLoad";
    private final String WORK_LOAD_005 = "0.05";
    private final String WORK_LOAD_010 = "0.10";
    private final String WORK_LOAD_015 = "0.15";
    private final String WORK_LOAD_020 = "0.20";
    private final String WORK_LOAD_025 = "0.25";
    private final String WORK_LOAD_030 = "0.30";
    private final String STARTING_PRESSURE = "Starting pressure";
    private final String MOSCHNOST_PROSS_SLOIA = "Moschnost pross sloia";
    private final String DENSITY_SG = "Density sg";
    private final String DENSITY_REAL = "Density real";
    private final String DENSITY_FOR_08 = "Density for 0.8";
    private final String LITOLOGY_PRESSURE = "Litology pressure";
    private final String OTNOSIT_PROSADKA = "Otnosit prosadka";
    private final String PROSADKA = "Prosadka";


    JPanel panel;

    JTable myTable;

    //  Конструктор
    public ResultTable() {

        super();

        setTitle("Prossadka");
        setLocationRelativeTo(null);
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout fl = new FlowLayout();

        GridBagLayout gb = new GridBagLayout();

        setLayout(fl);


    }

    private ArrayList arrCollumsHeader()
    {
        ArrayList tableHeaders = new ArrayList <String>();

        tableHeaders.add(NUMBER_MINE);
        tableHeaders.add(DEPTH_MONOLIT);
        tableHeaders.add(NUMBER_IGE);
        tableHeaders.add(WORK_LOAD);
        tableHeaders.add(WORK_LOAD_005);
        tableHeaders.add(WORK_LOAD_010);
        tableHeaders.add(WORK_LOAD_015);
        tableHeaders.add(WORK_LOAD_020);
        tableHeaders.add(WORK_LOAD_025);
        tableHeaders.add(WORK_LOAD_030);
        tableHeaders.add(STARTING_PRESSURE);
        tableHeaders.add(MOSCHNOST_PROSS_SLOIA);
        tableHeaders.add(DENSITY_SG);
        tableHeaders.add(DENSITY_REAL);
        tableHeaders.add(DENSITY_FOR_08);
        tableHeaders.add(LITOLOGY_PRESSURE);
        tableHeaders.add(OTNOSIT_PROSADKA);
        tableHeaders.add(PROSADKA);


        return tableHeaders;
    }
}
