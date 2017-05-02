package gui;

import calculation.Prosadka;
import connDb.Conector;
import geol_data.MonolitData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
        *   Класс главного фрейма  *
    **/


public class Window {


    /**
            //TODO сделать ссылку на класс таблицы
     **/


        private JFrame jfrm;
        private JPanel Mainpanel;
        private JLabel igeLabel, depthLabel, mLabel, waterLabel, densityLabel,
               prosLabel, label_005, label_010, label_015, label_020, label_025, label_030,
               density4gLabel;

        static JTextField igeJtf, depthJtf, mJtf, waterJtf, densityJtf, density4gJtf,
                   jtf_005, jtf_010, jtf_015, jtf_020, jtf_025, jtf_030;

        private JButton addButton, applyButton, calculationButton, edittButton;

        private MonolitData monolit;
        private Listmain list;

        public static int IdSelectDepth;

        private ArrayList<MonolitData> arrayMonolit = new ArrayList();



        //  Конструктор
        public Window()
        {

            jfrm = new JFrame("Prossadka");
            jfrm.setLocationRelativeTo(null);
            jfrm.setSize(800, 450);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            FlowLayout fl = new FlowLayout();
            GridBagLayout gb = new GridBagLayout();
            jfrm.setLayout(fl);


            prosLabel = new JLabel("Otnosit prosadka");
            igeLabel = new JLabel("№ IGE");
            depthLabel =new JLabel("Glubina");
            mLabel =new JLabel("moschnost");
            waterLabel =new JLabel("warter");
            densityLabel = new JLabel("density");
            density4gLabel = new JLabel("density4g");
            label_005 = new JLabel("0.05 MPa");
            label_010 = new JLabel("0.10 MPa");
            label_015 = new JLabel("0.15 MPa");
            label_020 = new JLabel("0.20 MPa");
            label_025 = new JLabel("0.25 MPa");
            label_030 = new JLabel("0.30 MPa");

            list = new Listmain();

            igeJtf = new JTextField(3);
            depthJtf = new JTextField(3);
            mJtf = new JTextField(3);
            waterJtf = new JTextField(5);
            densityJtf = new JTextField(5);
            density4gJtf = new JTextField(5);
            jtf_005 = new JTextField(5);
            jtf_010 = new JTextField(5);
            jtf_015 = new JTextField(5);
            jtf_020 = new JTextField(5);
            jtf_025 = new JTextField(5);
            jtf_030 = new JTextField(5);


            addButton = new JButton("add");
            applyButton = new JButton("apply");
            calculationButton = new JButton("Calculation");
            edittButton = new JButton("Edit");


            Mainpanel = new JPanel(gb);
            Mainpanel.setBackground(Color.GRAY);
            Mainpanel.setPreferredSize(new Dimension(800, 450));


            jfrm.add(Mainpanel, 0);


            Mainpanel.add(igeLabel, new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            Mainpanel.add(igeJtf, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            Mainpanel.add(depthLabel, new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            Mainpanel.add(depthJtf, new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            Mainpanel.add(mLabel, new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            Mainpanel.add(mJtf, new GridBagConstraints(2,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            Mainpanel.add(waterLabel, new GridBagConstraints(3,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            Mainpanel.add(waterJtf, new GridBagConstraints(3,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            Mainpanel.add(densityLabel, new GridBagConstraints(4,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            Mainpanel.add(densityJtf, new GridBagConstraints(4,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));

            Mainpanel.add(list, new GridBagConstraints(6,0,2,5,0,0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(5, 15, 5, 5), 0, 0));


            Mainpanel.add(prosLabel, new GridBagConstraints(0,2,5,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                    new Insets(25, 1, 10, 1), 0, 0));


            Mainpanel.add(label_005, new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(label_010, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(label_015, new GridBagConstraints(2,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(label_020, new GridBagConstraints(3,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(label_025, new GridBagConstraints(4,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(label_030, new GridBagConstraints(5,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));


            Mainpanel.add(jtf_005, new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(jtf_010, new GridBagConstraints(1,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(jtf_015, new GridBagConstraints(2,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(jtf_020, new GridBagConstraints(3,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(jtf_025, new GridBagConstraints(4,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));
            Mainpanel.add(jtf_030, new GridBagConstraints(5,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));

            Mainpanel.add(addButton, new GridBagConstraints(3,5,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(30, 5, 5, 35), 0, 0));
            Mainpanel.add(applyButton, new GridBagConstraints(7,5,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.EAST,
                    new Insets(1, 1, 1, 20), 0, 0));
            Mainpanel.add(calculationButton, new GridBagConstraints(3,6,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(30, 5, 5, 35), 0, 0));
            Mainpanel.add(edittButton, new GridBagConstraints(6,5,1,1,0,0,GridBagConstraints.WEST,GridBagConstraints.WEST,
                    new Insets(1, 40, 1, 5), 0, 0));

            // Временно!!!!!!!!-----------------------------
            Mainpanel.add(density4gLabel, new GridBagConstraints(3,7,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(10, 5, 5, 10), 0, 0));
            Mainpanel.add(density4gJtf, new GridBagConstraints(4,7,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(10, 5, 5, 10), 0, 0));


            jfrm.setVisible(true);

            //  Обработка нажатия кнопок!!!  (ананимные внутренние классы)
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int n = Integer.parseInt(igeJtf.getText());
                    double depth = Double.parseDouble(depthJtf.getText());
                    double m = Double.parseDouble(mJtf.getText());
                    double wat = Double.parseDouble(waterJtf.getText());
                    double dens = Double.parseDouble(densityJtf.getText());
                    double dens4g = Double.parseDouble(density4gJtf.getText());
                    double stage005 = Double.parseDouble(jtf_005.getText());
                    double stage010 = Double.parseDouble(jtf_010.getText());
                    double stage015 = Double.parseDouble(jtf_015.getText());
                    double stage020 = Double.parseDouble(jtf_020.getText());
                    double stage025 = Double.parseDouble(jtf_025.getText());
                    double stage030 = Double.parseDouble(jtf_030.getText());

                    String q = "INSERT INTO between_table (ige, depth, mochnost, water, density, stage005, " +
                            "stage010, stage015, stage020, stage025, stage030, density4g)" +
                            "VALUES" +
                            "(" + n + ", " + depth + ", " + m + ", " + wat + "," + dens + "," + stage005 + ","
                            + stage010 + "," + stage015 + "," + stage020 + "," + stage025 + "," + stage030 + "," + dens4g + ")";

                    Conector.myQuery(q);

                    list.addUppdateList();

                    igeJtf.setText("");
                    depthJtf.setText("");
                    mJtf.setText("");
                    waterJtf.setText("");
                    densityJtf.setText("");
                    density4gJtf.setText("");
                    jtf_005.setText("");
                    jtf_010.setText("");
                    jtf_015.setText("");
                    jtf_020.setText("");
                    jtf_025.setText("");
                    jtf_030.setText("");

                }
            });

            applyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (calculationButton.isEnabled() == false && addButton.isEnabled() == false) {
                        int n = Integer.parseInt(igeJtf.getText());
                        double depth = Double.parseDouble(depthJtf.getText());
                        double m = Double.parseDouble(mJtf.getText());
                        double wat = Double.parseDouble(waterJtf.getText());
                        double dens = Double.parseDouble(densityJtf.getText());
                        // TODO исправить!
                        //monolit = new MonolitData(n, depth, m, dens, wat, );

                        //  uppdate-запрос на изменение данных
                        String uppdateSQL = "UPDATE between_table " +
                                "SET ige = " + n + ", depth = " + depth + ", mochnost = " + m + ", water = " + wat + ", density = " + dens + " " +
                                "WHERE ID = " + IdSelectDepth;

                        Conector.myQuery(uppdateSQL);

                        calculationButton.setEnabled(true);
                        addButton.setEnabled(true);
                    }
                }
            });

            calculationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new myTable();
                }
            });

            //  Кнопка редактированя исходных данных при выбранной глубине
            edittButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    calculationButton.setEnabled(false);
                    addButton.setEnabled(false);

                }
            });
        }
}
