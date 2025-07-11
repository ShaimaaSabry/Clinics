package shaimaa.clinics.booking.internal.presentation.api.BookSlot;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(hidden = true)
public record SlotDto(
        UUID slotId
) {
}
