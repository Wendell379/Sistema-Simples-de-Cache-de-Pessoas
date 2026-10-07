//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    List<Pessoa> nome = new ArrayList<>();
    nome.add(new Pessoa(1, "Marcos Marroco", 28));
    nome.add(new Pessoa(2, "Luiza Ferreira", 19));
    nome.add(new Pessoa(3, "Nomas Patos", 18));
    nome.add(new Pessoa(4, "Diego Oliveira", 45));
    nome.add(new Pessoa(5, "Eduarda Lima", 19));
    nome.add(new Pessoa(6, "Fernando Rocha", 30));
    nome.add(new Pessoa(7, "Gabriela Santos", 27));
    nome.add(new Pessoa(8, "Henrique Alves", 50));
    nome.add(new Pessoa(9, "Isabela Martins", 24));
    nome.add(new Pessoa(10, "João Pereira", 38));
    nome.add(new Pessoa(11, "Mirrela Guimarroes", 20));

    Map<Integer, Pessoa> cache = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        IO.println("Escolha uma opção: [0] Cadastrar [-1] Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == -1) {
            IO.println("Saindo...");
            break;
        }

        if (opcao == 0) {
            IO.println("Digite o ID do novo usuário: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (buscabanco(nome, id).getId() != -1) {
                IO.println("Erro: Já existe um usuário cadastrado com esse ID!");
                continue;
            }

            IO.println("Digite o Nome: ");
            String nomePessoa = scanner.nextLine();

            IO.println("Digite a Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            Pessoa novaPessoa = new Pessoa(id, nomePessoa, idade);
            nome.add(novaPessoa);
            IO.println("Usuário cadastrado com sucesso: " + novaPessoa);

        } else {
            int idbusca = opcao;

            if (cache.containsKey(idbusca)) {
                IO.println("Pessoa encontrada no cache: " + cache.get(idbusca));
            } else {
                Pessoa pessoaEncontrada = buscabanco(nome, idbusca);

                if (pessoaEncontrada.getId() != -1) {
                    if (cache.size() >= 10) {
                        int idMaisAntigo = cache.keySet().iterator().next();
                        cache.remove(idMaisAntigo);
                        IO.println("-> Cache cheio! ID " + idMaisAntigo + " removido.");
                    }
                    cache.put(idbusca, pessoaEncontrada);
                    IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
                } else {
                    IO.println("Pessoa não encontrada no banco!");
                }
            }
        }
    }
}
Pessoa buscabanco(List<Pessoa> lista, int id) {
    for (Pessoa p : lista) {
        if (p.getId() == id) {
            return p;
        }
    }
    return new Pessoa(-1, "", 0);
}