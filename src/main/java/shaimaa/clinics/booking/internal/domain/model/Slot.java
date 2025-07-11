package shaimaa.clinics.booking.internal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Slot {
    private UUID id;

    private Doctor doctor;

    private LocalDateTime startsAt;

    private Float cost;
}
