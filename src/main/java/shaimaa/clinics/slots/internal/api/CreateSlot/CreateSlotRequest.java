package shaimaa.clinics.slots.internal.api.CreateSlot;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import shaimaa.clinics.slots.internal.repository.SlotEntity;

import java.time.LocalDateTime;

public record CreateSlotRequest(
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime startsAt,

        @NotNull
        @PositiveOrZero
        Float cost
) {
    public SlotEntity toEntity() {
        return SlotEntity.builder()
                .startsAt(startsAt)
                .cost(cost)
                .build();
    }
}
