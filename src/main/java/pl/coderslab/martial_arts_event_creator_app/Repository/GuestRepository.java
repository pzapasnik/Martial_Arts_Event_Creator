package pl.coderslab.martial_arts_event_creator_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.martial_arts_event_creator_app.Entity.User.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
