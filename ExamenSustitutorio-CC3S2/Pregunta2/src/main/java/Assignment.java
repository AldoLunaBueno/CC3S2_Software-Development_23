public class Assignment {
    private final String name;

    private final String craft;

    public Assignment(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }


    public String getName() {
        return name;
    }

    public String getCraft() {
        return craft;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                '}';
    }
}
