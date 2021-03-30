public class Quadratic {
    private Weapon[] table;
    private int tableSize;
    private double loadFactor; //0.80
    int numItems;

    public Quadratic(int max,double lf){
        table = new Weapon[max];
        tableSize= max;
        loadFactor=lf;
        numItems=0;
    }


}
