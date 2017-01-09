package gui;


import javax.swing.*;

public class Listmain {

    JList myList;
    DefaultListModel listModel;

    boolean isClear;

    public Listmain (){

        if  ( isClearDB() == true )
            {
                //  Если данных в БД нет рисуем чистый JList
                //TODO
            }
        else
            {
                //  Данные есть в БД рисуем JList из БД
                //TODO
            }

    }


    public boolean isClearDB()
    {
        isClear = false;

        // TODO  Создать булевый метод на проверку наличичя данных в БД

        return isClear;
    }
}
