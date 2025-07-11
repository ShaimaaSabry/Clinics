package shaimaa.clinics.booking.internal.presentation.api.BookSlot;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateBookingResponse (
        UUID bookingId,
        SlotDto slot,
        LocalDateTime reservedAt
) {

}
