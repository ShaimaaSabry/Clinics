package shaimaa.clinics.booking.internal.presentation.api.GetAvailbleSlots;

import shaimaa.clinics.booking.internal.domain.model.Slot;

import java.util.List;

public record GetAvailableSlotsResponse(
        List<AvailableSlotDto> availableSlots
) {
    public static GetAvailableSlotsResponse of(List<Slot> slots) {
        return new GetAvailableSlotsResponse(
                slots.stream().map(AvailableSlotDto::from).toList()
        );
    }
}
