package shaimaa.clinics.appointments.internal.core.contracts;

import shaimaa.clinics.appointments.internal.core.model.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {
    List<Appointment> getUpcomingAppointments(UUID doctorId);

    Optional<Appointment> getAppointment(UUID appointmentId);

    void createAppointment(Appointment appointment);

    void updateAppointment(Appointment appointment);
}
