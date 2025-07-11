package shaimaa.clinics.booking.internal.presentation.api.GetAvailbleSlots;

import io.swagger.v3.oas.annotations.media.Schema;
import shaimaa.clinics.booking.internal.domain.model.Slot;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(hidden = true)
public record AvailableSlotDto(
        UUID id,
        @Schema(implementation = DoctorDto.class)
        DoctorDto doctor,
        LocalDateTime startsAt,
        Float cost
) {
    static AvailableSlotDto from(Slot slot) {
        return new AvailableSlotDto(
                slot.getId(),
                DoctorDto.of(slot.getDoctor()),
                slot.getStartsAt(),
                slot.getCost()
        );
    }
}
