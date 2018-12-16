package com.jland.repository;

import com.jland.model.Presentation;

import java.util.List;

public interface PresentationRepository {

    List<Presentation> getPresentationsByConferenceId(Long conferenceId);
}
