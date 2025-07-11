package shaimaa.clinics.slots.internal.api.GetSlots;

import shaimaa.clinics.slots.internal.api.dto.SlotDto;
import shaimaa.clinics.slots.internal.repository.SlotEntity;

import java.util.List;

public record GetSlotsResponse(
    List<SlotDto> slots
) {
    public static GetSlotsResponse of(List<SlotEntity> slots) {
        return new GetSlotsResponse(
                slots.stream().map(SlotDto::of).toList()
        );
    }
}
