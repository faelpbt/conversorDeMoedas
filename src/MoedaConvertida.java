import java.util.Map;

public class MoedaConvertida {
    private String moedaDesejada;
    private String moedaConvesao;
    private double amount;
    private double resultado;
    private double valorMoeda;

    public MoedaConvertida(MoedaApi moedaApi, Double amount, String moedaConvesao) {
        this.moedaDesejada = moedaApi.base_code();
        this.moedaConvesao = moedaConvesao;
        this.amount = amount;

        for(Map.Entry<String, Double> moedaNova : moedaApi.conversion_rates().entrySet()) {
            if(moedaNova.getKey().equals(this.moedaConvesao)) {
                valorMoeda = moedaNova.getValue();
                break;
            }
        }
    }

    public String getConverte() {
        resultado = amount * valorMoeda;
        return "Valor " + amount + " [" + moedaDesejada + "] corresponde ao valor final de " + resultado + " [" + moedaConvesao + "].";
    }

    @Override
    public String toString() {
        return "MoedaConvertida{" +
                "moedaConvesao='" + moedaConvesao + '\'' +
                ", valorMoeda=" + valorMoeda +
                '}';
    }
}
