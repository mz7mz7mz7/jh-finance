package com.example.application.views.empty;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Empty")
@Route(value = "empty", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class EmptyView extends Composite<VerticalLayout> {

    public EmptyView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
    }
}
