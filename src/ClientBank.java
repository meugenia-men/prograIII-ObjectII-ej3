import java.util.UUID;

public class ClientBank {
    private UUID id;
    private String name;
    private Character gender;

    public ClientBank() {
    }

    public ClientBank(String name, Character gender) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Cliente = [Nombre y apellido = "+this.name+
                "] - [Genero= "+this.gender+
                "]";
    }
}
