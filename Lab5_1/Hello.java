package bin;

public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =  ( name != null) ? name.trim() : name ;
    }

    public String getHello() {
        return (getName() == null || getName().isBlank()) ? "Привет!"  : String.format("Привет %s! ", getName());
    }
}
