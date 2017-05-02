package gui;


import calculation.Prosadka;
import connDb.Conector;
import geol_data.MonolitData;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class myTableModel implements TableModel {

    private final String ALL_DATA = "SELECT * FROM between_table";


    private final String [] tableHeaders = {"Number ige", "Depth monolit", "Work load 0.05", "Work load 0.10",
            "Work load 0.15", "Work load 0.20","Work load 0.25", "Work load 0.30",
            "Starting pressure", "Mochnost pros sloia", "Density SG", "Density real",
            "Density 0.8", "Litology pressure", "Otnosit prossadka", "Prosadka"};

    private ArrayList<MonolitData> arrMonolit;

    public myTableModel(ArrayList<MonolitData> arr) {
        arrMonolit = arr;
    }


    @Override   // реализован!
    public int getRowCount() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rowCount = 0;

        try {
            conn = Conector.getconnDb();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(ALL_DATA);

            while (rs.next()) {
                rowCount++;
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
        return rowCount;
        }

    @Override   // реализован!
    public int getColumnCount() {
        return tableHeaders.length;
    }

    @Override   // реализован!
    public String getColumnName(int columnIndex) {
        return tableHeaders[columnIndex];
    }

    @Override   // реализован!
    public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0)
                return Integer.class;
            else
                return Double.class;
    }

    @Override   // реализован!
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //  Метод заполняет таблицу данными!
    @Override   // TODO
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonolitData monolit = arrMonolit.get(rowIndex);
        switch (columnIndex){
            case 0:
                return monolit.getNumbEl();
            case 1:
                return monolit.getDepth();
            case 2:
                return monolit.getProsadka()[0];
            case 3:
                return monolit.getProsadka()[1];
            case 4:
                return monolit.getProsadka()[2];
            case 5:
                return monolit.getProsadka()[3];
            case 6:
                return monolit.getProsadka()[4];
            case 7:
                return monolit.getProsadka()[5];
            case 8:
                return monolit.getStartPressure();
            case 9:
                return monolit.getM();
            case 10:
                return monolit.getDensity_sg();
            case 11:
                return monolit.getDensity();
            case 12:
                return monolit.getDensity_08();
            case 13:
                return monolit.getPbit();

            case 14:
                return monolit.getOtnositProsadka();

            default:
                return 0;
        }
    }



    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }
    @Override
    public void removeTableModelListener(TableModelListener l) {

    }


}
