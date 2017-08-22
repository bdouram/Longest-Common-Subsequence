/*
 Bruno Dourado Miranda 
 Esse programa encontra a maior sequencia de uma string, utilizando o 
 algoritmo Longest Common Subsequence;
 */
package longestcommonsubsequence;

import javax.swing.JOptionPane;

class LCS {

    int mostSubsequence(String x, String y, int c[][]) {
        // O custo genérico do método é O(i*j) pois percorre
        // apenas a matriz que contém as combinações entre as palavras;
        // Não foi necessário complementar a matriz com 0's nas posições iniciais
        // pois o IDE NetBeans já o faz. Seria um custo desnecessário de i+j;
        int i, j;

        for (i = 1; i < x.length(); i++) {        //Custo Genérico: O (i * j)
            for (j = 1; j < y.length(); j++) {
          
                if (x.charAt(i) == y.charAt(j)) {

                    c[i][j] = c[i - 1][j - 1] + 1;
                
                } else {
                
                    c[i][j] = Integer.max(c[i - 1][j], c[i][j - 1]);
                
                }
            }
        }
        return c[x.length() - 1][y.length() - 1];
    }
}

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // O algoritmo busca encontrar a maior sequência entre duas palavras;
        // O custo genérico do algoritmo é da classe O(x.length()* y.length());
   
        
        String x = JOptionPane.showInputDialog(null, "Insira a string desejada:");
        String y = JOptionPane.showInputDialog(null, "Insira a subsequência desejada:");
        
        x = "x" + x;
        y = "y" + y;
        
        if (x.length() > 1 && y.length() > 1) {
        
            LCS obj = new LCS();
            int c[][] = new int[x.length()][y.length()];
            int i = 0, j = 0;

            int maior = obj.mostSubsequence(x, y, c);
            JOptionPane.showMessageDialog(null, "O número da maior sequência é:" + maior);
        
        } else {
        
            JOptionPane.showMessageDialog(null, "Entrada de dados inválida!");
        
        }
    }

}
