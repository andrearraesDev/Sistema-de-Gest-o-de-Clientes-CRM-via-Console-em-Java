package sistema.crm;

import java.util.HashMap;
import java.util.Map;

public class SistemaCRM {
    private boolean ativo;
    private Map<String, String> clientes;
    private final int limiteClientes = 1000;

    public SistemaCRM() {
        ativo = false;
        clientes = new HashMap<>();
    }

    public void ativarSistema() {
        ativo = true;
        System.out.println("CRM ativado com sucesso!");
    }

    public void desativarSistema() {
        ativo = false;
        System.out.println("CRM desativado.");
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void adicionarCliente(String nome, String email) {
        if (!ativo) {
            System.out.println("[ERRO]CRM não está ativo");
            return;
        }
        if (clientes.size() >= limiteClientes) {
            System.out.println("[ERRO]Limite de clientes atingido");
            return;
        }
        clientes.put(nome, email);
        System.out.println("Cliente adicionado:" + nome + "(" + email + ")");
    }

    public void removerCliente(String nome) {
        if (clientes.remove(nome) != null) {
            System.out.println("Cliente removido:" + nome);
        } else {
            System.out.println("[ERRO]Cliente não encontrado:" + nome);
        }
    }

    public void atualizarEmailCliente(String nome, String novoEmail) {
        if (clientes.containsKey(nome)) {
            clientes.put(nome, novoEmail);
            System.out.println("E-mail atualizado:" + nome + ":" + novoEmail);
        } else {
            System.out.println("[ERRO]Cliente não encontrado:" + nome);
        }
    }

    public int getTotalClientes() {
        return clientes.size();
    }

    public int getLimiteClientes() {
        return limiteClientes;
    }

    public void listarClientes() {
        System.out.println("\n===Lista de Clientes===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
        } else {
            for (Map.Entry<String, String> cliente : clientes.entrySet()) {
                System.out.println("-" + cliente.getKey() + "|" + cliente.getValue());
            }
        }
    }
}
