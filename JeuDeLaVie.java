public class JeuDeLaVie

{
    public static void main(String[] args)
    {
        int ligne = 5, colonne = 5;
 
        
        int[][] initiale = new int[ligne][colonne];
        for (int i = 0; i < ligne; i++) {
          for (int j = 0; j < colonne; j++) {
            
            initiale[i][j] = 0 + (int)(Math.random() * ((1 - 0) + 1));
          }
        }
 
        System.out.println("---------------------------Matrice initiale-------------------------------------");
        for (int i = 0; i < ligne; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
                System.out.print(initiale[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
 
            nextGeneration(initiale, ligne, colonne);
        
        
    }
 
    static void nextGeneration(int initiale[][], int ligne, int colonne)
    {
        int[][] resulat = new int[ligne][colonne];
 

     
        for (int l = 0; l < ligne; l++)
        {
            for (int m = 0; m < colonne; m++)
            {
              
                int voisinsVivants = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                      if ((l+i>=0 && l+i<ligne) && (m+j>=0 && m+j<colonne))
                        voisinsVivants += initiale[l + i][m + j];
 
 
                voisinsVivants -= initiale[l][m];
 

                if ((initiale[l][m] == 1) && ( (voisinsVivants < 2) || (voisinsVivants > 3)) )
                    resulat[l][m] = 0;
 
          
                else if ((initiale[l][m] == 0) && (voisinsVivants == 3))
                    resulat[l][m] = 1;
 
             
                else
                    resulat[l][m] = initiale[l][m];
            }
        }
 
        System.out.println("-----------------------Resultat------------------------------");
        for (int i = 0; i < ligne; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
               
                    System.out.print(resulat[i][j] + "\t");
                
            }
            System.out.println();
        }
    }
}