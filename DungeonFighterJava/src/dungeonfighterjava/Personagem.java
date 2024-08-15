public abstract class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int saude;
    
    public Personagem(String nome, int ataque, int defesa, int saude) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.saude = saude;
    }
    
    // Métodos para acessar e modificar atributos
    public String getNome() { return nome; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getDefesa() { return defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }
    public int getSaude() { return saude; }
    public void setSaude(int saude) { this.saude = saude; }

    // Método abstrato para a habilidade especial
    public abstract void usarHabilidadeEspecial();
    
    // Método para receber dano
    public void receberDano(int dano) {
        this.saude -= dano;
        if (this.saude < 0) this.saude = 0;
    }
    
    // Método para checar se o personagem está vivo
    public boolean estaVivo() {
        return saude > 0;
    }
}
