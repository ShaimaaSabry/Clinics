package shaimaa.clinics.booking.internal.domain.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class Appointment {
    private UUID id;

    private UUID slotId;

    private UUID patientId;

    private LocalDateTime reservedAt;

    public static Appointment newAppointment(UUID slotId, UUID patientId) {
        return new Appointment(
                null,
                slotId,
                patientId,
                LocalDateTime.now()
        );
    }
}
