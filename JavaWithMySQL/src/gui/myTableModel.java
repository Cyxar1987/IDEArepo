package gui;



import connDb.Conector;
import geol_data.MonolitData;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class myTableModel implements TableModel {

    private final String ALL_DATA = "SELECT * FROM between_table";


    private final String [] tableHeaders = {"<html> Number <br> ige <html> ", "<html>Depth <br>monolit<html>", "<html>Work load <br>0.05<html>",
            "<html>Work load <br>0.10<html>", "<html>Work load <br>0.15<html>", "<html>Work load <br>0.20<html>",
            "<html>Work load <br>0.25<html>", "<html>Work load <br>0.30<html>", "<html>Starting <br>pressure<html>",
            "<html>Mochnost <br>pros sloia<html>", "Density SG", "<html>Density <br>real<html>",
            "Density 0.8", "<html>Litology <br>pressure<html>", "<html>Otnosit <br>prossadka<html>", "Prosadka"};

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
                return BigDecimal.class;
    }

    @Override   // реализован!
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //  Метод заполняет таблицу данными!
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonolitData monolit = arrMonolit.get(rowIndex);
        double result;
        switch (columnIndex){
            case 0:
                return monolit.getNumbEl();
            case 1:
                return new BigDecimal(monolit.getDepth()).setScale(1, BigDecimal.ROUND_HALF_UP);
            case 2:
                return new BigDecimal(monolit.getProsadka()[0]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 3:
                return new BigDecimal(monolit.getProsadka()[1]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 4:
                return new BigDecimal(monolit.getProsadka()[2]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 5:
                return new BigDecimal(monolit.getProsadka()[3]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 6:
                return new BigDecimal(monolit.getProsadka()[4]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 7:
                return new BigDecimal(monolit.getProsadka()[5]).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 8:
                return new BigDecimal(monolit.getStartPressure()).setScale(3, BigDecimal.ROUND_HALF_UP);
            case 9:
                return new BigDecimal(monolit.getM()).setScale(2, BigDecimal.ROUND_HALF_UP);
            case 10:
                return new BigDecimal(monolit.getDensity_sg()).setScale(2, BigDecimal.ROUND_HALF_UP);
            case 11:
                return new BigDecimal(monolit.getDensity()).setScale(2, BigDecimal.ROUND_HALF_UP);
            case 12:
                return new BigDecimal(monolit.getDensity_08()).setScale(2, BigDecimal.ROUND_HALF_UP);
            case 13:
                return new BigDecimal(monolit.getPbit()).setScale(4, BigDecimal.ROUND_HALF_UP);

            case 14:
                return new BigDecimal(monolit.getOtnositProsadka()).setScale(4, BigDecimal.ROUND_HALF_UP);

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
