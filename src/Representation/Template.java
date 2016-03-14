package Representation;

public class Template {
    private final String name;
    private final String address;

    public Template(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String represent() {
        String[] address = this.address.split("\n");
        int firstAddressLength = address[0].length();
        int secondAddressLength = address[1].length();
        int nameLength = name.length();
        int longString = (nameLength > firstAddressLength) ? nameLength + 1 : firstAddressLength + 1;
        int maxLength = (longString > secondAddressLength) ? longString : secondAddressLength + 1;
        String border = "";
        for (int i = 0; i < maxLength + 1; i++) {
            border = border + "-";
        }

        String topborder = "+" + border + "+";
        String middleBorder = "|" + border + "|";
        String name = formatGivenStringWithSpaceAndSymbol(maxLength - nameLength, "|", this.name);
        String firstAddress = formatGivenStringWithSpaceAndSymbol(maxLength - firstAddressLength, "|", address[0]);
        String lastAddress = formatGivenStringWithSpaceAndSymbol(maxLength - address[1].length(), "|", address[1]);
        return topborder + "\n" + name + "\n" + middleBorder + "\n" + firstAddress + "\n" + lastAddress + "\n" + topborder;

    }

    private String formatGivenStringWithSpaceAndSymbol(int numberOfSpace, String symbol, String givenString) {
        String result = symbol + " " + givenString;
        String spaces = " ";
        for (int i = 0; i < numberOfSpace - 1; i++) {
            spaces = spaces + " ";
        }
        return result + spaces + symbol;
    }
}
