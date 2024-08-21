/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeonfighterjava;

/**
 *
 * @author kevin
 */
public class ArmadilhaPerdaFixa extends Armadilha {
    private final int perdaFixa;
    
    public ArmadilhaPerdaFixa() {
        super("ArmadilhaPF");
        this.perdaFixa = 1;
    }
    
    @Override
    public void aplicarEfeito(Heroi heroi) {
        heroi.receberDano(perdaFixa);
    }
}
