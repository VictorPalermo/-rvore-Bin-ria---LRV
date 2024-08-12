public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    //Método de remover Raiz
    public void removerRaiz (){
        No atual = this.raiz;
        No pai = null;
        No aux = atual;
        if (atual.getDir() == null && atual.getEsq() == null) {
            //Aqui descobrimos que a raiz não tem filhos, então removemos a raiz
            this.raiz = null;
        } else if (atual.getDir() == null) {
            //Aqui descobrimos que a raiz só tem filhos na esquerda
            pai = atual;
            atual = atual.getEsq();
            this.raiz = atual;
        } else if (atual.getEsq() == null) {
            //Aqui descobrimos que a raiz só tem filhos na direita
            pai = atual;
            atual = atual.getDir();
            this.raiz = atual;
        }else {
            //Aqui descobrimos que a raiz tem filhos em ambos os lados (Não esta funcionando)
            aux = atual.getDir();
            pai = atual;
            //Busca o menor valor do lado direito da árvore
            while (aux.getEsq() != null) {
                pai = aux;
                aux = aux.getEsq();
            }
            //Altera o valor da Raiz para o menor valor do lado direito da árvore
            this.raiz.setValor(aux.getValor());
            //Corrige os apontamento dentro da árvore
            if (pai != atual) {
                pai.setEsq(aux.getDir());
            } else {
                pai.setDir(aux.getDir());
            }
        }
    }

    //Método de remover nó folha
    public void removerFolha (int valor){
        No atual = this.raiz;
        No pai = null;
        //Busca encontrar em qual local se encontra o valor inserido
        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }
        //Começa a remover de fato o Nó folha
        if (pai.getValor() > atual.getValor()) {
            pai.setEsq(null);
        } else {
            pai.setDir(null);
        }

    }

    //Método de remover nó que possuí 1 filho
    public void removerNoCom1Filho (No valor){
        No atual = this.raiz;
        No pai = null;
        No aux = null;
        //Percorremos a árvore até encontrar o valor
        while (atual.getValor() != valor.getValor()) {
            if (valor.getValor() < atual.getValor()) {
                pai = atual;
                atual = atual.getEsq();
            } else{
                pai = atual;
                atual = atual.getDir();
            }
        }
        //Aqui descobrimos se o filho do nó a ser removido está na direita ou esquerda
        if (atual.getEsq() == null) {
            //O filho está à direita
            aux = atual.getDir();
            atual.setValor(aux.getValor());
        } else {
            //O Filho está à esquerda
            aux = atual.getEsq();
            atual.setValor(aux.getValor());
        }
        //Aqui arrumamos o apontamento do pai para o novo filho
        if (pai.getEsq() == atual) {
            //O Filho está à esquerda do pai, então o pai aponta para ele agora
            pai.setEsq(aux);
        } else {
            //O Filho está à direita do pai, então o pai aponta para ele agora
            pai.setDir(aux);
        }

    }

    //Método de remover nó que possuí 2 filhos
    public void removerNoCom2Filhos (int valor){
        No atual = this.raiz;
        No pai = null;
        //Percorremos a árvore até encontrar o valor
        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }
        //Busca encontrar o menor valor no lado direito da árvore
        pai = atual;
        No aux = atual.getDir();

        while (aux.getEsq() != null) {
            pai = aux;
            aux = aux.getEsq();
        }
        //Altera o valor a ser deletado para o menor valor do lado direito da árvore
        atual.setValor(aux.getValor());
        //Corrige os apontamento dentro da árvore
        if (pai != atual) {
            pai.setEsq(aux.getDir());
        } else {
            pai.setDir(aux.getDir());
        }
    }

    //Este Método percorre a árvore e descobre o tipo de valor que está sendo removido
    public void remover (int num){
        No atual = this.raiz;
        No pai = null;

        //Aqui percorremos a árvore para encontrar o valor oferecido pelo usuario
        while (atual != null && atual.getValor() != num) {
            pai = atual;
            if (num < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }
        //Aqui avisa o usuario caso o valor fornecido não esteja na árvore
        if (atual == null) {
            System.out.println("Valor não encontrado na árvore");
            System.out.println("Tente um existente ou adicione um novo");
            return;
        }

        //A partir daqui o código descobre o tipo do valor já encontrado na árvore
        if(atual.getValor() == raiz.getValor()) {
            //O Valor a ser removido é uma raiz
            System.out.println("Este Valor a ser removido é a raíz da árvore");
            removerRaiz();
            System.out.println("Valor removido");
        } else if (atual.getDir() == null && atual.getEsq() == null) {
            //O Valor a ser removido é uma folha
            System.out.println("Este Valor a ser removido é uma folha");
            removerFolha(num);
            System.out.println("Valor removido");
        } else if (atual.getDir() == null || atual.getEsq() == null){
            //O Valor a ser removido é um nó com 1 filho
            System.out.println("Este Valor a ser removido é um nó com um filho");

            removerNoCom1Filho(atual);
            System.out.println("Valor removido");
        }else{
            //O Valor a ser removido é um nó com 2 filhos
            System.out.println("Este Valor a ser removido é um nó com dois filhos");
            removerNoCom2Filhos(num);
            System.out.println("Valor removido");
        }
    }
}