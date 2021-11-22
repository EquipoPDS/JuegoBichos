import java.util.*;

public class Bichos
{
    Bicho[][] bichos = new Bicho[2][2];
    int numbichos;
    
    Bichos(){
        Random random = new Random();
        numbichos = random.nextInt(4); 
        int count = 0;
        
        while(count < numbichos){
            int tipo = random.nextInt()%2;
            Bicho b;
            if (tipo == 0){
                b = new Bicho("BN",10);
            }else{
                b = new Bicho("BA",20);
            } 
            if (count<2){
                bichos[0][count]= b;     
            }else{
                bichos[1][count-2]= b;
            }
            count++;
        }
        
    }
    
    void mostrarTablero(){
        for (int x=0; x < 2; x++) {
            System.out.print("| ");
            for (int y=0; y < 2; y++) {
                if (bichos[x][y] != null){
                    System.out.print(" "+bichos[x][y].getNombre()+"-"+bichos[x][y].getSalud()+" ");
                }else{
                    System.out.print("       ");
                }
            }
            System.out.print(" |\n");
        } 
    }
    
    public void duplicar(){
        
        int i=0, j=0;
        
        bichos[i][j].multiplicarVida();
    }
    
    public boolean termina(){
        for (int x=0;x<2;x++) {
            for (int y=0;y<2;y++) {
                if (bichos[x][y].getSalud() != 10) {
                    return false;
                }
            }                
        }
        return true;
    }
    
    public void menu() {
 
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            mostrarTablero();
            System.out.println("\n-------------------");
            System.out.println("1. Dispara una bala");
            System.out.println("2. Activar bomba atómica");
            System.out.println("3. Activar bicho mutante");
            System.out.println("4. frase inspiradora de la abuela");
 
            try {
 
                System.out.println("Seleccione opcion: ");
                opcion = sn.nextInt();
                int x, y;
 
                switch (opcion) {
                    case 1:
                        System.out.println("posicion x=");
                        x = sn.nextInt();
                        System.out.println("posicion y=");
                        y = sn.nextInt();
                        bichos[x][y].sumarVida(5);
                        break;
                    case 2:
                        Random random = new Random();
                        //x = random.nextInt(4); 
                        //y = random.nextInt(4);
                        bichos[0][0].setSalud(0);
                        break;
                    case 3:
                        duplicar();
                        if (termina())
                            salir = true;
                        break;
                    case 4:
                        System.out.println("Mijo recuerde que con maña, caza a la mosca la araña.");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
