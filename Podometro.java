/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    -Erik Dafonte Da concepcion - 
 */
public class Podometro {
    public static char HOMBRE = 'H';
    public static char MUJER = 'M';
    public static Double RAZON_ZANCADA_HOMBRE = 0.45;
    public static Double RAZON_ZANCADA_MUJER = 0.41;
    public static Integer SABADO = 6;
    public static Integer DOMINGO = 7;

    private String marca;
    private int altura;
    private char sexo;
    private int longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private int totalDistanciaSemana;
    private int totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;



    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String marca,int altura, char sexo, int longitudZancada, int totalPasosLaborables, int totalPasosSabado, int totalPasosDomingo
    ,int totalDistanciaSemana, int totalDistanciaFinSemana, int tiempo, int caminatasNoche) {
        this.marca = marca;
        this.altura = 0;
        this.sexo = MUJER;
        this.longitudZancada = 0;
        this.totalPasosLaborables = 0;
        this.totalPasosSabado = 0;
        this.totalPasosDomingo = 0;
        this.totalDistanciaSemana = 0;
        this.totalDistanciaFinSemana = 0;
        this.tiempo = 0;
        this.caminatasNoche = 0;

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
            longitudZancada = (int) Math.ceil(queAltura * RAZON_ZANCADA_MUJER);
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
    public void registrarCaminata(int pasos, int dia, int horaInicio,
                            int horaFin) {
        double distanciaKm = pasos * longitudZancada / 100000.0;

        int minutosInicio = (horaInicio / 100) * 60 + (horaInicio % 100);
        int minutosFin = (horaFin / 100) * 60 + (horaFin % 100);

        tiempo += minutosFin - minutosInicio;
        if (horaInicio >= 2100){
            caminatasNoche ++;
        }

        switch (dia){
            case 1:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
            case 2:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
            case 3:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
            case 4:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
            case 5:
                totalPasosLaborables = totalPasosLaborables + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
            case 6:
                totalPasosSabado = totalPasosSabado + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
                totalDistanciaFinSemana = totalDistanciaFinSemana + (int)distanciaKm;
            case 7:
                totalPasosDomingo = totalPasosDomingo + pasos;
                totalDistanciaSemana = totalDistanciaSemana + (int)distanciaKm;
                totalDistanciaFinSemana = totalDistanciaFinSemana + (int)distanciaKm;
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

        

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {

        

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

         

    }
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        
        

    }

}
