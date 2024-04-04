package aplicacao;

import excecao.DomainException;
import modelo.entidade.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class programa_Bom {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.println("Data do Check-in (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a data da alteração da sua reserva:");
            System.out.println("Data do Check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());


            reserva.novaDatas(checkin, checkout);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e){
            System.out.println("Data inválida");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado!");
        }
    }
}
