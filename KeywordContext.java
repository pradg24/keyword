public class KeywordContext {
    private Map<String, Object> contextData;

    public KeywordContext() {
        this.contextData = new HashMap<>();
    }

    public void set(String key, Object value) {
        contextData.put(key, value);
    }

    public Object get(String key) {
        return contextData.get(key);
    }
}
