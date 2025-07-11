package shaimaa.clinics.appointments.internal.shell.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.clinics.appointments.internal.core.exceptions.AppointmentNotFoundException;
import shaimaa.clinics.appointments.internal.core.model.Appointment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import shaimaa.clinics.appointments.internal.core.model.AppointmentStatus;
import shaimaa.clinics.appointments.internal.core.model.Patient;
import shaimaa.clinics.appointments.internal.shell.api.GetAppointments.GetAppointmentsResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/appointments")
@Tag(name = "Appointments", description = "Manage the patients' appointments.")
class AppointmentController {
//    private final AppointmentService appointmentService;
//
//    AppointmentController(final AppointmentService appointmentService) {
//        this.appointmentService= appointmentService;
//    }

    @GetMapping("upcoming")
    GetAppointmentsResponse getUpcomingAppointments() {
//        List<Appointment> appointments = this.appointmentService.getUpcomingAppointments();

        List<Appointment> appointments = List.of(
           new Appointment(
                UUID.randomUUID(),
                LocalDateTime.now(), // Assuming startsAt is not set for this example
                new Patient(UUID.randomUUID(), "John Doe"), // Mock patient
                AppointmentStatus.SCHEDULED
           )
        );

        return GetAppointmentsResponse.of(appointments);
    }

    @PatchMapping("{appointmentId}/cancel")
    void cancelAppointment(@PathVariable UUID appointmentId) throws AppointmentNotFoundException {
//        this.appointmentService.cancelAppointment(appointmentId);
    }

    @PatchMapping("{appointmentId}/complete")
    void completeAppointment(@PathVariable UUID appointmentId) throws AppointmentNotFoundException {
//        this.appointmentService.completeAppointment(appointmentId);
    }
}
