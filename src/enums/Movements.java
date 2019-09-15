package enums;

public enum Movements {
    X(1),
    O(-1),
    EMPTY(0);

    private final int signValue;

    Movements(int signValue) {
        this.signValue = signValue;
    }

    public int getSignValue() {
        return signValue;
    }
}
