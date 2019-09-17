package main.java.com.practice.oops;

    public  enum Item{
    COKE("Coke", 25L), PEPSI("Pepsi", 35L), SODA("Soda", 45L);

        private final Long price;
        private final String name;

        public Long getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        Item(String name, Long price) {
                this.name=name;
                this.price=price;
        }
    }
