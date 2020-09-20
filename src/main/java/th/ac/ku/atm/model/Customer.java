package th.ac.ku.atm.model;

public class Customer {
    private int id;
    private String name;
    private String pin;

    public Customer(int id, String name, String pin) {
        this.id = id;
        this.name = name;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
