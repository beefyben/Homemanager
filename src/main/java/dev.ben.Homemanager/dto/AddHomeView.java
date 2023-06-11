package dev.ben.Homemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class AddHomeView {
        private String homename;
        private String homeaddress;
        private HomeView Homes;
    }
