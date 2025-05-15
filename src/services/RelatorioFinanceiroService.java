package services;

import model.*;
import repository.PagamentoRepository;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioFinanceiroService {
    private final PagamentoRepository pagamentoRepository;
    private final UsuarioService usuarioService;

    public RelatorioFinanceiroService(PagamentoRepository pagamentoRepository, UsuarioService usuarioService) {
        this.pagamentoRepository = pagamentoRepository;
        this.usuarioService = usuarioService;
    }

    
    //---------------CRIAR---------------------
    public RelatorioFinanceiro gerarRelatorioMensal(YearMonth mes) {
        double receita = calcularReceitaMensal(mes);
        double despesas = calcularDespesasMensais(mes);
        double lucro = receita - despesas;
        
        return new RelatorioFinanceiro(mes, receita, despesas, lucro);
    }
    
    //-------------------------------------------
    public double calcularReceitaMensal(YearMonth mes) {
        return pagamentoRepository.listarTodos().stream().filter(p -> p.getPago() && 
                p.getDataPagamento().getMonth() == mes.getMonth() && 
                p.getDataPagamento().getYear() == mes.getYear())
            .mapToDouble(Pagamento::getValorPago).sum();//SOMA
    }
    public double calcularDespesasMensais(YearMonth mes) {
        return usuarioService.listarUsuarios().stream()
            .filter(usuario -> usuario instanceof Tutor)
            .map(usuario -> (Tutor) usuario)
            .filter(tutor -> {
                System.out.println("Tutor: " + tutor.getNome());
                System.out.println("Salário: " + tutor.getSalario());
                System.out.println("Ativo: " + tutor.getTrabalhoAtivo());
                return tutor.getTrabalhoAtivo();
            })
            .mapToDouble(Tutor::getSalario)
            .sum();
    }




    
    
    
}
