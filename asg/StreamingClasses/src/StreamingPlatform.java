public class StreamingPlatform {
    private final String name;
    private final double price;

    public StreamingPlatform(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(boolean yearly){
        if (yearly){
            return (price * 12) - (price * .5);
        } else return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
