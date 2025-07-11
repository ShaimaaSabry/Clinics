package shaimaa.clinics.appointments.internal.core.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Slot {
    private UUID id;

    private LocalDateTime startsAt;
}
