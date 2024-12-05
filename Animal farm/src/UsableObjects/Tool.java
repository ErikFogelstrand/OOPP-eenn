package UsableObjects;

public abstract class Tool implements ITool {
    private String name;
    public Tool(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
