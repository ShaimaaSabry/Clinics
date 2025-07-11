package shaimaa.clinics.booking.internal.application.commands.BookSlot;

import shaimaa.clinics.booking.internal.domain.contracts.AppointmentsGateway;
import shaimaa.clinics.booking.internal.domain.model.Appointment;

public class BookSlotHandler {
    private final AppointmentsGateway appointmentsGateway;

    BookSlotHandler(final AppointmentsGateway appointmentsGateway) {
        this.appointmentsGateway = appointmentsGateway;
    }

    public void handle(BookSlot command) {
        Appointment appointment = Appointment.newAppointment(command.slotId(), command.patientId());

        this.appointmentsGateway.createAppointment(appointment);
    }
}
