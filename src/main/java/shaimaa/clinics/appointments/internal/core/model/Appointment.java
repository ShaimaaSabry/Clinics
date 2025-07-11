package shaimaa.clinics.appointments.internal.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Appointment {
    private UUID id;

    private LocalDateTime startsAt;

    private Patient patient;

    private AppointmentStatus status;

    public static Appointment newAppointment(UUID slotId, UUID patientId) {
        return new Appointment(
                null,
                null,
                null,
                AppointmentStatus.SCHEDULED
        );
    }

    public void complete() {
        this.status = AppointmentStatus.COMPLETE;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }
}
