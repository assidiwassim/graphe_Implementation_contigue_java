package graphe_implementation_contigue;

public class Graphe_Implementation_contigue {

public static int nmax=6;
public static int[] marque=new int[nmax];
public int[] Sommets=new int[6];
public int[][]  Adjacance= new int[6][6];

public Graphe_Implementation_contigue(){
this.zeroTabMat();
}

public Graphe_Implementation_contigue(int[] Sommets,int[][]  Adjacance){
    this.Sommets=Sommets;
    this.Adjacance=Adjacance;
}
public void zeroTabMat(){
    for(int i=0;i<nmax;i++){
        Sommets[i]=0;
        for(int j=0;j<nmax;j++){
        Adjacance[i][j]=0;
        }
    }
}

public void affichage(){
    for(int i=0;i<nmax;i++){
        if(Sommets[i]!=0){
          System.out.print("|"+Sommets[i]+"| -->");
        for(int j=0;j<nmax;j++){
            if(Adjacance[i][j]!=0)
        System.out.print("| "+Adjacance[i][j]+"|");
        }
             System.out.println("");}
    }
}


public void ajoutSommets(int Sommet){
    
    int i=0;
    while(i<nmax &&  Sommets[i]!=0){
        i++;
    }
    
    if( Sommets[i]==0){
        Sommets[i]=Sommet;
    }
    
}

public void supprimerSommets(int Sommet){
    
    int i=0;
    while(i<nmax &&  Sommets[i]!=Sommet){
        i++;
    }
    
    if( Sommets[i]==Sommet){
        Sommets[i]=0;
    }
    
}


public void ajouterArc(int Sommet ,int Sommet2){
    
    int i=0,j=0;
    while(i<nmax &&  Sommets[i]!=Sommet){
        i++;
    }
    
    if( Sommets[i]==Sommet){
   
    while(j<nmax &&  this.Adjacance[i][j]!=0){
        j++;
    }
      if(this.Adjacance[i][j]==0)  {
          this.Adjacance[i][j]=Sommet2;
      }
    }
    
}

public void supprimerArc(int Sommet ,int Sommet2){
    
    int i=0,j=0;
    while(i<nmax &&  Sommets[i]!=Sommet){
        i++;
    }
    
    if( Sommets[i]==Sommet){
   
    while(j<nmax &&  this.Adjacance[i][j]!=Sommet2){
        j++;
    }
      if(this.Adjacance[i][j]==Sommet2)  {
          this.Adjacance[i][j]=0;
      }
    }
    
}

public int degre(int Sommet){
    int d=0;
    int c=0;
    
    while(c<nmax && this.Sommets[c] !=Sommet)
    c++;
    if( this.Sommets[c] == Sommet){
    
    
    for(int i=0;i<nmax;i++)
    {
        if(this.Adjacance[c][i]!=0)
        {
            d++;
        }
    }
    }
    
    return(d);
}


public int IemmeDegre(int Sommet ,int indice){
     
     int i=0,j=0,nbr=0, result =0;
  
  
  
    while(i<nmax &&  Sommets[i]!=Sommet){
        i++;
    }
    
    if( Sommets[i]==Sommet){
    
         while(j<nmax && nbr!=indice-1){
             if(this.Adjacance[i][j]!=0){
                 nbr++;
             }
           j++;
          }
         
         if(nbr==indice-1){
         result = this.Adjacance[i][j] ;
         }
         else{
              result =  -1;
         }
                  
    }
    
return  result ; 
}

public int getValue(int s){
    
int i=0,x=0;
    while(i<nmax &&  Sommets[i]!=s){
        i++;
    }
    
    if( Sommets[i]==s){
    x=i;
    }
    
return x;

}

public void profondeur (int IndiceSommet){
    
    int Sommet;
    int deg;
    int ValueIeme,IndSommet;
    
    marque[IndiceSommet]=0;
    if(this.Sommets[IndiceSommet]!=0){
    System.out.println("visite de "+this.Sommets[IndiceSommet]);
    Sommet = this.Sommets[IndiceSommet];
    deg=degre(Sommet);
    for(int i=0;i<deg;i++){
        ValueIeme=this.IemmeDegre(Sommet,i+1);
        IndSommet=getValue(ValueIeme);
        if(marque[IndSommet]!=0)
            profondeur(IndSommet);
    }
    }
    
}





    public static void main(String[] args) {
       Graphe_Implementation_contigue g=new Graphe_Implementation_contigue();
    
       g.ajoutSommets(2);
        g.ajoutSommets(5);
         g.ajoutSommets(20);
       //  g.supprimerSommets(5);
        // g.supprimerSommets(20);
         g.ajouterArc(2, 20);
        g.ajouterArc(2, 5);
        
          // g.supprimerArc(2, 20);
           

           
          
        g.affichage();
        
        
                   
            for( int i=0;i<nmax;i++){
                  marque[i]=1;
           }
            
          for( int i=0;i<nmax;i++){
               if(marque[i]!=0 )
                   g.profondeur(i);
           }
         
    }
    
}
