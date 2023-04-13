import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class ContaBancariaTest {

    static Scanner sc = new Scanner(System.in);

    private ContaBancaria contaBancaria;

    @BeforeEach
    public void setUp() {
        contaBancaria = new ContaBancaria("1", "titular");
    }

    @Test
    public void testGetNumeroConta() {
        String numero = sc.next();
        ContaBancaria conta = criarConta(numero, sc.next());
        assertEquals(numero, conta.getNumeroConta());
    }

    @Test
    public void testGetTitular() {
        String titular = sc.next();
        ContaBancaria conta = criarConta(sc.next(), titular);
        assertEquals(titular, conta.getTitular());
    }

    @Test
    public void testGetSaldo() {
        ContaBancaria conta = criarConta(sc.next(), sc.next());
        double testSaldo = conta.getSaldo();
        assertEquals(testSaldo, conta.getSaldo());
    }

    @Test
    public void testGetTaxa() {
        ContaBancaria conta = criarConta(sc.next(), sc.next());
        double testTaxa = conta.getTaxaJuros();
        assertEquals(testTaxa, conta.getTaxaJuros());
        conta.setTaxaJuros(testTaxa * 2);
        assertEquals(testTaxa, conta.getTaxaJuros());
    }

    @Test
    public void testDepositar() {
        assertTrue(contaBancaria.depositar(200));
        assertFalse(contaBancaria.depositar(-200));
    }

    @Test
    public void testSacar() {
        contaBancaria.depositar(200);
        assertTrue(contaBancaria.sacar(100));
        assertFalse(contaBancaria.sacar(1000));
        assertFalse(contaBancaria.sacar(-200));
    }

    @Test
    public void testTransferir() {
        contaBancaria.depositar(200);
        ContaBancaria contaDepositar = criarConta(sc.next(), sc.next());
        assertTrue(contaBancaria.transferir(contaDepositar, 100));
        assertFalse(contaBancaria.transferir(contaDepositar, -200));
    }

    @Test
    public void testAplicarJuros() {
        double saldo = contaBancaria.getSaldo();
        double taxa = contaBancaria.getTaxaJuros();
        double saldoDepoisDaTaxa = saldo * taxa;
        assertEquals(saldoDepoisDaTaxa, contaBancaria.getSaldo());
    }

    @Test
    public void testAlterarTitular() {
        assertTrue(contaBancaria.alterarTitular(sc.next()));
        assertFalse(contaBancaria.alterarTitular(null));
    }

    public ContaBancaria criarConta(String numero, String titular) {
        ContaBancaria contaBancaria1;
        contaBancaria1 = new ContaBancaria(numero, titular);
        return contaBancaria1;
    }
}
