package com.jland.website.service.impl;

import com.jland.website.model.Event;
import com.jland.website.model.Presentation;
import com.jland.website.model.PresentationPlan;
import com.jland.website.repository.EventRepository;
import com.jland.website.repository.PresentationPlanRepository;
import com.jland.website.service.EventService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PresentationPlanRepository presentationPlanRepository;

    public EventServiceImpl(EventRepository eventRepository, PresentationPlanRepository presentationPlanRepository) {
        this.eventRepository = eventRepository;
        this.presentationPlanRepository = presentationPlanRepository;
    }

    @Override
    public List<Event> getAllByConferenceId(Long conferenceId) {

        List<Event> events = eventRepository.getAllByConferenceId(conferenceId);
        for(Event event : events) {
            if("Presentation".equals(event.getType())){
                Presentation presentation = event.getPresentation();
                long id = presentation.getId();
                List<PresentationPlan> planItems = presentationPlanRepository.getAllByPresentationId(id);
                presentation.setItems(planItems);
            }
        }
        return events;
    }
}
