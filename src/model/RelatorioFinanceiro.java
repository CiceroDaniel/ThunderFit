package model;

import java.time.YearMonth;
import java.util.List;

public class RelatorioFinanceiro extends Relatorio {
    private final List<Pagamento> pagamentos;
    private final List<Tutor> tutores;
    
    public RelatorioFinanceiro(YearMonth periodo, List<Pagamento> pagamentos, List<Tutor> tutores) {
        super(periodo);
        this.pagamentos = List.copyOf(pagamentos);//imutavel
        this.tutores = List.copyOf(tutores);//imutavel
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public List<Tutor> getTutores() {
        return tutores;
    }

    @Override
    public String getTitulo() {
        return String.format("Relatório Financeiro - %02d/%d", 
                getPeriodo().getMonthValue(), 
                getPeriodo().getYear());
    }
}
