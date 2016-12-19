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
    private double[] mass = new double[j];

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



        //   Конструктор класса
        public MonolitData(int n, double d, double m, double des, double w) {
            setNumbEl(n);
            setDepth(d);
            setM(m);
            setDensity(des);
            setWater(w);
            setDensity_sg(SchetDensitySg(density, water));
            setDensity_08(SchetDensity_08(density_4g, density_sg));
            setPbit(SchetPbit(density_08, depth));

        }

        //  Сеттеры

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
            mass[Param] = value;
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

    //  Геттеры

        public int getNumbEl() {
            return numbEl;
        }

        public double getDepth() {
            return depth;
        }

        public double getMass(int a) {

            return mass[a];
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

    //----------------------------------------------------------------
    //----------------------   РАСЧЕТ   ------------------------------
    //----------------------------------------------------------------

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
        private double SchetPbit(double d_08, double d){
            pbit = d_08 * d;
            return pbit;
        }
    }