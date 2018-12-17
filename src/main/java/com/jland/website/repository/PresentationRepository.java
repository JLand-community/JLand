package com.jland.website.repository;

import com.jland.website.model.Presentation;

import java.util.List;

public interface PresentationRepository {

    List<Presentation> getPresentationsByConferenceId(Long conferenceId);
}
