package com.example.application.views.visualviewbuilder;

import com.example.application.components.avataritem.AvatarItem;
import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Visual View Builder")
@Route(value = "visual-view-builder", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class VisualViewBuilderView extends Composite<VerticalLayout> {

    private HorizontalLayout layoutRow2 = new HorizontalLayout();

    private HorizontalLayout layoutRow = new HorizontalLayout();

    private VerticalLayout layoutColumn2 = new VerticalLayout();

    private ComboBox comboBox = new ComboBox();

    private Grid stripedGrid = new Grid(SamplePerson.class);

    private VerticalLayout layoutColumn3 = new VerticalLayout();

    private H1 h1 = new H1();

    private Button buttonSecondary = new Button();

    private Paragraph textLarge = new Paragraph();

    private MessageInput messageInput = new MessageInput();

    private MultiSelectListBox textItems = new MultiSelectListBox();

    private AvatarItem avatarItem = new AvatarItem();

    private Hr hr = new Hr();

    private Grid multiSelectGrid = new Grid(SamplePerson.class);

    private Grid minimalistGrid = new Grid(SamplePerson.class);

    public VisualViewBuilderView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutColumn2.setHeightFull();
        layoutColumn2.setWidth(null);
        comboBox.setLabel("Combo Box");
        setComboBoxSampleData(comboBox);
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        setGridSampleData(stripedGrid);
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        h1.setText("Heading");
        buttonSecondary.setText("Button");
        textLarge.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textLarge.getStyle().set("font-size", "var(--lumo-font-size-xl)");
        setTextItemsSampleData(textItems);
        setAvatarItemSampleData(avatarItem);
        multiSelectGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        setGridSampleData(multiSelectGrid);
        minimalistGrid.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        setGridSampleData(minimalistGrid);
        getContent().add(layoutRow2);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(comboBox);
        layoutColumn2.add(stripedGrid);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(h1);
        layoutColumn3.add(buttonSecondary);
        layoutColumn3.add(textLarge);
        layoutColumn3.add(messageInput);
        layoutColumn3.add(textItems);
        layoutColumn3.add(avatarItem);
        layoutColumn3.add(hr);
        layoutColumn3.add(multiSelectGrid);
        layoutColumn3.add(minimalistGrid);
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        comboBox.setItems("First", "Second", "Third", "Fourth");
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    private void setTextItemsSampleData(MultiSelectListBox multiSelectListBox) {
        multiSelectListBox.setItems("Show assignee", "Show due date", "Show status");
    }

    private void setAvatarItemSampleData(AvatarItem avatarItem) {
        avatarItem.setHeading("Aria Bailey");
        avatarItem.setDescription("Endocrinologist");
        avatarItem.setAvatar(new Avatar("Aria Bailey"));
    }
}
