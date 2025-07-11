package shaimaa.clinics.appointments.internal.shell.api.GetAppointments;

import shaimaa.clinics.appointments.internal.core.model.Appointment;

import java.util.List;

public record GetAppointmentsResponse(
        List<AppointmentDto> appointments
) {
    public static GetAppointmentsResponse of(List<Appointment> appointments) {
        return new GetAppointmentsResponse(
                appointments.stream()
                        .map(AppointmentDto::of)
                        .toList()
        );
    }
}
