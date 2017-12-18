package com.wwe.api.wweapi.domain;

import com.wwe.api.wweapi.domain.model.Wrestler;

import java.util.List;

public interface WrestlerService {

    Wrestler getByID(String id);
    List<Wrestler> getAll();
}