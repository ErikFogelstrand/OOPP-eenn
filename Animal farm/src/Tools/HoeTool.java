package Tools;

public class HoeTool extends Tool{
    public HoeTool() {
        toolName = "Hoe";
    }

    @Override
    public boolean use() {
        return true;
    }
}
