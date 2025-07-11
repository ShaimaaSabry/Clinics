package shaimaa.clinics.appointments.internal.shell.api.GetAppointments;

import shaimaa.clinics.appointments.internal.core.model.Patient;

import java.util.UUID;

record PatientDto(
        UUID id,
        String name
) {
    static PatientDto of(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName()
        );
    }
}
