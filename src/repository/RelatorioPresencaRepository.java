package repository;

import model.RelatorioPresenca;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RelatorioPresencaRepository {

    private final List<RelatorioPresenca> relatorios = new ArrayList<>();

    // ------------------ CRIAR------------------
    public void salvar(RelatorioPresenca relatorio) {
        Objects.requireNonNull(relatorio, "Relatório não pode ser nulo");

        // Evita duplicidade do mesmo período
        if (buscarPorPeriodo(relatorio.getPeriodo()).isPresent()) {
            throw new IllegalArgumentException("Relatório desse período já existe.");
        }

        relatorios.add(relatorio);
    }

    // ------------------ Listar todos ------------------
    public List<RelatorioPresenca> listarTodos() {
        return new ArrayList<>(relatorios);
    }

    // ------------------ Buscar por período ------------------
    public Optional<RelatorioPresenca> buscarPorPeriodo(YearMonth periodo) {
        return relatorios.stream()
                .filter(r -> r.getPeriodo().equals(periodo))
                .findFirst();
    }

    // ------------------ Remover por período ------------------
    public boolean removerPorPeriodo(YearMonth periodo) {
        Optional<RelatorioPresenca> relatorio = buscarPorPeriodo(periodo);
        return relatorio.map(relatorios::remove).orElse(false);
    }
}
