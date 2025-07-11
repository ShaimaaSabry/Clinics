package shaimaa.clinics.booking.internal.domain.contracts;


import shaimaa.clinics.booking.internal.domain.model.Appointment;

public interface AppointmentsGateway {
    void createAppointment(Appointment appointment);
}
