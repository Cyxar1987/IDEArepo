package calculation;


import geol_data.MonolitData;

import java.util.ArrayList;



public class Prosadka {

    //   Массив с нагрузками
    private static final double [] ARR_LOAD = { 0.05,   0.10,   0.15,   0.20,   0.25,   0.30 };

    //  Массив с значениями просадочности на каждой нагрузке
    private static double [] prosadka = new double[ARR_LOAD.length];

 // ---------------------  РАСЧЕТ  -----------------------------

    /*  Расчет начального просадочного давления
        для каждого объекта (монолита) в массиве array */
    public static void SchetFirstPressure(ArrayList<MonolitData> array){

        double result = 0;

        for (int index = 0; index < array.size(); index++) {

            prosadka = array.get(index).getProsadka();

            for (int i = 0; i < prosadka.length; i++) {
                if (prosadka[i] == 0.01) {
                    result = ARR_LOAD[i];
                    break;
                }
                if (prosadka[i] > 0.01) {

                    result = interpolation(i, prosadka[i]);
                    break;
                }
            }
            array.get(index).setStartPressure(result);
        }
    }

    /*  Метод ля интерполяции значений начального просадочного давления
        в зависимости от индекса(index) массива и значения относительной просадочности (numb) */
    private static double interpolation (int index, double numb) {

        double result = 0;
        double d = 0;
        if (index == 0) {
            result = (0.010 * ARR_LOAD[0]) / numb;
        }
        else if (index > 0 && index < prosadka.length) {
            //  Расчтет приращения относительной просадочности за 0,05 МПа
            d = prosadka[index] - prosadka[index - 1];
            result = (((0.01 - prosadka[index - 1]) * 0.05) / d) + ARR_LOAD[index - 1];
        }
        else { result = 0; }

        return result;
    }

    /*  Метод для расчета бытового давления
        для каждого объекта (монолита) в массиве array */
    public static void SchetPBit (ArrayList<MonolitData> array) {
        MonolitData monolit;
        double result = 0;

        for (int index = 0; index < array.size(); index++) {
            monolit = array.get(index);
            if (index == 0) {
                result = monolit.getM() * monolit.getDensity_08();
            }
            else {
                result = array.get(index-1).getPbit() + (monolit.getM() * monolit.getDensity_08());
            }
            array.get(index).setPbit(result);
        }
    }

    /*  Метод для расчета относительной просадочности
        для каждого объекта (монолита) в массиве array */
    public static void SchetOtnositProsad (ArrayList<MonolitData> array) {
        MonolitData monolit;
        double result = 0;
        double stage = 0.05;    // Cтупень нагрузки 0.05 МПа
        double delta;           // Приращение просадки за ступень нагрузки 0.05

        for (int index = 0; index < array.size(); index++) {
            monolit = array.get(index);
            prosadka = monolit.getProsadka();

            /* Сравниваем бытовое давление с нагрузкой
               если равны то присваем относительной просадочности
               значение из массива prosadka[] */
            for (int x = 0; x < ARR_LOAD.length; x ++) {
                if (monolit.getPbit() == ARR_LOAD[x]) {
                    result = prosadka[x];
                    break;
                }
            }
                //   Интерполяция между 0 - 0.05 МПа
                if (monolit.getPbit() < ARR_LOAD[0]) {
                    result = (monolit.getPbit() * prosadka[0]) / ARR_LOAD[0];
                }

                //  ---------- Интерполяция между 0.05 - 0.10 МПа ----------
                else if (monolit.getPbit() > ARR_LOAD[0] && monolit.getPbit() < ARR_LOAD[1]) {
                    delta = prosadka[1] - prosadka[0];
                    result = (((monolit.getPbit() - ARR_LOAD[0]) * delta) / stage) + ARR_LOAD[0];
                }

                //  --------------- Интерполяция между 0.10 - 0.15 МПа ---------------
                else if (monolit.getPbit() > ARR_LOAD[1] && monolit.getPbit() < ARR_LOAD[2]) {
                    delta = prosadka[2] - prosadka[1];
                    result = (((monolit.getPbit() - ARR_LOAD[1]) * delta) / stage) + ARR_LOAD[1];
                }

                //  --------------- Интерполяция между 0.15 - 0.20 МПа ---------------
                else if (monolit.getPbit() > ARR_LOAD[2] && monolit.getPbit() < ARR_LOAD[3]) {
                    delta = prosadka[3] - prosadka[2];
                    result = (((monolit.getPbit() - ARR_LOAD[2]) * delta) / stage) + ARR_LOAD[2];
                }

                //  --------------- Интерполяция между 0.20 - 0.25 МПа ---------------
                else if (monolit.getPbit() > ARR_LOAD[3] && monolit.getPbit() < ARR_LOAD[4]) {
                    delta = prosadka[4] - prosadka[3];
                    result = (((monolit.getPbit() - ARR_LOAD[3]) * delta) / stage) + ARR_LOAD[3];
                }

                //  --------------- Интерполяция между 0.25 - 0.30 МПа ---------------
                else if (monolit.getPbit() > ARR_LOAD[4] && monolit.getPbit() < ARR_LOAD[5]) {
                    delta = prosadka[5] - prosadka[4];
                    result = (((monolit.getPbit() - ARR_LOAD[4]) * delta) / stage) + ARR_LOAD[4];
                }
                else {
                    result = 0;
                }
            monolit.setOtnositProsadka(result);
        }
    }
}
