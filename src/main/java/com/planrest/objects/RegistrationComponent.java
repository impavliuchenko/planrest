package com.planrest.objects;

import org.springframework.stereotype.Component;

@Component
public class RegistrationComponent {

    String selectedLocation;

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }
}
