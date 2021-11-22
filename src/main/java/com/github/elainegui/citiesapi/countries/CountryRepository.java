package com.github.elainegui.citiesapi.countries;

import com.github.elainegui.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country,Long> {
}
