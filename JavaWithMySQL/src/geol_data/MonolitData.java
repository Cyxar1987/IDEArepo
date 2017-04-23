package geol_data;

/**

        Класс описывает монолит грунта и данные которые он может предоставить


    **/

public class MonolitData {

        //  Номер ИГЭ в котором находится монолит
        private int numbEl;

        //  Глубина отбора монолита
        private double depth;

        //  массив данных с значениями относительной просадочности при нагрухках
        //  0,05 МПа    0,10 МПа   0,15 МПа   0,20 МПа   0,25 МПа   0,30 МПа
    private final static int j = 6;
    private double[] prosadka = new double[j];

    //  Массив значений нагрузок
    private final double [] ARR_LOAD = { 0.05,   0.10,   0.15,   0.20,   0.25,   0.30 };

        //  Мощность просадочного слоя
        private double m;

        //  Плотность грунта
        private double density;

        //  Плотность сухого грунта
        private double density_sg;

        //  Плотность частиц грунта
        private double density_4g;

        //  Влажность грунта
        private double water;

        //  Плотность грунта при W = 0.8
        private double density_08;

        //  Бытовое давление
        private double pbit;

        //  Начальное просадочное давление
        private double firstPressure;

        // TODO Переписать конструктор на полный кроме бытового давления
        // TODO
        //   ----------- Конструктор класса ---------------
        public MonolitData(int aNumbIEl, double aDepth, double aM, double aDensity, double aWater) {
            setNumbEl(aNumbIEl);
            setDepth(aDepth);
            setM(aM);
            setDensity(aDensity);
            setWater(aWater);

        }


    //--------------------------  Сеттеры ------------------------------------

        public void setNumbEl(int NumbEl) {
            if (NumbEl > 0)
                numbEl = NumbEl;
            else
                this.numbEl = 0;        //Сделать диалоговое окно с сообщенем о ошибке???
        }

        public void setDepth(double Depth) {
            if (Depth > 0)
                depth = Depth;
            else
                this.depth = 0;         //Сделать диалоговое окно с сообщенем о ошибке???
        }

        public void setMass(int Param, double value) {
            prosadka[Param] = value;
        }

        public void setM(double M) {
            if (M >= 0)
                m = M;
            else
                m = 0;        //Сделать диалоговое окно с сообщенем о ошибке???
        }

        public void setDensity(double Density) {
            if (Density > 0)
                density = Density;
            else
                density = 0;
        }

        public void setDensity_sg(double i) {
            if (i >= 0)
                density_sg = i;
            else
                density_sg  = 0;
        }

        public void setDensity_4g(double Density_4g) {
            if (Density_4g > 0)
                density_4g = Density_4g;
            else
                density_4g = 0;
        }

        public void setWater(double Water) {
        if (Water > 0 | Water <=1)
            water = Water;
        else
            water = 0;
    }

        public void setDensity_08(double d_08) {
            if (d_08 >= 0)
                density_08 = d_08;
            else
                density_08 = 0;
    }

        public void setPbit(double Pbit) {
            if (Pbit > 0)
                pbit = Pbit;
            else
                pbit = 0;
    }

        public void setFirstPressure(double firstPressure) {

            this.firstPressure = firstPressure;
        }

    // ------------------------- Геттеры -----------------------------------

        public int getNumbEl() {
            return numbEl;
        }

        public double getDepth() {
            return depth;
        }

        public double getProsadka(int a) {

            return prosadka[a];
        }

        public double getM() {
            return m;
        }

        public double getDensity() {
            return density;
        }

        public double getDensity_sg() {
            return density_sg;
        }

        public double getDensity_4g() {
            return density_4g;
        }

        public double getDensity_08() {
            return density_08;
    }

        public double getWater() {
            return water;
    }

        public double getPbit() {
            return pbit;
    }


    /** ---------------------- РАСЧЕТ -------------------------- */

        //  Расчет плотности сухого грунта
        private double SchetDensitySg(double des, double wat) {
            density_sg = des/(1+wat);
            return density_sg;
        }

        // Расчет плотности грунта при W = 0.8
        private double SchetDensity_08 (double chg, double sg){
            density_08 = ((((chg - sg)/(chg*sg))*0.8)+1)*sg;
            return density_08;
        }

        //  Расчет бытового давления
        // TODO
        private double SchetPbit( ){

            return pbit;
        }

        //  Расчет начального просадочного давления
        private double SchetFirstPressure(double [] Mass){

            double result = 0;

            for (int i = 0; i < Mass.length; i++) {
                if ( Mass[i] == 0.01) {
                    result = ARR_LOAD[i];
                    break;
                }
                if ( Mass[i] > 0.01 ) {

                    result = interpolation (i, Mass[i]);
                    break;
                    }
                }
                firstPressure = result;
            return firstPressure;
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