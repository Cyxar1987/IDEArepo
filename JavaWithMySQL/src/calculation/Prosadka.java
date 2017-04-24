package calculation;


import geol_data.MonolitData;

import java.util.ArrayList;

public class Prosadka {

    //  Массив с монолитами
    private ArrayList <MonolitData> arrMonolit;

    //   Массив с нагрузками
    private final double [] ARR_LOAD = { 0.05,   0.10,   0.15,   0.20,   0.25,   0.30 };

    private double [] prosadka;

    //  Бытовое давление
    private double pBit;

    //  Начальное просадочное давление
    private double startPressure;

    //  Конструктор
    public Prosadka() {

    }


 // ---------------------  РАСЧЕТ  -----------------------------

    //  Расчет начального просадочного давления
    private double SchetFirstPressure(ArrayList<MonolitData> array){

        double [] Mass = new double[6];
        double result = 0;

        for (int index = 0; index < array.size(); index++) {

            Mass = array.get(index).getProsadka();

            for (int i = 0; i < Mass.length; i++) {
                if (Mass[i] == 0.01) {
                    result = ARR_LOAD[i];
                    break;
                }
                if (Mass[i] > 0.01) {

                    result = interpolation(i, Mass[i]);
                    break;
                }
            }
        }
        startPressure = result;
        return startPressure;
    }

    private double interpolation (int index, double numb) {

        double result = 0;
        double d = 0;
        if (index == 0) {
            result = (0.010 * ARR_LOAD[0]) / numb;
        }
        else if (index > 0 && index < prosadka.length) {
            //  TODO протестить метод!
            //  Расчтет приращения относительной просадочности за 0,05 МПа
            d = prosadka[index] - prosadka[index - 1];
            result = (((0.01 - prosadka[index - 1]) * 0.05) / d) + ARR_LOAD[index - 1];
        }
        else { result = 0; }

        return result;
    }
}
