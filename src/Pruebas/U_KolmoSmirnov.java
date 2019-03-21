package Pruebas;

public class U_KolmoSmirnov {
    int[] numeros;
    int[] orden = Ascendente(numeros);
    double X;
    int i;
    double Dm;
    double DM;
    double N=numeros.length;
    double Max;
    double Max2;
    double DMayor;
    double d=1.36/N;
    //System.out.println("Ascendente"+Arrays.toString(orden));

    public U_KolmoSmirnov(int [] numeros){
        this.numeros = numeros;
        Calcular();

    }

    public void Calcular(){
        orden=Ascendente(numeros);

        for(i=1;i<=N;i++){
            X=orden[i-1];
            X/=10000;
            DM=(i/N)-X;
            Dm=X-(i-1)/N;
            //System.out.println(X+"  "+i+"  "+N+"  "+DM+"  "+Dm);

            if(DM > Max){
                Max=DM;
            }

            if(Dm > Max2){
                Max2=Dm;
            }
        }
        //System.out.println(Max);
        //System.out.println(Max2);

        if(Max<Max2){
            DMayor=Max2;
        }else{
            DMayor=Max;
        }

        if(DMayor<=d){
            System.out.println(X+"  "+i+"  "+N+"  "+DM+"  "+Dm);
            System.out.println(Max);
            System.out.println(Max2);
            System.out.println("Se acepta la hipotesis los numeros generados provienen de una distribucion uniforme");
        }else{
            System.out.println(X+"  "+i+"  "+N+"  "+DM+"  "+Dm);
            System.out.println(Max);
            System.out.println(Max2);
            System.out.println("Hipotesis rechazada, los numeros no provienen de una distribucion uniforme");
        }
    }

    public static int[] Ascendente(int [] numeros){
        int j;
        boolean flag = true;
        int temp;

        while ( flag )
        {
            flag = false;
            for( j=0;  j < numeros.length -1;  j++ )
            {
                if ( numeros[ j ] > numeros[j+1] )
                {
                    temp = numeros[ j ];
                    numeros[ j ] = numeros[ j+1 ];
                    numeros[ j+1 ] = temp;
                    flag = true;
                }
            }
        }
        return numeros;
    }


}
