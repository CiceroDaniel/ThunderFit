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
    public RelatorioFinanceiro gerarRelatorioMensal(YearMonth mes, Usuario solicitante) {
    	 if (!(solicitante instanceof Administrador)) {
             throw new SecurityException("Apenas administradores podem gerar relatórios!");
    	 }

         double receita = calcularReceitaMensal(mes); //metodos do relatorioservice

         double despesas = calcularDespesasMensais(); //metodos do relatorioservice

         double lucro = receita - despesas;

         return new RelatorioFinanceiro(mes, receita, despesas, lucro);
    	
    }
    
    //-------------------------------------------
    private double calcularReceitaMensal(YearMonth mes) {
        return pagamentoRepository.listarTodos().stream().filter(p -> p.getPago() && 
                p.getDataPagamento().getMonth() == mes.getMonth() && 
                p.getDataPagamento().getYear() == mes.getYear())
            .mapToDouble(Pagamento::getValorPago).sum();//SOMA
    }
    private double calcularDespesasMensais() {
        return usuarioService.listarUsuarios(null).stream().filter(usuario -> usuario instanceof Tutor)
            .map(usuario -> (Tutor) usuario).mapToDouble(Tutor::getSalario).sum();
    }
    
}
