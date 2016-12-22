package gui;

import geol_data.MonolitData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
        *   Класс главного фрейма  *
    **/
public class Window {



    /**
            //TODO сделать ссылку на класс таблицы
     **/


        JFrame jfrm;
        JPanel panel;
        JLabel igeLabel, depthLabel, mLabel, waterLabel, densityLabel,
               prosLabel, label_005, label_010, label_015, label_020, label_025, label_030;

        JTextField igeJtf, depthJtf, mJtf, waterJtf, densityJtf,
                   jtf_005, jtf_010, jtf_015, jtf_020, jtf_025, jtf_030;

        JButton addButton, applyButton;

        MonolitData monolit;

        //  Конструктор
        public Window()
        {

            jfrm = new JFrame("Prossadka");
            jfrm.setLocationRelativeTo(null);
            jfrm.setSize(600, 350);
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GridBagLayout gb = new GridBagLayout();
            jfrm.setLayout(gb);

            panel = new JPanel();


            prosLabel = new JLabel("Otnosit prosadka");
            igeLabel = new JLabel("№ IGE");
            depthLabel =new JLabel("Glubina");
            mLabel =new JLabel("moschnost");
            waterLabel =new JLabel("warter");
            densityLabel = new JLabel("density");
            label_005 = new JLabel("0.05 MPa");
            label_010 = new JLabel("0.10 MPa");
            label_015 = new JLabel("0.15 MPa");
            label_020 = new JLabel("0.20 MPa");
            label_025 = new JLabel("0.25 MPa");
            label_030 = new JLabel("0.30 MPa");



            igeJtf = new JTextField(3);
            depthJtf = new JTextField(3);
            mJtf = new JTextField(3);
            waterJtf = new JTextField(5);
            densityJtf = new JTextField(5);
            jtf_005 = new JTextField(5);
            jtf_010 = new JTextField(5);
            jtf_015 = new JTextField(5);
            jtf_020 = new JTextField(5);
            jtf_025 = new JTextField(5);
            jtf_030 = new JTextField(5);


            addButton = new JButton("add");
            applyButton = new JButton("apply");

            jfrm.add(igeLabel, new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            jfrm.add(igeJtf, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            jfrm.add(depthLabel, new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            jfrm.add(depthJtf, new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            jfrm.add(mLabel, new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            jfrm.add(mJtf, new GridBagConstraints(2,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            jfrm.add(waterLabel, new GridBagConstraints(3,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            jfrm.add(waterJtf, new GridBagConstraints(3,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            jfrm.add(densityLabel, new GridBagConstraints(4,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));
            jfrm.add(densityJtf, new GridBagConstraints(4,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 30), 0, 0));


            jfrm.add(prosLabel, new GridBagConstraints(0,2,5,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,
                    new Insets(25, 1, 10, 1), 0, 0));


            jfrm.add(label_005, new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(label_010, new GridBagConstraints(1,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(label_015, new GridBagConstraints(2,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(label_020, new GridBagConstraints(3,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(label_025, new GridBagConstraints(4,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(label_030, new GridBagConstraints(5,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));


            jfrm.add(jtf_005, new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(jtf_010, new GridBagConstraints(1,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(jtf_015, new GridBagConstraints(2,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(jtf_020, new GridBagConstraints(3,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(jtf_025, new GridBagConstraints(4,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));
            jfrm.add(jtf_030, new GridBagConstraints(5,4,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 35), 0, 0));

            jfrm.add(addButton, new GridBagConstraints(3,5,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(30, 5, 5, 35), 0, 0));
            jfrm.add(applyButton, new GridBagConstraints(4,5,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
                    new Insets(30, 5, 5, 35), 0, 0));


            //  Обработка нажатия кнопок!!!  (ананимные внутренние классы)
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int n = Integer.parseInt(igeJtf.getText());
                    double depth = Double.parseDouble(depthJtf.getText());
                    double m = Double.parseDouble(mJtf.getText());
                    double wat = Double.parseDouble(waterJtf.getText());
                    double dens = Double.parseDouble(densityJtf.getText());

                    monolit = new MonolitData(n, depth, m, wat, dens);



                }
            });

            applyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jfrm.setVisible(false);
                }
            });

            jfrm.setVisible(true);




        }


}
