package Controllers;import Model.Atracao;import Model.Venda;import Repositories.AtracoesRepository;import Repositories.VendasRepository;import java.io.FileNotFoundException;import java.util.ArrayList;public class EngController {    private VendasRepository vendasRepository;    private AtracoesRepository atracoesRepository;    public EngController() throws FileNotFoundException {        this.vendasRepository = new VendasRepository();        this.atracoesRepository = new AtracoesRepository();    }    public String proximaManutencao() {        ArrayList<String> proximasManutencoes = new ArrayList<>();        for (Atracao atracaoAtual : atracoesRepository.getAtracaoArray()) {            int numBilhetes = 0;            for (Venda vendaAtual : vendasRepository.getVendasArray()) {                if (vendaAtual.getIdAtracao() == (atracaoAtual.getId())) {                    numBilhetes++;                }            }            int bilhetesFaltam = 50 - (numBilhetes % 50);            String proximaManutencao = "ID: " + atracaoAtual.getId() + " | " + atracaoAtual.getNome() +                    " | Bilhetes Vendidos: " + numBilhetes +                    " | Próxima Manutenção em: " + bilhetesFaltam + " bilhetes";            proximasManutencoes.add(proximaManutencao);        }        String proxManutencoes = "";        for (String manutencao : proximasManutencoes) {            proxManutencoes += manutencao + "\n";        }        return proxManutencoes;    }    }