package shaimaa.clinics.booking.internal.presentation.api.GetAvailbleSlots;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.clinics.booking.internal.application.queries.GetAvailableSlots.GetAvailableSlotsHandler;
import shaimaa.clinics.booking.internal.domain.model.Doctor;
import shaimaa.clinics.booking.internal.domain.model.Slot;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/slots")
@Tag(name = "Slots", description = "Manage the doctor's available and reserved slots.")
class GetAvailableSlotsController {
//    private final GetAvailableSlotsHandler getAvailableSlotsHandler;
//
//    GetAvailableSlotsController(final GetAvailableSlotsHandler getAvailableSlotsHandler) {
//        this.getAvailableSlotsHandler = getAvailableSlotsHandler;
//    }

    @GetMapping("available")
    GetAvailableSlotsResponse getAvailableSlots() {
//        List<Slot> slots = this.getAvailableSlotsHandler.handle();

        Doctor doctor = new Doctor("Dr. Yara");

        List<Slot> slots = List.of(
                new Slot(UUID.randomUUID(), doctor, LocalDateTime.now().plusDays(1), 50.0f),
                new Slot(UUID.randomUUID(), doctor, LocalDateTime.now().plusDays(2), 75.0f),
                new Slot(UUID.randomUUID(), doctor, LocalDateTime.now().plusDays(3), 100.0f)
        );

        return GetAvailableSlotsResponse.of(slots);
    }
}
