package learn.dontwreckmyhouse;

import learn.dontwreckmyhouse.data.ReservationFileRepository;
import learn.dontwreckmyhouse.data.GuestFileRepository;
import learn.dontwreckmyhouse.data.HostFileRepository;
import learn.dontwreckmyhouse.domain.ReservationService;
import learn.dontwreckmyhouse.ui.ConsoleIO;
import learn.dontwreckmyhouse.ui.Controller;
import learn.dontwreckmyhouse.ui.View;


public class App {

    public static void main(String[] args) {

        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        ReservationFileRepository reservationFileRepository = new ReservationFileRepository("./data/reservations");

        GuestFileRepository guestFileRepository = new GuestFileRepository("./data/guests.csv");
        HostFileRepository hostFileRepository = new HostFileRepository("./data/hosts.csv");
        ReservationService reservationService = new ReservationService(reservationFileRepository, guestFileRepository, hostFileRepository);

        Controller controller = new Controller(reservationService, view);
        controller.run();
    }
}
