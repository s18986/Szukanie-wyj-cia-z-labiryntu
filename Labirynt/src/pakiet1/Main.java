package pakiet1;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main  {


    public static void main (String[] args) throws FileNotFoundException {
            Plansza plansza =new Plansza();
            plansza.show();
            setS(plansza);
            System.out.println();
            setK(plansza);
    }
    public static void setS( Plansza plansza)
    {
        System.out.println("Wprowadz wspolrzedne punktu startowego rozdzielone przecinkiem");
        Scanner skaner = new Scanner(System.in);
        String response = skaner.next();
        String splitted[] = response.split(",");
        int x=Integer.parseInt(splitted[0])-1;
        int y=Integer.parseInt(splitted[1])-1;
        if(plansza.Data[y][x].typ==TileType.ALLOWED)
        {
            plansza.Data[y][x].setStatus("S");
            plansza.STARTER=plansza.Data[y][x];
        }else {
            System.out.println("Ten punkt nie moze byc startem");
            setS(plansza);
        }

    }
    public static void setK( Plansza plansza)
    {
        System.out.println("Wprowadz wspolrzedne punktu koncowego rozdzielone przecinkiem");
        Scanner skaner = new Scanner(System.in);
        String response = skaner.next();
        String splitted[] = response.split(",");
        int x=Integer.parseInt(splitted[0])-1;
        int y=Integer.parseInt(splitted[1])-1;
        if(plansza.Data[y][x].typ==TileType.ALLOWED)
        {
            plansza.Data[y][x].setStatus("K");
            plansza.KONIEC=plansza.Data[y][x];
            plansza.show();
            System.out.println();
            plansza.KONIEC.setValue(plansza.STARTER);
            plansza.STARTER.setValues(plansza.STARTER,plansza.KONIEC);
            plansza.STARTER.setSasiedzi(plansza);

        }else
        {
            System.out.println("Ten punkt nie moze byc koncem");
        }
    }
    public static void start(Tile tile, Plansza plansza)
    {

    }
}
