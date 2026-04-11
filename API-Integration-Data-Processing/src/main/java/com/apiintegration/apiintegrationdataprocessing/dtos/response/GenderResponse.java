package com.apiintegration.apiintegrationdataprocessing.dtos.response;

import lombok.Data;

@Data
public class GenderResponse {
        private String name;
        private String gender;
        private Double probability;
        private Integer sample_size;
        private Boolean is_confident;
        private String processed_at;
}
