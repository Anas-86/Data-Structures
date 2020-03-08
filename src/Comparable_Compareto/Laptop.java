package Comparable_Compareto;

public class Laptop implements Comparable<Laptop>{
    private int ram;
    private int hardDesk;
    private int price;

    public Laptop(int ram, int hardDesk, int price) {
        this.ram = ram;
        this.hardDesk = hardDesk;
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDesk() {
        return hardDesk;
    }

    public void setHardDesk(int hardDesk) {
        this.hardDesk = hardDesk;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", hardDesk=" + hardDesk +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        if(this.price>o.price)
            return 1;
        else if(this.price<o.price)
            return -1;
        else
            return 0;
    }
}
