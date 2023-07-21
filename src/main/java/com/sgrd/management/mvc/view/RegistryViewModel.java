package com.sgrd.management.mvc.view;

import java.util.List;

import com.sgrd.management.model.Registry;
import com.sgrd.management.model.RegistryDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistryViewModel {
    private Registry registry;
    private List<RegistryDetail> registryDetails;
}
