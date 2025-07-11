package shaimaa.clinics.appointments.shared;

import shaimaa.clinics.appointments.internal.shell.repositories.AppointmentEntity;

import java.util.UUID;

public record CreateAppointmentRequest(
        UUID slotId,
        UUID patientId
) {

    AppointmentEntity toEntity() {
        return new AppointmentEntity();
    }
}
