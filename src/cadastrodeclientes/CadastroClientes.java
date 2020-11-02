package cadastrodeclientes;

import cliente.Cliente;
import dao.ClienteDAO;

public class CadastroClientes {

    public static void main(String[] args) {
        //Cria registro
        Cliente cliente = new Cliente();
        cliente.setNome("Teste2 teste2");
        cliente.setEmail("teste2@teste2.com");
        
        //Instancia a dao
        ClienteDAO dao = new ClienteDAO();
        dao.iniciar();
        
        //Inserir o cliente criado anteriormente no BD
        dao.inserir(cliente);
        
        //Pesquisar por ID
        dao.iniciar(); 
        Cliente clienteId = dao.consultarId(2L);
        System.out.println(clienteId.getNome());
        
        
        //Atualizar dados
        dao.iniciar();
        dao.atualizar(2L, "testealterar@gmail.com");
        
        //Remover dados
        dao.iniciar(); 
        dao.remover(1L);
        
        
        dao.encerrar();
    }
}
