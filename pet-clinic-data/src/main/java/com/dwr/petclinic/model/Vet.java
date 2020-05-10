package com.dwr.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER) //fetchType.eager -> means that JPA  will load ManyToMany relationship by once
    @JoinTable(name = "vet_specialites",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name ="speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

}
