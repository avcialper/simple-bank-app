
package entities;

public class MoneysInfo {
    private double buyDolar;
    private double sellDolar;   // kullanıcı satış fiyatı
    private double buyEuro;
    private double sellEuro;
    
    public MoneysInfo(double buyDolar, double sellDolar, double buyEuro, double sellEuro) {
        this.buyDolar = buyDolar;
        this.sellDolar = sellDolar;
        this.buyEuro = buyEuro;
        this.sellEuro = sellEuro;
    }

    public double getBuyDolar() {
        return buyDolar;
    }

    public void setBuyDolar(double buyDolar) {
        this.buyDolar = buyDolar;
    }

    public double getSellDolar() {
        return sellDolar;
    }

    public void setSellDolar(double sellDolar) {
        this.sellDolar = sellDolar;
    }

    public double getBuyEuro() {
        return buyEuro;
    }

    public void setBuyEuro(double buyEuro) {
        this.buyEuro = buyEuro;
    }

    public double getSellEuro() {
        return sellEuro;
    }

    public void setSellEuro(double sellEuro) {
        this.sellEuro = sellEuro;
    }
}
