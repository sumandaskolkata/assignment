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
        String firstAddress = address[0];
        String lastAddress = address[1];
        int longStringBetweenNameAandAddress = (name.length() > firstAddress.length()) ? name.length() + 1 : firstAddress.length() + 1;
        int maxStringLength = (longStringBetweenNameAandAddress > lastAddress.length()) ? longStringBetweenNameAandAddress : lastAddress.length() + 1;


        String topAndBottomBorder =createTopAndBottomBorder(maxStringLength,"+");
        String middleBorder = createTopAndBottomBorder(maxStringLength,"|");
        String nameConcatWithSymbol = joinGivenStringWithSpaceAndSymbol(maxStringLength - name.length(), "|", this.name);
        String firstAddressConcatWithSymbol = joinGivenStringWithSpaceAndSymbol(maxStringLength - firstAddress.length(), "|", address[0]);
        String lastAddressConcatWithSymbol = joinGivenStringWithSpaceAndSymbol(maxStringLength - lastAddress.length(), "|", address[1]);
        return topAndBottomBorder + "\n" + nameConcatWithSymbol + "\n" + middleBorder + "\n" +
                firstAddressConcatWithSymbol + "\n" + lastAddressConcatWithSymbol + "\n" + topAndBottomBorder;

    }

    private String createTopAndBottomBorder(int length,String symbol){
        String border = "";
        for (int i = 0; i < length + 1; i++) {
            border = border + "-";
        }
        return symbol+border+symbol;
    }

    private String joinGivenStringWithSpaceAndSymbol(int numberOfSpace, String symbol, String givenString) {
        String result = symbol + " " + givenString;
        String spaces = "";
        for (int i = 0; i < numberOfSpace ; i++) {
            spaces = spaces + " ";
        }
        return result + spaces + symbol;
    }
}
