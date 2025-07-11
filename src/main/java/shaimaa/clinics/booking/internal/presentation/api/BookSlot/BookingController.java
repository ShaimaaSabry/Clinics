package shaimaa.clinics.booking.internal.presentation.api.BookSlot;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.clinics.booking.internal.application.commands.BookSlot.BookSlot;
import shaimaa.clinics.booking.internal.application.commands.BookSlot.BookSlotHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RestController
@RequestMapping("v1/slots")
@Tag(name = "Bookings", description = "Manage the booking of available slots.")
public class BookingController {
//    private final BookSlotHandler bookSlotHandler;
//
//    BookingController(final  BookSlotHandler bookSlotHandler) {
//        this.bookSlotHandler = bookSlotHandler;
//    }

    @PostMapping("{slotId}/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    CreateBookingResponse book(@PathVariable UUID slotId) {
//        BookSlot command = new BookSlot(slotId, null);
//        this.bookSlotHandler.handle(command);

        return new CreateBookingResponse(
                UUID.randomUUID(), // Simulating a booking ID
                new SlotDto(slotId), // Simulating the booked slot
                java.time.LocalDateTime.now() // Simulating the reservation time
        );
    }
}
