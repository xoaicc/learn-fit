package Tut13;

public enum Color {
    Blue, Red, Orange, Yellow, Purple;

    public String getColorCode() {
        switch (this) {
            case Blue:
                return "#0000FF";
            case Red:
                return "#FF0000";
            case Orange:
                return "#FF6600";
            case Yellow:
                return "#FFFF66";
            case Purple:
                return "#990099";
        }
        return null;
    }
}
