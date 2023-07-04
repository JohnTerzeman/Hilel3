class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public House(String foundation, String structure, String roof, String interior) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.interior = interior;
    }

    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public String getRoof() {
        return roof;
    }

    public String getInterior() {
        return interior;
    }
}

interface HouseBuilder {
    HouseBuilder buildFoundation(String foundation);

    HouseBuilder buildStructure(String structure);

    HouseBuilder buildRoof(String roof);

    HouseBuilder buildInterior(String interior);

    House build();
}

class ConcreteHouseBuilder implements HouseBuilder {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    @Override
    public HouseBuilder buildFoundation(String foundation) {
        this.foundation = foundation;
        return this;
    }

    @Override
    public HouseBuilder buildStructure(String structure) {
        this.structure = structure;
        return this;
    }

    @Override
    public HouseBuilder buildRoof(String roof) {
        this.roof = roof;
        return this;
    }

    @Override
    public HouseBuilder buildInterior(String interior) {
        this.interior = interior;
        return this;
    }

    @Override
    public House build() {
        return new House(foundation, structure, roof, interior);
    }
}

public class Main {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        House house1 = builder.buildFoundation("Бетонный")
                .buildStructure("Кирпичный")
                .buildRoof("Черепица")
                .buildInterior("Современный")
                .build();

        House house2 = builder.buildFoundation("Свайный")
                .buildStructure("Деревянный")
                .buildRoof("Солома")
                .buildInterior("Классический")
                .build();

        boolean isEqual = house1.equals(house2);
        System.out.println("Равны ли они? " + isEqual);

        int hash1 = house1.hashCode();
        int hash2 = house2.hashCode();
        System.out.println("Hashcode for house1: " + hash1);
        System.out.println("Hashcode for house2: " + hash2);
    }
}