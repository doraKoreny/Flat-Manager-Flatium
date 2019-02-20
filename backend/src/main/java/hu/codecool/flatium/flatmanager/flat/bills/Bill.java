package hu.codecool.flatium.flatmanager.flat.bills;

public class Bill {
    private BillType billType;
    private double price;
    private boolean paid = false;

    public Bill() {
    }

    public Bill(BillType billType, double price) {
        this.billType = billType;
        this.price = price;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
