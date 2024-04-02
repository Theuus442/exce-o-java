package aplicacao;

import modelo.entidade.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class programa_muitoRuim {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Número do quarto: ");
        int numero = sc.nextInt();
        System.out.println("Data do Check-in (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Data do Check-out (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkin)) {
            System.out.println("Erro na sua reserva: a data do Check-out é antes do seu Check-in");
        } else {
            Reserva reserva = new Reserva(numero, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a data da alteração da sua reserva:");
            System.out.println("Data do Check-in (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.println("Data do Check-out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());


            Date agora = new Date();

            if (checkin.before(agora) || checkout.before(agora)) {
                System.out.println("Erro na sua reserva: A reserva tem que ter datas futuras!");
            } else if (!checkout.after(checkin)) {
                System.out.println("Erro na sua reserva: a data do Check-out é antes do seu Check-in");
            }
            else {
                reserva.novaDatas(checkin, checkout);
                System.out.println("Reserva: " + reserva);
            }
        }


        sc.close();
    }
}
