package pl.coderslab.martial_arts_event_creator_app.Model.User;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Controller;
import pl.coderslab.martial_arts_event_creator_app.Enum.RoleName;
import pl.coderslab.martial_arts_event_creator_app.Model.Event.Event;
import pl.coderslab.martial_arts_event_creator_app.Model.Event.Federation;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Email
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    @NotEmpty
    @Column(nullable = false)
    private String lastName;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotEmpty
    @Column(nullable = false)
    private String address;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    FIGHTER DETAILS

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FighterDetails fighterDetails;

//    MENAGER DETAILS

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "federation_id")
    private Federation federation;


//    ATENDING EVENTS

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_events", joinColumns = { @JoinColumn(name = "users_id") },
            inverseJoinColumns = { @JoinColumn(name = "events_id" )})
    private Set<Event> events;


    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public FighterDetails getFighterDetails() {
        return fighterDetails;
    }

    public void setFighterDetails(FighterDetails fighterDetails) {
        this.fighterDetails = fighterDetails;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation federation) {
        this.federation = federation;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

}