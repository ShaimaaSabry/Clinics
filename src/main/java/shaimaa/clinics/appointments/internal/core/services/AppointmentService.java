package shaimaa.clinics.appointments.internal.core.services;

import shaimaa.clinics.appointments.internal.core.contracts.AppointmentRepository;
import shaimaa.clinics.appointments.internal.core.exceptions.AppointmentNotFoundException;
import shaimaa.clinics.appointments.internal.core.model.Appointment;

import java.util.List;
import java.util.UUID;

public class AppointmentService {
    private static final UUID DOCTOR_ID = null;

    private final AppointmentRepository appointmentRepository;

    AppointmentService(final AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getUpcomingAppointments() {
        return this.appointmentRepository.getUpcomingAppointments(DOCTOR_ID);
    }

    public void createAppointment(UUID slotId, UUID patientId) {
        Appointment appointment = Appointment.newAppointment(slotId, patientId);

        this.appointmentRepository.createAppointment(appointment);
    }

    public void cancelAppointment(UUID appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = this.appointmentRepository.getAppointment(appointmentId)
                .orElseThrow( () ->
                    AppointmentNotFoundException.notFound(appointmentId)
                );

        appointment.cancel();

        this.appointmentRepository.updateAppointment(appointment);
    }

    public void completeAppointment(UUID appointmentId) throws AppointmentNotFoundException {
        Appointment appointment = this.appointmentRepository.getAppointment(appointmentId)
                .orElseThrow( () ->
                        AppointmentNotFoundException.notFound(appointmentId)
                );

        appointment.complete();

        this.appointmentRepository.updateAppointment(appointment);
    }
}
