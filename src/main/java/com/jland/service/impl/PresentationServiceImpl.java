package com.jland.service.impl;

import com.jland.model.Presentation;
import com.jland.repository.PresentationRepository;
import com.jland.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationServiceImpl implements PresentationService {

    private PresentationRepository presentatopnRepository;

    @Autowired
    public PresentationServiceImpl(PresentationRepository presentatopnRepository) {
        this.presentatopnRepository = presentatopnRepository;
    }

    public List<Presentation> getAll() {
//        return presentatopnRepository.getAll();
        return null;
    }
}
