package geol_data;

    /*
        Данные которые может дать монолит
    */

public class MonolitData {

    //  Номер ИГЭ в котором находится монолит
    private short numbEl;

    //  Глубина отбора монолита
    private float depth;

    //  массив данных с значениями относительной просадочности при нагрухках
    //  0,05 МПа    0,10 МПа   0,15 МПа   0,20 МПа   0,25 МПа   0,30 МПа
    private double [] mass;

    //  Мощность просадочного слоя
    private float m;

    //  Плотность грунта
    private double density;

    //  Плотность сухого грунта
    private double density_sg;


    //  Сеттеры

    public void setNumbEl(short numbEl) {
        if (this.numbEl > 0)
            this.numbEl = numbEl;
        else
            this.numbEl = 0;        //Сделать диалоговое окно с сообщенем о ошибке???
}

    public void setDepth (float depth) {
        if (this.depth > 0)
            this.depth = depth;
        else
            this.depth = 0;         //Сделать диалоговое окно с сообщенем о ошибке???
    }

    public void setMass(double[] mass) {
        this.mass  = mass;
    }

    public void setM(float m) {
        if (this.m >=0)
            this.m = m;
        else
            this.m = 0;        //Сделать диалоговое окно с сообщенем о ошибке???
    }

    public void setDensity(double density) {
        if (this.density > 0)
            this.density = density;
        else
            this.density = 0;
    }

    public void setDensity_sg(double density_sg) {
        if(this.density_sg >= 0)
            this.density_sg = density_sg;
        else
            this.density_sg = 0;
    }

    //  Геттеры


    public short getNumbEl() {
        return numbEl;
    }

    public float getDepth() {
        return depth;
    }

    public double[] getMass() {
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
}
