package shaimaa.clinics.slots.internal.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import shaimaa.clinics.slots.internal.repository.SlotEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(name = "Create Slot Response")
public record SlotDto (
        UUID id,
        LocalDateTime startsAt,
        float cost,
        boolean isReserved
) {
    public static SlotDto of(SlotEntity slotEntity) {
        return new SlotDto(
                slotEntity.getId(),
                slotEntity.getStartsAt(),
                slotEntity.getCost(),
                slotEntity.isReserved()
        );
    }
}
