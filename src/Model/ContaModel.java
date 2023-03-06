package Model;

public class ContaModel {
        private String numeroDaConta, numeroDaAgencia, tipo;
        private double saldo;

        public ContaModel(String numeroDaConta, String numeroDaAgencia, String tipo, double saldo) {
                setSaldo(saldo);
                setTipo(tipo);
                setNumeroDaConta(numeroDaConta);
                setNumeroDaAgencia(numeroDaAgencia);

        }

        public String getNumeroDaConta() {
                return numeroDaConta;
        }

        private void setNumeroDaConta(String numeroDaConta) {
                this.numeroDaConta = numeroDaConta;
        }

        public String getNumeroDaAgencia() {
                return numeroDaAgencia;
        }

        private void setNumeroDaAgencia(String numeroDaAgencia) {
                this.numeroDaAgencia = numeroDaAgencia;
        }

        public String getTipo() {
                return tipo;
        }

        private void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public double getSaldo() {
                return saldo;
        }

        private void setSaldo(double saldo) {
                this.saldo = saldo;
        }

        public boolean sacar (double valor){
                if (valor > getSaldo()) {
                        return false;
                }
                setSaldo(getSaldo()-valor);
                return true;
        }
        public boolean depositar(double valor){
                setSaldo(getSaldo()+valor);
                return true;
        }
}
