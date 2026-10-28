/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    -Erik Dafonte Da concepcion - 
 */
public class Podometro {
    public static final char HOMBRE = 'H';
    public static final char MUJER = 'M';
    public static final double RAZON_ZANCADA_HOMBRE = 0.45;
    public static final double RAZON_ZANCADA_MUJER = 0.41;
    public static final int SABADO = 6;
    public static final int DOMINGO = 7;

    private String marca;
    private int altura = 0;
    private char sexo = MUJER;
    private int longitudZancada = 0;
    private int totalPasosLaborables = 0;
    private int totalPasosSabado = 0;
    private int totalPasosDomingo = 0;
    private double totalDistanciaSemana = 0;
    private double totalDistanciaFinSemana = 0;
    private int tiempo = 0;
    private int caminatasNoche = 0;



    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String marca) {
        this.marca = marca;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(int queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;

        if (queSexo == HOMBRE) {
            longitudZancada = (int) Math.ceil(queAltura * RAZON_ZANCADA_HOMBRE);
        } else if (queSexo == MUJER) {
            longitudZancada = (int) Math.floor(queAltura * RAZON_ZANCADA_MUJER);
        }
    }

     /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {
        double distanciaKm = pasos * longitudZancada / 100000.0;

        int minutosInicio = (horaInicio / 100) * 60 + (horaInicio % 100);
        int minutosFin = (horaFin / 100) * 60 + (horaFin % 100);

        tiempo += minutosFin - minutosInicio;
        if (horaInicio >= 2100){
            caminatasNoche ++;
        }

        switch (dia){
            case 1,2,3,4,5:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + distanciaKm;
                break;

            case SABADO:
                totalPasosSabado = totalPasosSabado + pasos;
                totalDistanciaSemana = totalDistanciaSemana + distanciaKm;
                totalDistanciaFinSemana = totalDistanciaFinSemana + distanciaKm;
                break;

            case DOMINGO:
                totalPasosDomingo = totalPasosDomingo + pasos;
                totalDistanciaSemana = totalDistanciaSemana + distanciaKm;
                totalDistanciaFinSemana = totalDistanciaFinSemana + distanciaKm;
                break;

        }
    }
    
     /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        String queSexo = " ";

        if(sexo == HOMBRE){
            queSexo = "Hombre";
        }
        else{
            queSexo = "Mujer";
        }
        System.out.println("Configuración del podómetro\n" +
                           "*********************************\n" +
                           "Altura: "+ (double)altura/100 +" metros\n" +
                           "Sexo: "+ queSexo +"\n" +
                           "Longitud zancada: "+ (double)longitudZancada/100 +" metros");
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {

        int horas = tiempo /60;

        int minutos = tiempo%60;


        System.out.println("Estadísticas\n" +
                           "*********************************\n" +
                           "Distancia recorrida toda la semana: "+ totalDistanciaSemana +" Km\n" +
                           "Distancia recorrida fin de semana: "+ totalDistanciaFinSemana +" Km\n" +
                           "\n" +
                           "Nº pasos días laborables: "+totalPasosLaborables +"\n" +
                           "Nº pasos SÁBADO: "+ totalPasosSabado +"\n" +
                           "Nº pasos DOMINGO: "+totalPasosDomingo +"\n" +
                           "\n" +
                           "Nº caminatas realizadas a partir de las 21h.: "+ caminatasNoche +"\n" +
                           "\n" +
                           "Tiempo total caminado en la semana:"+ horas +"h y "+ minutos +"m\n");

        

    }


    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        int maximo = Math.max(totalPasosLaborables, Math.max(totalPasosSabado, totalPasosDomingo));
        String resultado = "";

        if (totalPasosLaborables == maximo) {
            resultado += "LABORABLES ";
        }
        if (totalPasosSabado == maximo) {
            resultado += "SÁBADO ";
        }
        if (totalPasosDomingo == maximo) {
            resultado += "DOMINGO ";
        }
        return resultado.trim();
    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
         altura = 0;
         sexo = MUJER;
         longitudZancada = 0;
         totalPasosLaborables = 0;
         totalPasosSabado = 0;
         totalPasosDomingo = 0;
         totalDistanciaSemana = 0;
         totalDistanciaFinSemana = 0;
         tiempo = 0;
         caminatasNoche = 0;
        
        

    }

}
