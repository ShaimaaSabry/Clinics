package shaimaa.clinics.appointments.internal.shell.api.GetAppointments;

import shaimaa.clinics.appointments.internal.core.model.Appointment;

import java.time.LocalDateTime;
import java.util.UUID;

record AppointmentDto(
    UUID id,
    LocalDateTime startsAt,
    PatientDto patient

) {
    static AppointmentDto of(Appointment appointment) {
        return new AppointmentDto(
            appointment.getId(),
            appointment.getStartsAt(),
            PatientDto.of(appointment.getPatient())
        );
    }
}
