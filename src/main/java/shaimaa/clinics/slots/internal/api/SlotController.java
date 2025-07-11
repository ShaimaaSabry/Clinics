package shaimaa.clinics.slots.internal.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import shaimaa.clinics.slots.internal.api.CreateSlot.CreateSlotRequest;
import shaimaa.clinics.slots.internal.api.GetSlots.GetSlotsResponse;
import shaimaa.clinics.slots.internal.api.dto.SlotDto;
import shaimaa.clinics.slots.internal.business.SlotService;
import shaimaa.clinics.slots.internal.repository.SlotEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/slots")
@Tag(name = "Slots", description = "Manage the doctor's available and reserved slots.")
class SlotController {
    private final SlotService slotService;

    SlotController(final SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping
    GetSlotsResponse getSlots() {
        List<SlotEntity> slots = this.slotService.getSlots();
        return GetSlotsResponse.of(slots);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SlotDto createSlot(@Valid @RequestBody CreateSlotRequest request) {
        SlotEntity slot =this.slotService.createSlot(request.toEntity());

        return SlotDto.of(slot);
    }
}
