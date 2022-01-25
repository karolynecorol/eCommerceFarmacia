package com.eCommerce.Farmacia.model;

@Entity
@Table (name = "tb_produto")
public class Produto {

    @Id
    @GenerateValue (strategy = Generation. IDENTITY)
    private long id;

    @NotBlank
    @Size (max = 255)
    private String nome;

    @NotBlank
    @Size (max = 255)
    private String marca;

    @NotNull
    @Size (max = 255)
    private int quantidade;

    @NotNull
    @Size (max = 255)
    private float preco;

    @ManyToOne 
    @JsonIgnoreProperties ("produto")
    private Produto produto;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
