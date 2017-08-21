package org.kohli.services;

import java.util.Collection;

import org.kohli.object.Wrestler;
public interface WrestlerService {

    public Wrestler getByID(String id);
    public Collection<Wrestler> getAll();
}
