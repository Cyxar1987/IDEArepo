package gui;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class myTableModel implements TableModel {

    private final String [] tableHeaders = {"Number ige", "Depth monolit", "Work load 0.05", "Work load 0.10",
            "Work load 0.15", "Work load 0.20","Work load 0.25", "Work load 0.30",
            "Starting pressure", "Mochnost pros sloia", "Density SG", "Density real",
            "Density 0.8", "Litology pressure", "Otnosit prossadka", "Prosadka"};

    @Override
    public int getRowCount() {return 0;}

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return tableHeaders[columnIndex];
            case 1:
                return tableHeaders[columnIndex];
            case 2:
                return tableHeaders[columnIndex];
            case 3:
                return tableHeaders[columnIndex];
            case 4:
                return tableHeaders[columnIndex];
            case 5:
                return tableHeaders[columnIndex];
            case 6:
                return tableHeaders[columnIndex];
            case 7:
                return tableHeaders[columnIndex];
            case 8:
                return tableHeaders[columnIndex];
            case 9:
                return tableHeaders[columnIndex];
            case 10:
                return tableHeaders[columnIndex];
            case 11:
                return tableHeaders[columnIndex];
            case 12:
                return tableHeaders[columnIndex];
            case 13:
                return tableHeaders[columnIndex];
            case 14:
                return tableHeaders[columnIndex];
            case 15:
                return tableHeaders[columnIndex];
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
            case 2:
                return Double.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
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
