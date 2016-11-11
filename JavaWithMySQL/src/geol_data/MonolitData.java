package geol_data;

import com.sun.xml.internal.bind.v2.TODO;

/**

        Класс описывает  сам монолит грунта и данные которые может дать монолит

    **/

public class MonolitData {


        //  Номер ИГЭ в котором находится монолит
        private int numbEl;

        //  Глубина отбора монолита
        private float depth;

        //  массив данных с значениями относительной просадочности при нагрухках
        //  0,05 МПа    0,10 МПа   0,15 МПа   0,20 МПа   0,25 МПа   0,30 МПа
        private double[] mass;

        //  Мощность просадочного слоя
        private float m;

        //  Плотность грунта
        private double density;

        //  Плотность сухого грунта
        private double density_sg;

        //  Плотность частиц грунта
        private double density_4g;


        public MonolitData(int n, float d, float m, double des) {
            setNumbEl(n);
            setDepth(d);
            setM(m);
            setDensity(des);
            setDensity_sg(SchetDensitySg(des));
        }


        //  Сеттеры

        public void setNumbEl(int NumbEl) {
            if (NumbEl > 0)
                numbEl = NumbEl;
            else
                this.numbEl = 0;        //Сделать диалоговое окно с сообщенем о ошибке???
        }

        public void setDepth(float Depth) {
            if (Depth > 0)
                depth = Depth;
            else
                this.depth = 0;         //Сделать диалоговое окно с сообщенем о ошибке???
        }

        public void setMass(double[] mass) {
            //TODO
            this.mass = mass;
        }

        public void setM(float M) {
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

        public void setDensity_sg(double Density_sg) {
            if (Density_sg >= 0)
                density_sg = Density_sg;
            else
                density_sg = 0;
        }

        public void setDensity_4g(double Density_4g) {
            if (Density_4g > 0)
                density_4g = Density_4g;
            else
                density_4g = 0;
        }

        //  Геттеры

        public int getNumbEl() {
            return numbEl;
        }

        public float getDepth() {
            return depth;
        }

        public double[] getMass() {
            //TODO
            return mass;
        }

        public float getM() {
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

        //  Расчет плотности сухого грунта
        private double SchetDensitySg(double i) {

            //TODO
            return density_sg;
        }

    }