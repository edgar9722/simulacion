package Pruebas;

public class U_ChiCuadrada {
    int[] numeros;
    int fEsperada = 0 ;
    double x2;
    double x2Critico;
    int intervalos = 5;
    Rango[] rango;
    boolean validacion = false;

    public U_ChiCuadrada(int[] numeros, int fEsperada) {
        this.numeros = numeros;
        this.fEsperada = fEsperada;
        intervalos();
        Calculos();
        imprimir();
    }

    class Rango {
        double minimo , maximo;    // (minimo, maximo]
        int fObservada;
        int Zn;

        public Rango(double minimo, double maximo) {
            this.minimo = minimo;
            this.maximo = maximo;
        }
    }


    private void intervalos()
    {
        rango = new Rango[intervalos];

        fEsperada = numeros.length/intervalos;


        double min=0;
        double max=1.0/intervalos;

        for(int i=0; i<rango.length; i++)
        {
            rango[i] = new Rango(min, max);
            min=max;
            max=max+(1.0/intervalos);
        }

    }
    private void Calculos(){
        // obtener la frecuencia observada
        for(int i=0; i< numeros.length; i++)
        {
            for(int j=0; j< rango.length ; j++)
            {
                if( numeros[i] <rango[j].minimo)
                {
                    rango[j].fObservada++;
                    break;
                }
            }
        }

        // calcular z
        for(int i=0; i< rango.length; i++)
        {
            Rango ran = rango[i];
            int resta  = ran.fObservada - fEsperada;
            double z =  Math.pow(resta, 2)/fEsperada*1.0;
            x2 = z + z;
        }

        if (x2 < x2Critico)
            validacion = true;


    }

    private void imprimir()
    {
        System.out.println("RANGO\t|" + "Fo\t|" + "FE\t|");

        System.out.println("------------------------------------------------");

        for(int i=0; i<rango.length; i++)
        {
            Rango ran = rango[i];
            System.out.println("["+ran.minimo+"-"+ran.maximo+")\t|"+  ran.fObservada+"\t|"+fEsperada+"\t|");
        }

        System.out.println("\n X2 = " + x2);

        if (validacion)
            System.out.println("se acepta la hiposis de que la muestra viene de una distribucion uniforme");
        else
            System.out.println( "no se acepta la hipotesis");
    }


}
