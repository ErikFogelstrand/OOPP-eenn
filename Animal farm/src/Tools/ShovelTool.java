package Tools;

public class ShovelTool extends Tool {
    public ShovelTool() {
        toolName = "Shovel";
    }

    @Override
    public String getType() {
        return toolName;
    }

    @Override
    public boolean use() {
        return true;
    }
}
