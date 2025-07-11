package shaimaa.clinics.booking.internal.application.commands.BookSlot;

import java.util.UUID;

public record BookSlot(
        UUID slotId,
        UUID patientId
) {
}
