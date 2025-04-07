package sistema.crm;

public class GerenciadorClientes {
    private static final int LINHA_WIDTH = 50;

    public static void main(String[] args) {
        SistemaCRM crm = new SistemaCRM();
        printCabecalho("SISTEMA DE GESTÃO DE CLIENTES (CRM)");
        printSecao("INÍCIO", "Status do sistema:");
        printItem("Status", crm.estaAtivo() ? "ATIVO" : "INATIVO");
        printItem("Clientes", crm.getTotalClientes() + "/" + crm.getLimiteClientes());
        printDivisor();
        
        crm.ativarSistema();
        printSecao("ATIVAÇÃO", "Sistema inicializado!");
        printItem("Status", "ATIVO");
        
        printSecao("CADASTRO", "Adicionando clientes:");
        crm.adicionarCliente("João Silva", "joao@email.com");
        crm.adicionarCliente("Maria Souza", "maria@email.com");
        crm.adicionarCliente("Carlos Oliveira", "carlos@empresa.com");
        
        printSecao("ATUALIZAÇÃO", "Modificando registros:");
        crm.removerCliente("Maria Souza");
        crm.atualizarEmailCliente("João Silva", "joao.novo@email.com");
        
        printCabecalho("RELATÓRIO DE CLIENTES");
        printItem("Total", crm.getTotalClientes() + " clientes");
        printItem("Limite", crm.getLimiteClientes() + " clientes");
        crm.listarClientes();
        
        crm.desativarSistema();
        printDivisor();
        printSecao("ENCERRAMENTO", "Sistema finalizado:");
        printItem("Status", "INATIVO");
        printRodape();
    }

    private static void pularLinha() {
        System.out.println();
    }

    private static void printCabecalho(String titulo) {
        pularLinha();
        System.out.println("=".repeat(LINHA_WIDTH));
        System.out.println(centralizarTexto(titulo));
        System.out.println("=".repeat(LINHA_WIDTH));
        pularLinha();
    }

    private static void printRodape() {
        pularLinha();
        System.out.println("=".repeat(LINHA_WIDTH));
    }

    private static void printSecao(String tag, String msg) {
        pularLinha();
        System.out.println("[" + tag + "] " + msg);
    }

    private static void printItem(String rotulo, String valor) {
        System.out.println("  " + rotulo + ":" + valor);
    }

    private static void printDivisor() {
        pularLinha();
        System.out.println("-".repeat(LINHA_WIDTH));
    }

    private static String centralizarTexto(String texto) {
        int espacos = (LINHA_WIDTH - texto.length()) / 2;
        return " ".repeat(espacos) + texto;
    }
}
