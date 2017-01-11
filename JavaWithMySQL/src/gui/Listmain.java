package gui;

import connDb.Conector;

import javax.swing.*;

public class Listmain {

    JList myList;
    DefaultListModel listModel;
    private final String QUESTION = "SELECT* FROM between_table";


    public Listmain (){

        if  ( Conector.isEmptyDB(QUESTION) == true )    //  Таблица пуста, рисуем пустой JList
            {
                listModel = new DefaultListModel();
                myList = new JList(listModel);
            }
        else    //  В таблице есть записи, рисуем JList из таблицы between_table
            {
                //TODO

            }

    }


    public void addEl() {
        //  TODO    Сделать метод добавления элемента в JList
        DefaultListModel dlm = (DefaultListModel) myList.getModel();
        dlm.addElement();
    }

    public void removeEl(){
        //  TODO    Сделать метод удаления элемента из JList
    }

}
