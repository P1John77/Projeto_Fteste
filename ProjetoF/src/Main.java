import controller.ProdutoController;
import model.Produto;

public class Main {
    public static void main(String[] args) {

        ProdutoController produtoController = new ProdutoController();
        Produto produto = new Produto();
        System.out.println(produtoController.salvar(produto));
        }
}