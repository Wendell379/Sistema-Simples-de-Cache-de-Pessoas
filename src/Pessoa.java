public class Pessoa {

    private int id;
    private String Nome;
    private int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        Nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
