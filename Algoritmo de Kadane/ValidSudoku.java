import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
         * =======================================================================
         * BLOCO COMENTADO: Tentativas anteriores (que não funcionam) e seus erros
         * =======================================================================
         *
         * Arrays de HashSet para manter controle dos dígitos vistos em cada linha, coluna e quadrante 3x3.
         * Set<Character>[] row = new HashSet[9];
         * Set<Character>[] col = new HashSet[9];
         * Set<Character>[] sqr = new HashSet[9];
         *
         *
         * // Verificação das Linhas (Código com erro):
         * for (int cl = 0; cl < 9; cl++){
         *     for (int rw = 0; rw < 9; rw++){
         *         if (board[rw][cl] != '.'){
         *             // Erro: os índices foram invertidos.
         *             // Aqui deveria acessar board[rw][cl], mas está usando board[cl][rw].
         *             if (row[rw].contains(board[cl][rw]))
         *                 return false;
         *             row[rw].add(board[cl][rw]);
         *         }
         *     }
         * }
         *
         * // Verificação das Colunas (Fragmentada, mas a lógica é adequada):
         * for (int cl = 0; cl < 9; cl++){
         *     for (int rw = 0; rw < 9; rw++){
         *         if (board[rw][cl] != '.'){
         *             if (col[cl].contains(board[rw][cl]))
         *                 return false;
         *             col[cl].add(board[rw][cl]);
         *         }
         *     }
         * }
         *
         * // Verificação dos Quadrantes 3x3 (Código com erros):
         * for (int cl = 0; cl < 9; cl++){
         *     for (int rw = 0; rw < 9; rw++){
         *         // Erro: Cálculo incorreto do índice do quadrante.
         *         int gridN = (cl / 3) * 3 + (rw / 3);
         *         if (board[rw][cl] != '.'){
         *             // Erro: acesso incorreto aos elementos do tabuleiro.
         *             if (sqr[gridN].contains(board[cl / 3][rw / 3]))
         *                 return false;
         *             sqr[gridN].add(board[cl][rw]);
         *         }
         *     }
         * }
         *
         * Esses blocos fragmentados apresentam problemas de inconsistência nos índices
         * e dificultam o entendimento, além de causar erros de validação.
         * =======================================================================
         */

        // Inicializa os conjuntos para cada linha, coluna e quadrante.
        // Cada posição nos arrays 'row', 'col' e 'sqr' recebe um novo HashSet para armazenar os dígitos vistos.

        //Arrays de HashSet para manter controle dos dígitos vistos em cada linha, coluna e quadrante 3x3.
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] sqr = new HashSet[9];

        for (int i = 0; i < 9; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            sqr[i] = new HashSet<>();
        }

        // Percorre todas as células do tabuleiro, onde 'i' representa a linha e 'j' representa a coluna.
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                // Se a célula não está vazia (ou seja, não contém '.'), então processa o dígito.
                if (board[i][j] != '.'){
                    // Calcula o índice do quadrante 3x3 onde a célula se encontra.
                    // Dividindo 'i' e 'j' por 3, obtemos qual faixa a linha e a coluna pertencem,
                    // e combinando esses resultados com (i/3)*3 + (j/3) temos um índice único entre 0 e 8.
                    int g = (i / 3) * 3 + (j / 3);

                    // Verifica se o dígito já foi visto na mesma linha, coluna ou quadrante.
                    if (row[i].contains(board[i][j]) ||
                            col[j].contains(board[i][j]) ||
                            sqr[g].contains(board[i][j])){
                        // Se o dígito já existe, o tabuleiro é inválido.
                        return false;
                    }

                    // Se o dígito não foi encontrado anteriormente, adiciona-o aos conjuntos correspondentes.
                    row[i].add(board[i][j]);
                    col[j].add(board[i][j]);
                    sqr[g].add(board[i][j]);
                }
            }
        }
        // Se nenhuma duplicata foi encontrada, o Sudoku é válido.
        return true;
    }
}
